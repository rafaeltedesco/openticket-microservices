import httpx, os

CATALOG_SERVICE = os.getenv("CATALOG_SERVICE", "http://localhost:3030")

def fetch_catalog():
    try:
      response = httpx.get(f'{CATALOG_SERVICE}/catalog')
      return response.json()
    except httpx.RequestError:
        return {"error": "Catalog Service is not available"}
    
    