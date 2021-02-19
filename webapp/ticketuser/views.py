from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages
from .models import TicketUser

from core.utils import check_ticketuser

import hashlib


class TicketUserDashboardView(View):
    @check_ticketuser
    def get(self, request):
        return render(request, 'ticketuser/dashboard.html')


class TicketUserSignUpView(View):

    def get(self, request):
        return render(request, 'ticketuser/signup.html')

    def post(self, request):
        email = request.POST.get('email')
        password = request.POST.get('password')
        password = hashlib.sha256(password.encode()).hexdigest()
        full_name = request.POST.get('full_name')

        email_count = TicketUser.objects.filter(email=email)
        email_count = len(email_count)

        if email_count > 0:
            messages.error(request, "An account with this email exists.")
            return redirect('ticketuser-signup-view')

        else:
            ticket_user = TicketUser(email=email, password=password, full_name=full_name)
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

