import { Router } from 'express';

import OrdersController from '../controllers/orders.controller';

const ordersController = new OrdersController();

const router = Router();


// router.get('/', (_req, res) => res.json({ ok: true }));

router.post('/', (req, res) => ordersController.createOrders(req, res));

router.get('/', (req, res) => ordersController.showOrders(req, res));


export default router;