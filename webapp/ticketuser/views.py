from django.shortcuts import render
from django.views import View


class TicketUserDashboardView(View):
    def get(self, request):
        return render(request, 'ticketuser/dashboard.html')
