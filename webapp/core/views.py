from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages

from .utils import verify_auth_token
from ticketuser.models import TicketUser
from vendor.models import Vendor

import hashlib


class UserLoginView(View):

    def get(self, request):
        return render(request, 'core/login.html')

    def post(self, request):

        email = request.POST.get('email')
        password = request.POST.get('password')
        password = hashlib.sha256(password.encode()).hexdigest()
        user_type = request.POST.get('user_type')

        if user_type == "ticket_user":
            
            ticket_user = TicketUser.objects.get(email=email)

            if ticket_user is None:
                messages.error(request, "Email not found.")
                return redirect('login-view')

            else:

                if ticket_user.password == password:
                    print(ticket_user)
                    request.session['user_type'] = user_type
                    request.session['user_id'] = ticket_user.id
                    
                    messages.success(request, "Welcome Customer!")
                    return redirect('ticket-user-dashboard-view')

                else:
                    messages.error(request, "Wrong Password !")
                    return redirect('login-view')

        elif user_type == "vendor":
            
            try:
                vendor = Vendor.objects.get(email=email)

                if vendor.password == password:
                    print(vendor)
                    request.session['user_type'] = user_type
                    request.session['user_id'] = vendor.id
                    
                    messages.success(request, "Welcome Vendor!")
                    return redirect('vendor-dashboard-view')

                else:
                    messages.error(request, "Wrong Password !")
                    return redirect('login-view')

            except Vendor.DoesNotExist:
                messages.error(request, "Email not found.")
                return redirect('login-view')

        else:
            messages.info(request, "Enter form correctly !")
            return redirect('login-view')


class UserLogoutView(View):

    def get(self, request):
        request.session.pop('user_id', None)
        request.session.pop('user_type', None)

        messages.success(request, "You have been logged out!")
        return redirect('login-view')
    