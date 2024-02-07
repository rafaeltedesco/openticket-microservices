import httpx, os

from api_gateway.dtos.inventory_event_dto import InventoryEventCreationDto

INVENTORY_SERVICE_URL = os.getenv("INVENTORY_SERVICE_URL", "http://localhost:3005")

def add_event(event: InventoryEventCreationDto):
  try:
    response = httpx.post(f'{INVENTORY_SERVICE_URL}/inventory', json=event.dict())
    return response.json()
  except httpx.RequestError as e:
    print("Request error", e)
    return {"error": "Inventory Service is not available"}
  
def show_events():
  try:
    response = httpx.get(f'{INVENTORY_SERVICE_URL}/inventory')
    return response.json()
  except httpx.RequestError as e:
    print("Request error", e)
    return {"error": "Inventory Service is not available"}