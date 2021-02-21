from django.db import models
import hashlib


class TicketUser(models.Model):
    id = models.IntegerField(auto_created=True, primary_key=True)
    email = models.EmailField(null=False, unique=True)
    password = models.TextField(null=False)

    full_name = models.TextField(null=False)
    unique_hash = models.TextField()

    def __str__(self):
        return "Ticket Userid: {}".format(self.id)
