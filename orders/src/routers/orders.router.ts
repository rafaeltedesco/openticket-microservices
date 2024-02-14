import { Router } from 'express';

import OrdersController from '../controllers/orders.controller';

const ordersController = new OrdersController();

const router = Router();

router.get('/', (_req, _res) => console.log('Batatinha'));

router.get('/api/orders/:orderId', (req, res) => ordersController.showOrders(req, res));

export default router;