const { Inventory } = require('../db/models');
const domainResponse = require('../utils/domainResponses');

/**
 *
 * @param {{
 * name: string,
 * eventDateTime: string,
 * ticketsAvailable: number
 * }} inventoryCreationDto
 */

const eventAlreadyExists = async (inventoryCreationDto) => {
  const event = await Inventory.findOne({
    where: {
      name: inventoryCreationDto.name,
      eventDateTime: inventoryCreationDto.eventDateTime,
    },
  });
  return event !== null;
};

const hasValidDate = (eventDateTime) => {
  const eventDate = new Date(eventDateTime);
  const currentDate = new Date();
  return eventDate > currentDate;
};

const createEvent = async (inventoryCreationDto) => {
  if (!hasValidDate(inventoryCreationDto.eventDateTime)) {
    return { status: domainResponse.BAD_REQUEST, data: { error: 'Invalid date' } };
  }
  
  if (await eventAlreadyExists(inventoryCreationDto)) {
    return { status: domainResponse.CONFLICT, data: { error: 'Event already exists' } };
  }
  
  // registrar no banco de dados o novo evento

  // produzir evento para o tópico new-event-added
  
  return { status: domainResponse.CREATED, data: {} };
};

const showRegisteredEvents = async () => {
  const inventory = await Inventory.findAll();
  return { status: domainResponse.OK, data: inventory };
};

module.exports = {
  createEvent,
  showRegisteredEvents,
};
