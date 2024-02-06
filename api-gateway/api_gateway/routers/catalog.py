from fastapi import APIRouter, Response, status

from api_gateway.services import catalog as catalog_service

catalog_router = APIRouter()

@catalog_router.get("/", status_code=200)
async def show_catalog(response: Response):
  result = catalog_service.fetch_catalog()
  if "error" in result:
    response.status_code = status.HTTP_503_SERVICE_UNAVAILABLE
  return result
  
