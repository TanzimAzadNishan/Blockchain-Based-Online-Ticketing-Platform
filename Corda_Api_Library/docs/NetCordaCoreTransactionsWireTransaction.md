# NetCordaCoreTransactionsWireTransaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachments** | **[str]** |  | 
**inputs** | [**[NetCordaCoreContractsStateRef]**](NetCordaCoreContractsStateRef.md) |  | 
**references** | [**[NetCordaCoreContractsStateRef]**](NetCordaCoreContractsStateRef.md) |  | 
**outputs** | [**[NetCordaCoreContractsTransactionStateNetCordaCoreContractsContractState]**](NetCordaCoreContractsTransactionStateNetCordaCoreContractsContractState.md) |  | 
**commands** | [**[NetCordaCoreContractsCommandObject]**](NetCordaCoreContractsCommandObject.md) |  | 
**id** | **str** | Base 58 Encoded Secure Hash | 
**required_signing_keys** | **[str]** |  | 
**available_component_hashescore** | **{str: ([str],)}** |  | 
**group_hashescore** | **[str]** |  | 
**available_component_noncescore** | **{str: ([str],)}** |  | 
**groups_merkle_rootscore** | **{str: (str,)}** |  | 
**privacy_salt** | [**NetCordaCoreContractsPrivacySalt**](NetCordaCoreContractsPrivacySalt.md) |  | [optional] 
**notary** | [**NetCordaCoreIdentityParty**](NetCordaCoreIdentityParty.md) |  | [optional] 
**time_window** | [**NetCordaCoreContractsTimeWindow**](NetCordaCoreContractsTimeWindow.md) |  | [optional] 
**network_parameters_hash** | **str** | Base 58 Encoded Secure Hash | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


