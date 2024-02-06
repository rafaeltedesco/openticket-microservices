from pydantic import BaseModel

class InventoryEventCreationDto(BaseModel):
  name: str
  eventDateTime: str
  ticketsAvailable: int