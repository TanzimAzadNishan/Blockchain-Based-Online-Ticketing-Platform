# openapi_client.NetworkApi

All URIs are relative to *http://localhost:9004/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**network_nodes**](NetworkApi.md#network_nodes) | **GET** /network/nodes | 
[**network_nodes_self**](NetworkApi.md#network_nodes_self) | **GET** /network/nodes/self | 
[**network_notaries**](NetworkApi.md#network_notaries) | **GET** /network/notaries | 


# **network_nodes**
> [IoBluebankBraidCordaServicesSimpleNodeInfo] network_nodes()



Retrieves all nodes if neither query parameter is supplied. Otherwise returns a list of one node matching the supplied query parameter.

### Example

```python
import time
import openapi_client
from io.generated.api import network_api
from openapi_client.model.io_bluebank_braid_corda_services_simple_node_info import IoBluebankBraidCordaServicesSimpleNodeInfo
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
    api_instance = network_api.NetworkApi(api_client)
    host_and_port = "host-and-port_example" # str |  (optional)
    x500_name = "x500-name_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.network_nodes(host_and_port=host_and_port, x500_name=x500_name)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling NetworkApi->network_nodes: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **host_and_port** | **str**|  | [optional]
 **x500_name** | **str**|  | [optional]

### Return type

[**[IoBluebankBraidCordaServicesSimpleNodeInfo]**](IoBluebankBraidCordaServicesSimpleNodeInfo.md)

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

# **network_nodes_self**
> IoBluebankBraidCordaServicesSimpleNodeInfo network_nodes_self()



Retrieves all nodes if neither query parameter is supplied. Otherwise returns a list of one node matching the supplied query parameter.

### Example

```python
import time
import openapi_client
from io.generated.api import network_api
from openapi_client.model.io_bluebank_braid_corda_services_simple_node_info import IoBluebankBraidCordaServicesSimpleNodeInfo
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
    api_instance = network_api.NetworkApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        api_response = api_instance.network_nodes_self()
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling NetworkApi->network_nodes_self: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**IoBluebankBraidCordaServicesSimpleNodeInfo**](IoBluebankBraidCordaServicesSimpleNodeInfo.md)

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

# **network_notaries**
> [NetCordaCoreIdentityParty] network_notaries()



### Example

```python
import time
import openapi_client
from io.generated.api import network_api
from openapi_client.model.net_corda_core_identity_party import NetCordaCoreIdentityParty
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
    api_instance = network_api.NetworkApi(api_client)
    x500_name = "x500-name_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.network_notaries(x500_name=x500_name)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling NetworkApi->network_notaries: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **x500_name** | **str**|  | [optional]

### Return type

[**[NetCordaCoreIdentityParty]**](NetCordaCoreIdentityParty.md)

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

