from django.contrib import admin
from django.urls import path
from vendor import views


urlpatterns = [
    path('signup/', views.VendorRegisterView.as_view(), name='vendor-signup-view'),
]