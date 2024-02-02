from unittest.mock import patch
from ..mocks.services import catalog as mock
from .. import client


def test_show_catalog(): 
  with patch('api_gateway.services.catalog.fetch_catalog', return_value=mock.mock_fetch_catalog):
    response = client.get('/catalog')
  assert response.status_code == 200
  assert response.json() == [{"id": 1, "name": "show 1"}, {"id": 2, "name": "show 2"}]