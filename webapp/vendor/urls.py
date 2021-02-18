from django.contrib import admin
from django.urls import path
from vendor import views


urlpatterns = [
    path('', views.vendorSignUp,  name='vendor-signup-view'),
    path('handleSignUp', views.handleSignUp, name='vendor-handle-signup-view'),
]