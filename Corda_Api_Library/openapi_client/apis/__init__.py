
# flake8: noqa

# Import all APIs into this package.
# If you have many APIs here with many many models used in each API this may
# raise a `RecursionError`.
# In order to avoid this, import only the API that you directly need like:
#
#   from .api.cordapps_api import CordappsApi
#
# or import this package, but before doing it, use:
#
#   import sys
#   sys.setrecursionlimit(n)

# Import APIs into API package:
from io.generated.api.cordapps_api import CordappsApi
from io.generated.api.network_api import NetworkApi
from io.generated.api.vault_api import VaultApi
