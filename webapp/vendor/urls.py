from django.urls import path
from . import views


urlpatterns = [
    path('signup/',     views.VendorSignupView.as_view(),       name="vendor-signup-view"),
    path('dashboard/',  views.VendorDashboardView.as_view(),    name="vendor-dashboard-view"),
    path('issue/',      views.IssueTicketView.as_view(),        name="issue-ticket-view"),
    path('issued-ticket/',   views.IssuedTicketGroupView.as_view(),    name="issued-ticket-group-view"),
]
