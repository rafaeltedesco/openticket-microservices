from unittest.mock import patch
from ..mocks.services import catalog as mock
from .. import client


def test_show_catalog(): 
  with patch('api_gateway.services.catalog.fetch_catalog', return_value=mock.mock_fetch_catalog):
    response = client.get('/catalog')
  assert response.status_code == 200
  assert response.json() == [{"id": 1, "name": "Show da Xuxa", "eventDateTime": "2024-05-22T00:00:00"}]

def test_service_unavailable():
  with patch('api_gateway.services.catalog.fetch_catalog', return_value=mock.mock_error_unavailable):
    response = client.get('/catalog')
    assert response.status_code == 503
    assert response.json() == {"error": "Catalog Service is not available"}