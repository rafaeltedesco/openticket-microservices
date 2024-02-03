from pydantic import BaseModel

class CatalogEventCreationDto(BaseModel):
  name: str
  eventDateTime: str
  ticketsAvailable: int