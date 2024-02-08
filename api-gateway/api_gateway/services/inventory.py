import httpx, os

from api_gateway.dtos.inventory_event_dto import InventoryEventCreationDto

INVENTORY_SERVICE_URL = os.getenv("INVENTORY_SERVICE_URL", "http://localhost:3005")

async def add_event(event: InventoryEventCreationDto):
  async with httpx.AsyncClient() as client:
    try:
      response = await client.post(f'{INVENTORY_SERVICE_URL}/inventory', json=event.dict())
      return response.status_code, response.json()
    except (httpx.ConnectError) as e:
      if isinstance(e, httpx.ConnectError):
        return 503, { "message": "Service Unavailable" }
    return 500, { "message": "Internal Server Error" } 
      
    
async def show_events():
  async with httpx.AsyncClient() as client:
    try:
      response = await client.get(f'{INVENTORY_SERVICE_URL}/inventory')
      return response.status_code, response.json()
    except (httpx.ConnectError) as e:
      if isinstance(e, httpx.ConnectError):
        return 503, { "message": "Service Unavailable" }
    return 500, { "message": "Internal Server Error" } 