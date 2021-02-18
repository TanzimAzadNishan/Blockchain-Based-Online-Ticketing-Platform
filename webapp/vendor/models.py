from django.db import models

from django.shortcuts import render, redirect
from django.views import View
from django.contrib import messages

from ticketuser.models import TicketUser

import hashlib


class Vendor(models.Model):

    id = models.IntegerField(primary_key=True)
    email = models.EmailField(null=False, unique=True)
    password = models.TextField(null=False)

    vendor_name = models.TextField(null=False)
    vendor_type = models.TextField(null=False)
    # contact = models.TextField(null=False)
    unique_hash = models.TextField()

    def __init__(self):
        self.unique_hash = hashlib.sha256(self.email, self.vendor_name).hexdigest()

    def __str__(self):
        return "Vendorid: {}".format(self.id)
        
