from datetime import timedelta, datetime
from webapp.settings import SECRET_KEY
from django.utils.decorators import wraps
from django.shortcuts import render, redirect
from django.contrib import messages

import jwt


def create_auth_token(user_id):
    auth_token = jwt.encode(
        {
            'user_id': user_id,
            'exp': datetime.now() + timedelta(seconds=600000)
        }, SECRET_KEY, algorithm='HS256'
    ).decode('utf-8')
    return auth_token


def verify_auth_token(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        auth_token = request.session.get('auth_token')

        if not auth_token:
            messages.warning(request, 'Session expired. Please log in again.')
            return redirect('login-view')

        try:
            auth_data = jwt.decode(auth_token, SECRET_KEY, algorithms=['HS256'])
        except:
            messages.warning(request, 'Session expired. Please log in again.')
            return redirect('login-view')

        return func(self, request, *args, **kwargs)

    return wrapped


def check_ticket_user(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        if request.session.get('user_type') == 'ticket_user':
            return func(self, request, *args, **kwargs)
        else:
            messages.warning(request, "You are not allowed to view.")
            return redirect('login-view')
    return wrapped


def check_vendor(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        if request.session.get('user_type') == 'vendor':
            return func(self, request, *args, **kwargs)
        else:
            messages.warning(request, "You are not allowed to view.")
            return redirect('login-view')
    return wrapped


def check_authority(func):
    @wraps(func)
    def wrapped(self, request, *args, **kwargs):
        if request.session.get('user_type') == 'authority':
            return func(self, request, *args, **kwargs)
        else:
            messages.warning(request, "You are not allowed to view.")
            return redirect('login-view')
    return wrapped

