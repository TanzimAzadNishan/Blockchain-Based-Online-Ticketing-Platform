from django.urls import path
from ticketuser import views

urlpatterns = [
    path('dashboard', views.TicketUserDashboardView.as_view(), name='ticketuser-dashboard-view'),
]