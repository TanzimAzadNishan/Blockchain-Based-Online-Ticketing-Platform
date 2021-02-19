from django.shortcuts import render, redirect
from django.views import View


class TicketInfoView(View):

    def get(self, request, ticket_hash):
        """
        Fetch ticket information from the Blockchain network
        """
        return render(request, 'ticket-info.html')


class VerifyTicketView(View):

    def post(self, request):
        ticket_hash = request.POST.get('ticket_hash')
        """
        Make query to the network and find details about it
        """
        return render(request, 'ticket/verify-ticket.html')


class BusTicketListView(View):

    def get(self, request):
        """
        Fetch all available bus tickets from the network
        """
        context = {
            'category': "Bus"
        }
        return render(request, 'ticket/ticket-list.html', context)


class ShipTicketListView(View):

    def get(self, request):
        """
        Fetch all available ship tickets from the network
        """
        context = {
            'category': "Ship"
        }
        return render(request, 'ticket/ticket-list.html', context)


class MovieTicketListView(View):

    def get(self, request):
        """
        Fetch all available movie tickets from the network
        """
        context = {
            'category': "Movie"
        }
        return render(request, 'ticket/ticket-list.html', context)


class EventTicketListView(View):

    def get(self, request):
        """
        Fetch all available event tickets from the network
        """
        context = {
            'category': "Event"
        }
        return render(request, 'ticket/ticket-list.html', context)

