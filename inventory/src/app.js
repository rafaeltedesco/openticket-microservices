const express = require('express');

const inventoryRouter = require('./routers/inventory.router');

const app = express();

app.use(express.json());

app.use('/inventory', inventoryRouter);

module.exports = app;
