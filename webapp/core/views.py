from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages

from .utils import verify_auth_token
from ticketuser.models import TicketUser
from vendor.models import Vendor

import hashlib


class IndexView(View):

    def get(self, request):
        return render(request, 'core/index.html')


class UserLoginView(View):

    def get(self, request):
        return render(request, 'core/login.html')

    def post(self, request):

        email = request.POST.get('email')
        password = request.POST.get('password')
        password = hashlib.sha256(password.encode()).hexdigest()
        user_type = request.POST.get('user_type')

        if user_type == "ticket_user":
            ticket_user = TicketUser.objects.filter(email=email)

            if len(ticket_user) == 0:
                messages.error(request, "Email not found.")
                return redirect('login-view')

            else:
                if ticket_user[0].password == password:
                    print(ticket_user[0])
                    request.session['user_type'] = user_type
                    request.session['user_id'] = ticket_user[0].id
                    
                    messages.success(request, "Welcome Customer!")
                    return redirect('ticketuser-dashboard-view')

                else:
                    messages.error(request, "Wrong Password !")
                    return redirect('login-view')

        elif user_type == "vendor":            
            vendor = Vendor.objects.filter(email=email)

            if len(vendor) == 0:
                messages.error(request, "Email not found.")
                return redirect('login-view')

            else:
                if vendor[0].password == password:
                    print(vendor[0])
                    request.session['user_type'] = user_type
                    request.session['user_id'] = vendor[0].id
                
                    messages.success(request, "Welcome Vendor!")
                    return redirect('vendor-dashboard-view')

                else:
                    messages.error(request, "Wrong Password !")
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
    
