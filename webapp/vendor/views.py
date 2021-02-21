from django.views import View
from django.shortcuts import render, redirect
from django.contrib import messages
from django.shortcuts import render, redirect, HttpResponse
from .models import Vendor

import hashlib


class VendorSignupView(View):

    def get(self, request):
        return render(request, 'vendor/signup.html')

    def post(self, request):
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
            vendor = Vendor(email=email, password=password, vendor_name=vendor_name, category=category)
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

        ticketgroup_list = TicketGroup.objects.filter(vendor=vendor)
        context = {'ticketgroup_list': ticketgroup_list}

        return render(request, 'vendor/issued-ticket.html', context)
