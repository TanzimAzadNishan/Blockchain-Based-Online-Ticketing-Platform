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
    category = models.TextField(null=False)
    unique_hash = models.TextField()

    def __str__(self):
        return "Vendorid: {}  Hash: {}".format(self.id, self.unique_hash)
        