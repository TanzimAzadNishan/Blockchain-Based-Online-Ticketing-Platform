from django.views import View
from django.shortcuts import render, redirect
from django.contrib import messages
from django.shortcuts import render, redirect, HttpResponse
from .models import Vendor
from ticket.models import TicketGroup

import asyncio
import threading

from core.utils import check_vendor
from webapp.settings import CORDA_API_HOST

import hashlib
import time
import openapi_client
import cordapps_api

import openapi_client.model.states_event_state
from openapi_client.model.net_corda_core_contracts_unique_identifier import NetCordaCoreContractsUniqueIdentifier
from openapi_client.model.generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload import GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from openapi_client.model.generated_flows_event_register_flow_event_register_flow_initiator_payload import GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload
from openapi_client.model.generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload import GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from pprint import pprint


from openapi_client.model.generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload import GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload
from openapi_client.model.invocation_error import InvocationError


configuration = openapi_client.Configuration(host=CORDA_API_HOST)


class VendorSignupView(View):

    def get(self, request):
        return render(request, 'vendor/signup.html')

    def post(self, request):

        # Enter a context with an instance of the API client
        with openapi_client.ApiClient() as api_client:
            # Create an instance of the API class
            api_instance = cordapps_api.CordappsApi(api_client)
            generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload = GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload(
                percentage=3.14,
            ) # GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload | payload

            # example passing only required values which don't have defaults set
            try:
                api_response = api_instance.cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator(generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload)
                pprint(api_response)
            except openapi_client.ApiException as e:
                print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator: %s\n" % e)

        unique_hash = api_response["id"]

        email = request.POST.get("email")
        password = request.POST.get("password")
        password = hashlib.sha256(password.encode()).hexdigest()
        vendor_name = request.POST.get("vendor_name")
        category = request.POST.get("category")

        email_count = Vendor.objects.filter(email=email)
        email_count = len(email_count)

        if email_count > 0:
            messages.error(request, "A vendor account with this email exists.")
            return redirect('vendor-signup-view')

        else:
            vendor = Vendor(email=email, password=password, vendor_name=vendor_name, category=category, unique_hash=unique_hash)
            vendor.save()
            print(vendor_name)
            messages.success(request, "A vendor account has been created !")
            return redirect('login-view')


class VendorDashboardView(View):

    @check_vendor
    def get(self, request):
        return render(request, 'vendor/dashboard.html')


class IssueTicketView(View):

    def post(self, request):

        group_name = request.POST.get('group_name')
        vendor_id = request.session.get('user_id')
        vendor = Vendor.objects.get(id=vendor_id)
        
        n_ticket = request.POST.get('n_ticket')
        n_ticket = int(n_ticket)
        timestamp = request.POST.get('datetime')
        price = request.POST.get('price')
        price = int(price)

        with openapi_client.ApiClient() as api_client:
            # Create an instance of the API class
            api_instance = cordapps_api.CordappsApi(api_client)
            generated_flows_event_register_flow_event_register_flow_initiator_payload = GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload(
                vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
                    external_id="",
                    id=vendor.unique_hash,
                ),
                event_date=timestamp,
                total_tickets=n_ticket,
            ) # GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload | payload

            try:
                api_response = api_instance.cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator(generated_flows_event_register_flow_event_register_flow_initiator_payload)
                pprint(api_response)
            except openapi_client.ApiException as e:
                print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator: %s\n" % e)

        event_unique_hash = api_response["id"]

        # Enter a context with an instance of the API client
        with openapi_client.ApiClient() as api_client:
            # Create an instance of the API class
            api_instance = cordapps_api.CordappsApi(api_client)
            generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload = GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload(
                vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
                    external_id="",
                    id=vendor.unique_hash,
                ),
                event_linear_id=NetCordaCoreContractsUniqueIdentifier(
                    external_id="",
                    id=event_unique_hash,
                ),
                no_of_tickets_to_be_issued=n_ticket,
                price=float(price),
                refund_amount=float(price),
                event_date=timestamp,
            ) # GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload | payload

            try:  
                api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator(generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload)
                pprint(api_response)            
            except openapi_client.ApiException as e:
                print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator: %s\n" % e)


        ticket_group = TicketGroup  (
                                        vendor=vendor,
                                        name=group_name,
                                        n_ticket=n_ticket,
                                        datetime=timestamp,
                                        price=price,
                                        unique_hash=event_unique_hash
                                    )
        ticket_group.save()

        messages.success(request, "Ticket group has been created !")
        return redirect('vendor-dashboard-view')


""" issued ticket list """
class IssuedTicketGroupView(View):

    def get(self, request):
        """
            BLOCKCHAIN NETWORK
            -
            Query for the issued ticket groups?
        """
        vendor_id = request.session.get('user_id')
        vendor = Vendor.objects.get(id=vendor_id)

        # Enter a context with an instance of the API client
        with openapi_client.ApiClient() as api_client:
            # Create an instance of the API class
            api_instance = cordapps_api.CordappsApi(api_client)
            generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload = GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload(
                vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
                    external_id="",
                    id=vendor.unique_hash,
                ),
            ) # GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload | payload

            try:
                api_response = api_instance.cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator(generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload)
                pprint(api_response)
                print(api_response.readable())

            except openapi_client.ApiException as e:
                print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator: %s\n" % e)



        ticketgroup_list = TicketGroup.objects.filter(vendor=vendor)
        context = {'ticketgroup_list': ticketgroup_list}

        return render(request, 'vendor/issued-ticket.html', context)
