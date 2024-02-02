from fastapi import APIRouter
from api_gateway.services import catalog as catalog_service

catalog_router = APIRouter()

@catalog_router.get("/", tags=["catalog"])
async def show_catalog():
  return catalog_service.fetch_catalog()