const InventoryService = require('../services/inventory.service');
const mapHttpStatus = require('../utils/httpStatusCodeMapper');

const createEvent = async (req, res) => {
  const { name, eventDateTime, ticketsAvailable } = req.body;
  const response = await InventoryService.createEvent({ name, eventDateTime, ticketsAvailable });
  res.status(mapHttpStatus(response.status)).json(response.data);
};

module.exports = {
  createEvent,
};