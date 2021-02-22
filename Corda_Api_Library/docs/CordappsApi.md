# openapi_client.CordappsApi

All URIs are relative to *http://localhost:9004/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cordapps**](CordappsApi.md#cordapps) | **GET** /cordapps | 
[**cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.EventRegisterFlow$EventRegisterFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.EventUpdateFlow$EventUpdateFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.TicketIssueFlow$TicketIssueFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.TicketRefundFlow$TicketRefundFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.TicketResellFlow$TicketResellFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.TicketSellFlow$TicketSellFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.TicketUpdateFlow$TicketUpdateFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.UserRegisterFlow$UserRegisterFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.UserUpdateFlow$UserUpdateFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.VendorRegisterFlow$VendorRegisterFlowInitiator | 
[**cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator) | **POST** /cordapps/CorDapp/flows/Flows.VendorUpdateFlow$VendorUpdateFlowInitiator | 
[**cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.EventInfoByVendor$EventInfoByVendorInitiator | 
[**cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.TicketByEventId$TicketByEventIdInitiator | 
[**cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.TicketByLinearId$TicketByLinearIdInitiator | 
[**cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.TicketInfoByVendor$TicketInfoByVendorInitiator | 
[**cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.UserByLinearId$UserByLinearIdInitiator | 
[**cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator**](CordappsApi.md#cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator) | **POST** /cordapps/CorDapp/flows/QueryFlows.VendorByLinearId$VendorByLinearIdInitiator | 
[**cordapps_cordapp_flows**](CordappsApi.md#cordapps_cordapp_flows) | **GET** /cordapps/{cordapp}/flows | 
[**cordapps_progress_tracker**](CordappsApi.md#cordapps_progress_tracker) | **GET** /cordapps/progress-tracker | 


# **cordapps**
> [str] cordapps()



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        api_response = api_instance.cordapps()
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

**[str]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator**
> NetCordaCoreContractsUniqueIdentifier cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator(generated_flows_event_register_flow_event_register_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.net_corda_core_contracts_unique_identifier import NetCordaCoreContractsUniqueIdentifier
from openapi_client.model.generated_flows_event_register_flow_event_register_flow_initiator_payload import GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_event_register_flow_event_register_flow_initiator_payload = GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        event_date="event_date_example",
        total_tickets=1,
    ) # GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator(generated_flows_event_register_flow_event_register_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator(generated_flows_event_register_flow_event_register_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_event_register_flow_event_register_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_event_register_flow_event_register_flow_initiator_payload** | [**GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload**](GeneratedFlowsEventRegisterFlowEventRegisterFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreContractsUniqueIdentifier**](NetCordaCoreContractsUniqueIdentifier.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator(generated_flows_event_update_flow_event_update_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_event_update_flow_event_update_flow_initiator_payload import GeneratedFlowsEventUpdateFlowEventUpdateFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_event_update_flow_event_update_flow_initiator_payload = GeneratedFlowsEventUpdateFlowEventUpdateFlowInitiatorPayload(
        event_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedFlowsEventUpdateFlowEventUpdateFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator(generated_flows_event_update_flow_event_update_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator(generated_flows_event_update_flow_event_update_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_event_update_flow_event_update_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_event_update_flow_event_update_flow_initiator_payload** | [**GeneratedFlowsEventUpdateFlowEventUpdateFlowInitiatorPayload**](GeneratedFlowsEventUpdateFlowEventUpdateFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator(generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload import GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload = GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        event_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        no_of_tickets_to_be_issued=1,
        price=3.14,
        refund_amount=3.14,
        event_date="event_date_example",
    ) # GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator(generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator(generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_issue_flow_ticket_issue_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_ticket_issue_flow_ticket_issue_flow_initiator_payload** | [**GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload**](GeneratedFlowsTicketIssueFlowTicketIssueFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator(generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload import GeneratedFlowsTicketRefundFlowTicketRefundFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload = GeneratedFlowsTicketRefundFlowTicketRefundFlowInitiatorPayload(
        ticket_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedFlowsTicketRefundFlowTicketRefundFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator(generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator(generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_refund_flow_ticket_refund_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_ticket_refund_flow_ticket_refund_flow_initiator_payload** | [**GeneratedFlowsTicketRefundFlowTicketRefundFlowInitiatorPayload**](GeneratedFlowsTicketRefundFlowTicketRefundFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator(generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload import GeneratedFlowsTicketResellFlowTicketResellFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload = GeneratedFlowsTicketResellFlowTicketResellFlowInitiatorPayload(
        new_user_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        ticket_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        new_owner=NetCordaCoreIdentityParty(
            name="O=Bank A, L=London, C=GB",
            owning_key="GfHq2tTVk9z4eXgyUuofmR16H6j7srXt8BCyidKdrZL5JEwFqHgDSuiinbTE",
        ),
    ) # GeneratedFlowsTicketResellFlowTicketResellFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator(generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator(generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_resell_flow_ticket_resell_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_ticket_resell_flow_ticket_resell_flow_initiator_payload** | [**GeneratedFlowsTicketResellFlowTicketResellFlowInitiatorPayload**](GeneratedFlowsTicketResellFlowTicketResellFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator(generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload import GeneratedFlowsTicketSellFlowTicketSellFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload = GeneratedFlowsTicketSellFlowTicketSellFlowInitiatorPayload(
        user_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        ticket_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        new_owner=NetCordaCoreIdentityParty(
            name="O=Bank A, L=London, C=GB",
            owning_key="GfHq2tTVk9z4eXgyUuofmR16H6j7srXt8BCyidKdrZL5JEwFqHgDSuiinbTE",
        ),
    ) # GeneratedFlowsTicketSellFlowTicketSellFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator(generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator(generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_sell_flow_ticket_sell_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_ticket_sell_flow_ticket_sell_flow_initiator_payload** | [**GeneratedFlowsTicketSellFlowTicketSellFlowInitiatorPayload**](GeneratedFlowsTicketSellFlowTicketSellFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator(generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload import GeneratedFlowsTicketUpdateFlowTicketUpdateFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload = GeneratedFlowsTicketUpdateFlowTicketUpdateFlowInitiatorPayload(
        event_date="event_date_example",
        ticket_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedFlowsTicketUpdateFlowTicketUpdateFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator(generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator(generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_ticket_update_flow_ticket_update_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_ticket_update_flow_ticket_update_flow_initiator_payload** | [**GeneratedFlowsTicketUpdateFlowTicketUpdateFlowInitiatorPayload**](GeneratedFlowsTicketUpdateFlowTicketUpdateFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator**
> NetCordaCoreContractsUniqueIdentifier cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator(body)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.net_corda_core_contracts_unique_identifier import NetCordaCoreContractsUniqueIdentifier
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    body = {} # {str: (bool, date, datetime, dict, float, int, list, str, none_type)} | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator(body)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator(body, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_user_register_flow_user_register_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **{str: (bool, date, datetime, dict, float, int, list, str, none_type)}**| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreContractsUniqueIdentifier**](NetCordaCoreContractsUniqueIdentifier.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator(generated_flows_user_update_flow_user_update_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_user_update_flow_user_update_flow_initiator_payload import GeneratedFlowsUserUpdateFlowUserUpdateFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_user_update_flow_user_update_flow_initiator_payload = GeneratedFlowsUserUpdateFlowUserUpdateFlowInitiatorPayload(
        user_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        amount=3.14,
        type="type_example",
    ) # GeneratedFlowsUserUpdateFlowUserUpdateFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator(generated_flows_user_update_flow_user_update_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator(generated_flows_user_update_flow_user_update_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_user_update_flow_user_update_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_user_update_flow_user_update_flow_initiator_payload** | [**GeneratedFlowsUserUpdateFlowUserUpdateFlowInitiatorPayload**](GeneratedFlowsUserUpdateFlowUserUpdateFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator**
> NetCordaCoreContractsUniqueIdentifier cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator(generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.net_corda_core_contracts_unique_identifier import NetCordaCoreContractsUniqueIdentifier
from openapi_client.model.generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload import GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload = GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload(
        percentage=3.14,
    ) # GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator(generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator(generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_vendor_register_flow_vendor_register_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_vendor_register_flow_vendor_register_flow_initiator_payload** | [**GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload**](GeneratedFlowsVendorRegisterFlowVendorRegisterFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreContractsUniqueIdentifier**](NetCordaCoreContractsUniqueIdentifier.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator**
> NetCordaCoreTransactionsSignedTransaction cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator(generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload import GeneratedFlowsVendorUpdateFlowVendorUpdateFlowInitiatorPayload
from openapi_client.model.net_corda_core_transactions_signed_transaction import NetCordaCoreTransactionsSignedTransaction
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload = GeneratedFlowsVendorUpdateFlowVendorUpdateFlowInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
        amount=3.14,
        type="type_example",
    ) # GeneratedFlowsVendorUpdateFlowVendorUpdateFlowInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator(generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator(generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_flows_vendor_update_flow_vendor_update_flow_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_flows_vendor_update_flow_vendor_update_flow_initiator_payload** | [**GeneratedFlowsVendorUpdateFlowVendorUpdateFlowInitiatorPayload**](GeneratedFlowsVendorUpdateFlowVendorUpdateFlowInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

[**NetCordaCoreTransactionsSignedTransaction**](NetCordaCoreTransactionsSignedTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator**
> str cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator(generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload import GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload = GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator(generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator(generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_event_info_by_vendor_event_info_by_vendor_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_event_info_by_vendor_event_info_by_vendor_initiator_payload** | [**GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload**](GeneratedQueryFlowsEventInfoByVendorEventInfoByVendorInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator**
> str cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator(generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload import GeneratedQueryFlowsTicketByEventIdTicketByEventIdInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload = GeneratedQueryFlowsTicketByEventIdTicketByEventIdInitiatorPayload(
        event_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsTicketByEventIdTicketByEventIdInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator(generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator(generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_by_event_id_ticket_by_event_id_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_ticket_by_event_id_ticket_by_event_id_initiator_payload** | [**GeneratedQueryFlowsTicketByEventIdTicketByEventIdInitiatorPayload**](GeneratedQueryFlowsTicketByEventIdTicketByEventIdInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator**
> str cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator(generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload import GeneratedQueryFlowsTicketByLinearIdTicketByLinearIdInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload = GeneratedQueryFlowsTicketByLinearIdTicketByLinearIdInitiatorPayload(
        ticket_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsTicketByLinearIdTicketByLinearIdInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator(generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator(generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_ticket_by_linear_id_ticket_by_linear_id_initiator_payload** | [**GeneratedQueryFlowsTicketByLinearIdTicketByLinearIdInitiatorPayload**](GeneratedQueryFlowsTicketByLinearIdTicketByLinearIdInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator**
> str cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator(generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload import GeneratedQueryFlowsTicketInfoByVendorTicketInfoByVendorInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload = GeneratedQueryFlowsTicketInfoByVendorTicketInfoByVendorInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsTicketInfoByVendorTicketInfoByVendorInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator(generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator(generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_ticket_info_by_vendor_ticket_info_by_vendor_initiator_payload** | [**GeneratedQueryFlowsTicketInfoByVendorTicketInfoByVendorInitiatorPayload**](GeneratedQueryFlowsTicketInfoByVendorTicketInfoByVendorInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator**
> str cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator(generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload import GeneratedQueryFlowsUserByLinearIdUserByLinearIdInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload = GeneratedQueryFlowsUserByLinearIdUserByLinearIdInitiatorPayload(
        user_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsUserByLinearIdUserByLinearIdInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator(generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator(generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_user_by_linear_id_user_by_linear_id_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_user_by_linear_id_user_by_linear_id_initiator_payload** | [**GeneratedQueryFlowsUserByLinearIdUserByLinearIdInitiatorPayload**](GeneratedQueryFlowsUserByLinearIdUserByLinearIdInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator**
> str cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator(generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload import GeneratedQueryFlowsVendorByLinearIdVendorByLinearIdInitiatorPayload
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload = GeneratedQueryFlowsVendorByLinearIdVendorByLinearIdInitiatorPayload(
        vendor_linear_id=NetCordaCoreContractsUniqueIdentifier(
            external_id="external_id_example",
            id="id_example",
        ),
    ) # GeneratedQueryFlowsVendorByLinearIdVendorByLinearIdInitiatorPayload | payload
    invocation_id = "invocation-id_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator(generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator(generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload, invocation_id=invocation_id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cor_dapp_flows_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **generated_query_flows_vendor_by_linear_id_vendor_by_linear_id_initiator_payload** | [**GeneratedQueryFlowsVendorByLinearIdVendorByLinearIdInitiatorPayload**](GeneratedQueryFlowsVendorByLinearIdVendorByLinearIdInitiatorPayload.md)| payload |
 **invocation_id** | **str**|  | [optional]

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_cordapp_flows**
> [str] cordapps_cordapp_flows(cordapp)



### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)
    cordapp = "cordapp_example" # str | 

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.cordapps_cordapp_flows(cordapp)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_cordapp_flows: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cordapp** | **str**|  |

### Return type

**[str]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cordapps_progress_tracker**
> IoBluebankBraidCordaServerProgressProgressNotification cordapps_progress_tracker()



Connect to the Progress Tracker. This call will return chunked responses of all progress trackers

### Example

```python
import time
import openapi_client
from io.generated.api import cordapps_api
from openapi_client.model.io_bluebank_braid_corda_server_progress_progress_notification import IoBluebankBraidCordaServerProgressProgressNotification
from openapi_client.model.invocation_error import InvocationError
from pprint import pprint
# Defining the host is optional and defaults to http://localhost:9004/api/rest
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "http://localhost:9004/api/rest"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = cordapps_api.CordappsApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        api_response = api_instance.cordapps_progress_tracker()
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling CordappsApi->cordapps_progress_tracker: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**IoBluebankBraidCordaServerProgressProgressNotification**](IoBluebankBraidCordaServerProgressProgressNotification.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**400** | the server failed to parse the request |  -  |
**422** | the request could not be processed |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

