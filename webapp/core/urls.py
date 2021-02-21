from django.contrib import admin
from django.urls import path, include

from core import views

urlpatterns = [
    path('',        views.IndexView.as_view(),      name='index-view'),
    path('login/',  views.UserLoginView.as_view(),  name='login-view'),
    path('logout/', views.UserLogoutView.as_view(), name='logout-view'),

    path('403/',    views.Http403View.as_view(),    name='http-403-view'),
]
