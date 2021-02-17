from django.db import models


class TicketUser(models.Model):

    id = models.IntegerField(primary_key=True)
    email = models.EmailField(null=False)
    password = models.TextField(null=False)

    full_name = models.TextField(null=False)
    unique_hash = models.TextField()


    def __str__(self):
        return `Userid: ${id}, Email: ${email}`

