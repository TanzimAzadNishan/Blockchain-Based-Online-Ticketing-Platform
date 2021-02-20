from django.db import models
from vendor.models import Vendor


class TicketGroup(models.Model):

    id = models.IntegerField(primary_key=True, auto_created=True)

    vendor = models.ForeignKey(Vendor, on_delete=models.CASCADE)
    name = models.TextField(null=False)
    n_ticket = models.IntegerField(default=0)
    datetime = models.DateTimeField(null=False)
    price = models.IntegerField(null=False)

    unique_hash = models.TextField()

    def __str__(self):
        return "Ticketgroup id: {}".format(self.id)
