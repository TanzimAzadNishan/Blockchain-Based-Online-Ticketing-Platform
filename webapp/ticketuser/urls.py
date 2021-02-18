from django.urls import path
from ticketuser import views

urlpatterns = [
    path('dashboard/',  views.TicketUserDashboardView.as_view(),    name='ticketuser-dashboard-view'),
    path('wallet/',     views.TickerUserWalletView.as_view(),       name='ticketuser-wallet-view'),
    path('signup/',     views.TicketUserSignUpView.as_view(),       name='ticketuser-signup-view'),
]