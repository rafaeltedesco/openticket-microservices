import httpx, os

CATALOG_SERVICE_URL = os.getenv("CATALOG_SERVICE_URL", "http://localhost:3030")

async def fetch_catalog():
  async with httpx.AsyncClient() as client:
    try:
      response = await client.get(f'{CATALOG_SERVICE_URL}/catalog')
      return response.status_code, response.json()
    except (httpx.ConnectError) as e:
        if isinstance(e, httpx.ConnectError):
          return 503, { "message": "Service Unavailable" }
        return 500, { "message": "Internal Server Error" } 