import hashlib
import jwt
import threading

from datetime import datetime, timedelta
from django.contrib import messages

from django.views import View
from django.contrib import messages
from django.shortcuts import render, redirect, HttpResponse
from .models import Vendor


class VendorRegisterView(View):

    def get(self, request):
            return render(request, 'vendor/vendorSignUp.html')

    def post(self, request):

        email = request.POST.get('email')
        password = request.POST.get('pass1')
        password_confirm = request.POST.get('pass2')
        vendor_type = request.POST.get('vendor_type')

        name = request.POST.get('name')

        vendorCheck = Vendor.objects.filter(vendor_name=name) | Vendor.objects.filter(email=email)

        if vendorCheck:
            messages.error(request, "already taken")
            return redirect('vendor-signup-view')

        if (password != password_confirm):
                messages.warning(request, 'PassWords do not match!')
                return redirect('vendor-signup-view')
        
        vendor_obj = Vendor(vendor_name=name, email=email, password=password, vendor_type= vendor_type)
        vendor_obj.save()

        return HttpResponse('SignUp Completed!')

        
