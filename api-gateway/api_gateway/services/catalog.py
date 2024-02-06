import httpx, os

CATALOG_SERVICE_URL = os.getenv("CATALOG_SERVICE_URL", "http://localhost:3030")

def fetch_catalog():
    try:
      response = httpx.get(f'{CATALOG_SERVICE_URL}/catalog')
      return response.json()
    except httpx.RequestError as e:
        print("Request error", e)
        return {"error": "Catalog Service is not available"}
   