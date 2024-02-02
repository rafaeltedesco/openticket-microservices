import httpx, os

CATALOG_SERVICE = os.getenv("CATALOG_SERVICE", "http://localhost:3030")

def fetch_catalog():
    response = httpx.get(f'{CATALOG_SERVICE}/catalog')
    if (response.status_code != 200):
        return {"error": "Catalog Service is not available"}
    return response.json()