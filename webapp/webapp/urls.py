from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('',        include('core.urls')),
    path('admin/',  admin.site.urls),
    path('user/',   include('ticketuser.urls')),
    path('ticket/', include('ticket.urls')),
    path('vendor/', include('vendor.urls')),
]
