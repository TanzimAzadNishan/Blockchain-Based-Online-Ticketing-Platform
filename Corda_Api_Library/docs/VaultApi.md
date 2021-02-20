# openapi_client.VaultApi

All URIs are relative to *http://localhost:9004/api/rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**vault_vault_query**](VaultApi.md#vault_vault_query) | **GET** /vault/vaultQuery | 
[**vault_vault_query_by**](VaultApi.md#vault_vault_query_by) | **POST** /vault/vaultQueryBy | 


# **vault_vault_query**
> NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState vault_vault_query()



Queries the vault for contract states of the supplied type

### Example

```python
import time
import openapi_client
from io.generated.api import vault_api
from openapi_client.model.net_corda_core_node_services_vault_page_net_corda_core_contracts_contract_state import NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState
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
    api_instance = vault_api.VaultApi(api_client)
    contract_state_type = "contract-state-type_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.vault_vault_query(contract_state_type=contract_state_type)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling VaultApi->vault_vault_query: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **contract_state_type** | **str**|  | [optional]

### Return type

[**NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState**](NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState.md)

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

# **vault_vault_query_by**
> NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState vault_vault_query_by(io_vertx_ext_auth_user)



Queries the vault

### Example

```python
import time
import openapi_client
from io.generated.api import vault_api
from openapi_client.model.net_corda_core_node_services_vault_page_net_corda_core_contracts_contract_state import NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState
from openapi_client.model.io_bluebank_braid_corda_services_vault_vault_query import IoBluebankBraidCordaServicesVaultVaultQuery
from openapi_client.model.io_vertx_ext_auth_user import IoVertxExtAuthUser
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
    api_instance = vault_api.VaultApi(api_client)
    io_vertx_ext_auth_user = IoVertxExtAuthUser(
        auth_provider={},
    ) # IoVertxExtAuthUser | user
    vault = IoBluebankBraidCordaServicesVaultVaultQuery(
        criteria=NetCordaCoreNodeServicesVaultQueryCriteria(),
        paging=NetCordaCoreNodeServicesVaultPageSpecification(
            page_number=1,
            page_size=1,
        ),
        sorting=NetCordaCoreNodeServicesVaultSort(
            columns=[
                NetCordaCoreNodeServicesVaultSortSortColumn(
                    sort_attribute={},
                    direction="ASC",
                ),
            ],
        ),
        contract_state_type="java.lang.Object",
    ) # IoBluebankBraidCordaServicesVaultVaultQuery |  (optional)

    # example passing only required values which don't have defaults set
    try:
        api_response = api_instance.vault_vault_query_by(io_vertx_ext_auth_user)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling VaultApi->vault_vault_query_by: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        api_response = api_instance.vault_vault_query_by(io_vertx_ext_auth_user, vault=vault)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling VaultApi->vault_vault_query_by: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **io_vertx_ext_auth_user** | [**IoVertxExtAuthUser**](IoVertxExtAuthUser.md)| user |
 **vault** | **IoBluebankBraidCordaServicesVaultVaultQuery**|  | [optional]

### Return type

[**NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState**](NetCordaCoreNodeServicesVaultPageNetCordaCoreContractsContractState.md)

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

