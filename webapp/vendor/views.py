from django.shortcuts import render, HttpResponse, redirect
from django.contrib.auth.models import User
from django.contrib.auth import authenticate, login, logout
from django.contrib import messages


def vendorSignUp(request):
        return render(request, 'vendor/vendorSignUp.html')

def handleSignUp(request):

        if(request.method == 'POST'):
            vendorEmail= request.POST['vendorEmail']
            vendorEmail= request.POST['vendorEmail']
            vendorPassword = request.POST['vendorPassword']
            vendorAddress = request.POST['vendorAddress']

        print(vendorName, vendorEmail, vendorPassword)
        
        return HttpResponse('signup successful')
