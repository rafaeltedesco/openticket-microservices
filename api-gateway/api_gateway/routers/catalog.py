from fastapi import APIRouter, Response, status
from api_gateway.services import catalog as catalog_service
from api_gateway.dtos.catalog_event_dto import CatalogEventCreationDto

catalog_router = APIRouter()

@catalog_router.get("/", status_code=200)
async def show_catalog(response: Response):
  result = catalog_service.fetch_catalog()
  if "error" in result:
    response.status_code = status.HTTP_503_SERVICE_UNAVAILABLE
  return result
  
@catalog_router.post("/", status_code=201)
async def add_item(event: CatalogEventCreationDto, response: Response):
  result = catalog_service.add_event(event)
  if "error" in result:
    response.status_code = status.HTTP_503_SERVICE_UNAVAILABLE
  return result