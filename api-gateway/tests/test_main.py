from . import client

def test_health():
  response = client.get('/')
  assert response.status_code == 200
  assert response.json() == { "message": "OK"}