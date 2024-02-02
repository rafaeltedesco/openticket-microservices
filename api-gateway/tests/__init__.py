from fastapi.testclient import TestClient

from api_gateway.main import app

client = TestClient(app)
