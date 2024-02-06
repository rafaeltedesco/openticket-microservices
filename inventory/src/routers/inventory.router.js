const { Router } = require('express');

const inventoryController = require('../controllers/inventory.controller');

const inventoryRouter = Router();

inventoryRouter.post('/', inventoryController.createEvent);

module.exports = inventoryRouter;