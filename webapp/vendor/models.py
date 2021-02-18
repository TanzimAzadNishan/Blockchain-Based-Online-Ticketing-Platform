from django.db import models

class TicketVendor(models.Model):

    id = models.IntegerField(primary_key=True)
    email = models.EmailField(null=False)
    password = models.TextField(null=False)

    name = models.TextField(null=False, max_length=100)
    address   = models.CharField(null=False, max_length=100)
    unique_hash = models.TextField()

    def __str__(self):
        return `Vendorid: ${id}, Email: ${email}`

