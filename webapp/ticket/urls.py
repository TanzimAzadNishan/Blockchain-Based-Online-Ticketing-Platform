from django.urls import path
from ticket import views

urlpatterns = [
    path('id/',   views.TicketInfoView.as_view(),         name='ticket-info-view'),
    path('bus/',                    views.BusTicketListView.as_view(),     name="bus-ticket-list-view"),
    path('ship/',                   views.ShipTicketListView.as_view(),    name="ship-ticket-list-view"),
    path('movie/',                  views.MovieTicketListView.as_view(),   name="movie-ticket-list-view"),
    path('event/',                  views.EventTicketListView.as_view(),   name="event-ticket-list-view"),
    path('verify/',                 views.VerifyTicketView.as_view(),       name='verify-ticket-view'),

    path('refund/',                 views.RefundTicketView.as_view(),       name="refund-ticket-view"),
    path('resell/',                 views.ResellTicketView.as_view(),       name="resell-ticket-view"),
    path('buy/',                 views.BuyTicketView.as_view(),       name="buy-ticket-view"), 
]
