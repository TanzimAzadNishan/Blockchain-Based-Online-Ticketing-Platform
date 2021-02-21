# NetCordaCoreTransactionsSignedTransaction

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sigs** | [**[NetCordaCoreCryptoTransactionSignature]**](NetCordaCoreCryptoTransactionSignature.md) |  | 
**id** | **str** | Base 58 Encoded Secure Hash | 
**notary_change_transaction** | **bool** |  | 
**inputs** | [**[NetCordaCoreContractsStateRef]**](NetCordaCoreContractsStateRef.md) |  | 
**references** | [**[NetCordaCoreContractsStateRef]**](NetCordaCoreContractsStateRef.md) |  | 
**missing_signers** | **[str]** |  | 
**tx_bits** | [**NetCordaCoreSerializationSerializedBytesNetCordaCoreTransactionsCoreTransaction**](NetCordaCoreSerializationSerializedBytesNetCordaCoreTransactionsCoreTransaction.md) |  | [optional] 
**network_parameters_hash** | **str** | Base 58 Encoded Secure Hash | [optional] 
**core_transaction** | [**NetCordaCoreTransactionsCoreTransaction**](NetCordaCoreTransactionsCoreTransaction.md) |  | [optional] 
**notary** | [**NetCordaCoreIdentityParty**](NetCordaCoreIdentityParty.md) |  | [optional] 
**tx** | [**NetCordaCoreTransactionsWireTransaction**](NetCordaCoreTransactionsWireTransaction.md) |  | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


