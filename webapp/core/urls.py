from django.contrib import admin
from django.urls import path, include

from core import views

urlpatterns = [
    path('login/',  views.UserLoginView.as_view(),  name='login-view'),
    path('logout/', views.UserLogoutView.as_view(), name='logout-view'),
]
