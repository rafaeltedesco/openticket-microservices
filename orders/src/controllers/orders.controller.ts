import { Request, Response } from 'express';
import OrdersServices from '../services/orders.service';

export default class OrdersController {
  constructor(
    private ordersServices: new OrdersServices(),
  ) {}

  public async showOrders(req: Request, res: Response): Promise<Response> {
    const orders = await this.ordersServices.showOrders();
    return res.status(200).json(orders);
  }

}