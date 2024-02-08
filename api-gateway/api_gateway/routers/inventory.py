from fastapi import APIRouter, Response

from api_gateway.dtos.inventory_event_dto import InventoryEventCreationDto
from api_gateway.services import inventory as inventory_service

inventory_router = APIRouter()

@inventory_router.post("/", status_code=201)
async def add_item(event: InventoryEventCreationDto, response: Response):
  status, message = await inventory_service.add_event(event)
  response.status_code = status
  return message

@inventory_router.get("/", status_code=200)
async def show_items(response: Response):
  status, message = await inventory_service.show_events()
  response.status_code = status
  return message
  