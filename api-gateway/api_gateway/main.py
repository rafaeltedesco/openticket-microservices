from fastapi import FastAPI
from api_gateway.routers import catalog_router

app = FastAPI()

@app.get("/")
async def health():
  return {"message": "OK"}

app.include_router(
  catalog_router, 
  prefix="/catalog"
)