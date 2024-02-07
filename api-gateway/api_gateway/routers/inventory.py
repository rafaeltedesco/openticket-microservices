from fastapi import APIRouter, Response, status

from api_gateway.dtos.inventory_event_dto import InventoryEventCreationDto
from api_gateway.services import inventory as inventory_service

inventory_router = APIRouter()

@inventory_router.post("/", status_code=201)
async def add_item(event: InventoryEventCreationDto, response: Response):
  result = inventory_service.add_event(event)
  if "error" in result:
    response.status_code = status.HTTP_503_SERVICE_UNAVAILABLE
  return result

@inventory_router.get("/", status_code=200)
async def show_items(response: Response):
  result = inventory_service.show_events()
  if "error" in result:
    response.status_code = status.HTTP_503_SERVICE_UNAVAILABLE
  return result