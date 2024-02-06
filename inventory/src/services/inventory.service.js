const { Inventory } = require('../db/models');
const domainResponse = require('../utils/domainResponses');
const kafkaProducer = require('./kafkaProducer.service');

/**
 *
 * @param {{
 * name: string,
 * eventDateTime: string,
 * ticketsAvailable: number
 * }} inventoryCreationDto
 */
const createEvent = async (inventoryCreationDto) => {
  const newEvent = await Inventory.create(inventoryCreationDto);
  kafkaProducer.produceMessage(
    process.env.KAFKA_TOPIC || 'new-event-added',
    JSON.stringify({
      id: newEvent.id,
      name: newEvent.name,
      eventDateTime: newEvent.eventDateTime,
    }),
  );
  return { status: domainResponse.CREATED, data: newEvent };
};

module.exports = {
  createEvent,
};
