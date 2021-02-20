from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages

from core.utils import check_vendor, check_ticketuser, check_logged_in
from ticket.models import TicketGroup
from vendor.models import Vendor

from datetime import datetime


class TicketInfoView(View):

    @check_logged_in
    def get(self, request, ticket_hash):
        """
        Fetch ticket information from the Blockchain network
        """
        return render(request, 'ticket-info.html')


class VerifyTicketView(View):

    @check_logged_in
    def post(self, request):
        ticket_hash = request.POST.get('ticket_hash')
        """
        Make query to the network and find details about it
        """
        return render(request, 'ticket/verify-ticket.html')


class BusTicketListView(View):

    @check_ticketuser
    def get(self, request):
        """
        Fetch all available bus tickets from the network
        """
        context = {
            'category': "Bus"
        }
        return render(request, 'ticket/ticket-list.html', context)


class ShipTicketListView(View):

    @check_ticketuser
    def get(self, request):
        """
        Fetch all available ship tickets from the network
        """
        context = {
            'category': "Ship"
        }
        return render(request, 'ticket/ticket-list.html', context)


class MovieTicketListView(View):

    @check_ticketuser
    def get(self, request):
        """
        Fetch all available movie tickets from the network
        """
        context = {
            'category': "Movie"
        }
        return render(request, 'ticket/ticket-list.html', context)


class EventTicketListView(View):

    @check_ticketuser
    def get(self, request):
        """
        Fetch all available event tickets from the network
        """
        context = {
            'category': "Event"
        }
        return render(request, 'ticket/ticket-list.html', context)

"""
Vendor interaction part
"""

class IssueTicketView(View):

    def get(self, request):
        return render(request, 'ticket/issue-ticket.html')

    def post(self, request):        
        group_name = request.POST.get('group_name')
        vendor_id = request.session.get('user_id')
        vendor = Vendor.objects.get(id=vendor_id)
        
        n_ticket = request.POST.get('n_ticket')
        n_ticket = int(n_ticket)
        timestamp = request.POST.get('datetime')
        price = request.POST.get('price')
        price = int(price)

        """
            AT THIS PHASE,
            ask the network to create an event and send back the hash
        """
        unique_hash = "..."

        ticket_group = TicketGroup  (
                                        vendor=vendor,
                                        name=group_name,
                                        n_ticket=n_ticket,
                                        datetime=timestamp,
                                        price=price,
                                        unique_hash=unique_hash
                                    )
        ticket_group.save()

        messages.success(request, "Ticket group has been created !")
        return redirect('issue-ticket-view')
