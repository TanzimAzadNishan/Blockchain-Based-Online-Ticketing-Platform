from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages

from core.utils import check_vendor, check_ticketuser, check_logged_in
from ticket.models import TicketGroup
from vendor.models import Vendor

from datetime import datetime


class TicketInfoView(View):

    @check_logged_in
    def get(self, request):
        """
        Fetch ticket information from the Blockchain network
        """
        return render(request, 'ticket/ticket-info.html')


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


""" @TicketBuyView / @BuyTicketView """
class BuyTicketView(View):

    def get(self, request):
        messages.success(request, "You have bought this ticket !")
        return redirect('ticketuser-dashboard-view')

    def post(self, request):
        owner_hash = request.POST.get('owner_hash')
        ticketgroup_hash = request.POST.get('ticketgroup_hash')

        """
        BLOCKCHAIN NETWORK
        -
        Make smart contracts to sell ticket to this user and return the ticket hash.
        """
        # @param ticket_hash
        return redirect('ticket-info-view')


class ResellTicketView(View):

    def get(self, request):
        messages.success(request, "You have resell this ticket !")
        return redirect('ticketuser-dashboard-view')

    def post(self, request):

        owner_hash = request.POST.get('owner_hash')
        new_owner_hash = request.POST.get('new_owner_hash')
        ticket_hash = request.POST.get('ticket_hash')
        """
        BLOCKCHAIN NETWORK
        -
        Make smart contracts to resell ticket to this receiver and return the ticket hash.
        """
        return redirect('ticketuser-dashboard-view')


class RefundTicketView(View):

    def get(self, request):
        messages.success(request, "You have refund this ticket !")
        return redirect('ticketuser-dashboard-view')

    def post(self, request):
        owner_hash = request.POST.get('owner_hash')
        ticket_hash = request.POST.get('ticket_hash')

        """
        BLOCKCHAIN NETWORK
        -
        Make smart contracts to refund this ticket.
        """
        return redirect('ticketuser-dashboard-view')
        