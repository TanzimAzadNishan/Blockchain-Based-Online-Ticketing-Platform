from django.views import View
from django.shortcuts import render, redirect
from django.contrib import messages
from .models import Vendor

from core.utils import check_vendor

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

