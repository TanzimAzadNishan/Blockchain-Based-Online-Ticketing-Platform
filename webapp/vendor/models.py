from django.db import models

import hashlib


class Vendor(models.Model):

    id = models.IntegerField(primary_key=True)
    email = models.EmailField(null=False, unique=True)
    password = models.TextField(null=False)

    vendor_name = models.TextField(null=False)
    vendor_type = models.TextField(null=False)
    unique_hash = models.TextField()

    def __str__(self):
        return "Vendorid: {}".format(self.id)
        
