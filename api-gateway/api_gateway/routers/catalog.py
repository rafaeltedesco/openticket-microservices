from fastapi import APIRouter, Response

from api_gateway.services import catalog as catalog_service

catalog_router = APIRouter()

@catalog_router.get("/", status_code=200)
async def show_catalog(response: Response):
  status, message = await catalog_service.fetch_catalog()
  response.status_code = status
  return message
  
