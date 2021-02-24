from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages
from .models import TicketUser

from core.utils import check_ticketuser
from webapp.settings import CORDA_API_HOST

import hashlib
import time
import openapi_client

import cordapps_api
from openapi_client.model.net_corda_core_contracts_unique_identifier import NetCordaCoreContractsUniqueIdentifier
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(host=CORDA_API_HOST)


class TicketUserDashboardView(View):
    @check_ticketuser
    def get(self, request):
        return render(request, 'ticketuser/dashboard.html')


class TicketUserSignUpView(View):

    def get(self, request):
        return render(request, 'ticketuser/signup.html')

    def post(self, request):
        with openapi_client.ApiClient() as api_client:
            api_instance = cordapps_api.CordappsApi(api_client)
            body = {}

            try:
                api_response = api_instance.cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator(body)
                pprint(api_response)
                print(type(api_response))
                print()
                print(api_response)
                print()
            except openapi_client.ApiException as e:
                print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator: %s\n" % e)

        email = request.POST.get('email')
        password = request.POST.get('password')
        password = hashlib.sha256(password.encode()).hexdigest()
        full_name = request.POST.get('full_name')
        unique_hash = api_response["id"]

        email_count = TicketUser.objects.filter(email=email)
        email_count = len(email_count)

        if email_count > 0:
            messages.error(request, "An account with this email exists.")
            return redirect('ticketuser-signup-view')

        else:
            ticket_user = TicketUser(
                email=email, password=password, full_name=full_name, unique_hash=unique_hash)
            ticket_user.save()
            print(ticket_user)
            messages.success(request, "An account has been created !")
            return redirect('login-view')


class TickerUserWalletView(View):

    @check_ticketuser
    def get(self, request):
        """
        Gotta make request to CorDapp to get information
        of tickets for this user
        """
        return render(request, 'ticketuser/wallet.html')
