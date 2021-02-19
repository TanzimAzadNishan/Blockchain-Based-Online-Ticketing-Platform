from datetime import timedelta, datetime
from webapp.settings import SECRET_KEY
from django.utils.decorators import wraps
from django.shortcuts import render, redirect
from django.contrib import messages


def check_logged_in(func):
    
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        user_type = request.session.get('user_type')

        if not user_type:
            messages.warning(request, "You must login first!")
            return redirect('login-view')    

        return func(self, request, *args, **kwargs)
    return wrapped


def check_ticketuser(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        if request.session.get('user_type') == 'ticket_user':
            return func(self, request, *args, **kwargs)
        else:
            return redirect('http-403-view')
    return wrapped


def check_vendor(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        if request.session.get('user_type') == 'vendor':
            return func(self, request, *args, **kwargs)
        else:
            return redirect('http-403-view')
    return wrapped
