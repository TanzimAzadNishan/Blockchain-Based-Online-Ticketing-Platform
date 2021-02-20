"""

    No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""


import re  # noqa: F401
import sys  # noqa: F401

from openapi_client.model_utils import (  # noqa: F401
    ApiTypeError,
    ModelComposed,
    ModelNormal,
    ModelSimple,
    cached_property,
    change_keys_js_to_python,
    convert_js_args_to_python_args,
    date,
    datetime,
    file_type,
    none_type,
    validate_get_composed_info,
)

def lazy_import():
    from openapi_client.model.net_corda_core_identity_abstract_party import NetCordaCoreIdentityAbstractParty
    from openapi_client.model.net_corda_core_node_services_vault_column_predicate_long import NetCordaCoreNodeServicesVaultColumnPredicateLong
    from openapi_client.model.net_corda_core_node_services_vault_constraint_info import NetCordaCoreNodeServicesVaultConstraintInfo
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteria
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_and_composition import NetCordaCoreNodeServicesVaultQueryCriteriaAndComposition
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_common_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteriaCommonQueryCriteria
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_fungible_asset_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_fungible_asset_query_criteria_all_of import NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteriaAllOf
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_linear_state_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteriaLinearStateQueryCriteria
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_or_composition import NetCordaCoreNodeServicesVaultQueryCriteriaOrComposition
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_vault_custom_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteriaVaultCustomQueryCriteria
    from openapi_client.model.net_corda_core_node_services_vault_query_criteria_vault_query_criteria import NetCordaCoreNodeServicesVaultQueryCriteriaVaultQueryCriteria
    from openapi_client.model.net_corda_core_utilities_opaque_bytes import NetCordaCoreUtilitiesOpaqueBytes
    globals()['NetCordaCoreIdentityAbstractParty'] = NetCordaCoreIdentityAbstractParty
    globals()['NetCordaCoreNodeServicesVaultColumnPredicateLong'] = NetCordaCoreNodeServicesVaultColumnPredicateLong
    globals()['NetCordaCoreNodeServicesVaultConstraintInfo'] = NetCordaCoreNodeServicesVaultConstraintInfo
    globals()['NetCordaCoreNodeServicesVaultQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteria
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaAndComposition'] = NetCordaCoreNodeServicesVaultQueryCriteriaAndComposition
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaCommonQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteriaCommonQueryCriteria
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteriaAllOf'] = NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteriaAllOf
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaLinearStateQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteriaLinearStateQueryCriteria
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaOrComposition'] = NetCordaCoreNodeServicesVaultQueryCriteriaOrComposition
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaVaultCustomQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteriaVaultCustomQueryCriteria
    globals()['NetCordaCoreNodeServicesVaultQueryCriteriaVaultQueryCriteria'] = NetCordaCoreNodeServicesVaultQueryCriteriaVaultQueryCriteria
    globals()['NetCordaCoreUtilitiesOpaqueBytes'] = NetCordaCoreUtilitiesOpaqueBytes


class NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria(ModelComposed):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.

    Attributes:
      allowed_values (dict): The key is the tuple path to the attribute
          and the for var_name this is (var_name,). The value is a dict
          with a capitalized key describing the allowed value and an allowed
          value. These dicts store the allowed enum values.
      attribute_map (dict): The key is attribute name
          and the value is json key in definition.
      discriminator_value_class_map (dict): A dict to go from the discriminator
          variable value to the discriminator class name.
      validations (dict): The key is the tuple path to the attribute
          and the for var_name this is (var_name,). The value is a dict
          that stores validations for max_length, min_length, max_items,
          min_items, exclusive_maximum, inclusive_maximum, exclusive_minimum,
          inclusive_minimum, and regex.
      additional_properties_type (tuple): A tuple of classes accepted
          as additional properties values.
    """

    allowed_values = {
        ('status',): {
            'UNCONSUMED': "UNCONSUMED",
            'CONSUMED': "CONSUMED",
            'ALL': "ALL",
        },
        ('relevancy_status',): {
            'RELEVANT': "RELEVANT",
            'NOT_RELEVANT': "NOT_RELEVANT",
            'ALL': "ALL",
        },
        ('constraint_types',): {
            'ALWAYS_ACCEPT': "ALWAYS_ACCEPT",
            'HASH': "HASH",
            'CZ_WHITELISTED': "CZ_WHITELISTED",
            'SIGNATURE': "SIGNATURE",
        },
    }

    validations = {
        ('constraint_types',): {
        },
        ('constraints',): {
        },
        ('contract_state_types',): {
        },
    }

    @cached_property
    def additional_properties_type():
        """
        This must be a method because a model may have properties that are
        of type self, this must run after the class is loaded
        """
        lazy_import()
        return (bool, date, datetime, dict, float, int, list, str, none_type,)  # noqa: E501

    _nullable = False

    @cached_property
    def openapi_types():
        """
        This must be a method because a model may have properties that are
        of type self, this must run after the class is loaded

        Returns
            openapi_types (dict): The key is attribute name
                and the value is attribute type.
        """
        lazy_import()
        return {
            'status': (str,),  # noqa: E501
            'relevancy_status': (str,),  # noqa: E501
            'constraint_types': ([str],),  # noqa: E501
            'constraints': ([NetCordaCoreNodeServicesVaultConstraintInfo],),  # noqa: E501
            'external_ids': ([str],),  # noqa: E501
            'participants': ([NetCordaCoreIdentityAbstractParty],),  # noqa: E501
            'owner': ([NetCordaCoreIdentityAbstractParty],),  # noqa: E501
            'quantity': (NetCordaCoreNodeServicesVaultColumnPredicateLong,),  # noqa: E501
            'issuer': ([NetCordaCoreIdentityAbstractParty],),  # noqa: E501
            'issuer_ref': ([NetCordaCoreUtilitiesOpaqueBytes],),  # noqa: E501
            'contract_state_types': ([str],),  # noqa: E501
            'exact_participants': ([NetCordaCoreIdentityAbstractParty],),  # noqa: E501
        }

    @cached_property
    def discriminator():
        lazy_import()
        val = {
            '.QueryCriteria$AndComposition': NetCordaCoreNodeServicesVaultQueryCriteriaAndComposition,
            '.QueryCriteria$CommonQueryCriteria': NetCordaCoreNodeServicesVaultQueryCriteriaCommonQueryCriteria,
            '.QueryCriteria$FungibleAssetQueryCriteria': NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria,
            '.QueryCriteria$LinearStateQueryCriteria': NetCordaCoreNodeServicesVaultQueryCriteriaLinearStateQueryCriteria,
            '.QueryCriteria$OrComposition': NetCordaCoreNodeServicesVaultQueryCriteriaOrComposition,
            '.QueryCriteria$VaultCustomQueryCriteria': NetCordaCoreNodeServicesVaultQueryCriteriaVaultCustomQueryCriteria,
            '.QueryCriteria$VaultQueryCriteria': NetCordaCoreNodeServicesVaultQueryCriteriaVaultQueryCriteria,
        }
        if not val:
            return None
        return {'_class': val}

    attribute_map = {
        'status': 'status',  # noqa: E501
        'relevancy_status': 'relevancyStatus',  # noqa: E501
        'constraint_types': 'constraintTypes',  # noqa: E501
        'constraints': 'constraints',  # noqa: E501
        'external_ids': 'externalIds',  # noqa: E501
        'participants': 'participants',  # noqa: E501
        'owner': 'owner',  # noqa: E501
        'quantity': 'quantity',  # noqa: E501
        'issuer': 'issuer',  # noqa: E501
        'issuer_ref': 'issuerRef',  # noqa: E501
        'contract_state_types': 'contractStateTypes',  # noqa: E501
        'exact_participants': 'exactParticipants',  # noqa: E501
    }

    required_properties = set([
        '_data_store',
        '_check_type',
        '_spec_property_naming',
        '_path_to_item',
        '_configuration',
        '_visited_composed_classes',
        '_composed_instances',
        '_var_name_to_model_instances',
        '_additional_properties_model_instances',
    ])

    @convert_js_args_to_python_args
    def __init__(self, status, relevancy_status, constraint_types, constraints, external_ids, *args, **kwargs):  # noqa: E501
        """NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteria - a model defined in OpenAPI

        Args:
            status (str):
            relevancy_status (str):
            constraint_types ([str]):
            constraints ([NetCordaCoreNodeServicesVaultConstraintInfo]):
            external_ids ([str]):

        Keyword Args:
            _check_type (bool): if True, values for parameters in openapi_types
                                will be type checked and a TypeError will be
                                raised if the wrong type is input.
                                Defaults to True
            _path_to_item (tuple/list): This is a list of keys or values to
                                drill down to the model in received_data
                                when deserializing a response
            _spec_property_naming (bool): True if the variable names in the input data
                                are serialized names, as specified in the OpenAPI document.
                                False if the variable names in the input data
                                are pythonic names, e.g. snake case (default)
            _configuration (Configuration): the instance to use when
                                deserializing a file_type parameter.
                                If passed, type conversion is attempted
                                If omitted no type conversion is done.
            _visited_composed_classes (tuple): This stores a tuple of
                                classes that we have traveled through so that
                                if we see that class again we will not use its
                                discriminator again.
                                When traveling through a discriminator, the
                                composed schema that is
                                is traveled through is added to this set.
                                For example if Animal has a discriminator
                                petType and we pass in "Dog", and the class Dog
                                allOf includes Animal, we move through Animal
                                once using the discriminator, and pick Dog.
                                Then in Dog, we will make an instance of the
                                Animal class but this time we won't travel
                                through its discriminator because we passed in
                                _visited_composed_classes = (Animal,)
            participants ([NetCordaCoreIdentityAbstractParty]): [optional]  # noqa: E501
            owner ([NetCordaCoreIdentityAbstractParty]): [optional]  # noqa: E501
            quantity (NetCordaCoreNodeServicesVaultColumnPredicateLong): [optional]  # noqa: E501
            issuer ([NetCordaCoreIdentityAbstractParty]): [optional]  # noqa: E501
            issuer_ref ([NetCordaCoreUtilitiesOpaqueBytes]): [optional]  # noqa: E501
            contract_state_types ([str]): [optional]  # noqa: E501
            exact_participants ([NetCordaCoreIdentityAbstractParty]): [optional]  # noqa: E501
        """

        _check_type = kwargs.pop('_check_type', True)
        _spec_property_naming = kwargs.pop('_spec_property_naming', False)
        _path_to_item = kwargs.pop('_path_to_item', ())
        _configuration = kwargs.pop('_configuration', None)
        _visited_composed_classes = kwargs.pop('_visited_composed_classes', ())

        if args:
            raise ApiTypeError(
                "Invalid positional arguments=%s passed to %s. Remove those invalid positional arguments." % (
                    args,
                    self.__class__.__name__,
                ),
                path_to_item=_path_to_item,
                valid_classes=(self.__class__,),
            )

        self._data_store = {}
        self._check_type = _check_type
        self._spec_property_naming = _spec_property_naming
        self._path_to_item = _path_to_item
        self._configuration = _configuration
        self._visited_composed_classes = _visited_composed_classes + (self.__class__,)

        constant_args = {
            '_check_type': _check_type,
            '_path_to_item': _path_to_item,
            '_spec_property_naming': _spec_property_naming,
            '_configuration': _configuration,
            '_visited_composed_classes': self._visited_composed_classes,
        }
        required_args = {
            'status': status,
            'relevancy_status': relevancy_status,
            'constraint_types': constraint_types,
            'constraints': constraints,
            'external_ids': external_ids,
        }
        model_args = {}
        model_args.update(required_args)
        model_args.update(kwargs)
        composed_info = validate_get_composed_info(
            constant_args, model_args, self)
        self._composed_instances = composed_info[0]
        self._var_name_to_model_instances = composed_info[1]
        self._additional_properties_model_instances = composed_info[2]
        unused_args = composed_info[3]

        for var_name, var_value in required_args.items():
            setattr(self, var_name, var_value)
        for var_name, var_value in kwargs.items():
            if var_name in unused_args and \
                        self._configuration is not None and \
                        self._configuration.discard_unknown_keys and \
                        not self._additional_properties_model_instances:
                # discard variable.
                continue
            setattr(self, var_name, var_value)

    @cached_property
    def _composed_schemas():
        # we need this here to make our import statements work
        # we must store _composed_schemas in here so the code is only run
        # when we invoke this method. If we kept this at the class
        # level we would get an error beause the class level
        # code would be run when this module is imported, and these composed
        # classes don't exist yet because their module has not finished
        # loading
        lazy_import()
        return {
          'anyOf': [
          ],
          'allOf': [
              NetCordaCoreNodeServicesVaultQueryCriteria,
              NetCordaCoreNodeServicesVaultQueryCriteriaFungibleAssetQueryCriteriaAllOf,
          ],
          'oneOf': [
          ],
        }
