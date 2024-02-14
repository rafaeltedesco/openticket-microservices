import { Request, Response } from 'express';
import OrdersServices from '../services/orders.service';

export default class OrdersController {
  constructor(
    private ordersServices = new OrdersServices(),
  ) {}

  public async createOrders(req: Request, res: Response): Promise<Response> {
    const order = await this.ordersServices.createOrder(req.body);
        
    return res.status(201).json(order);
  }

    public async showOrders(req: Request, res: Response): Promise<Response> {
    const orders = await this.ordersServices.showOrders();
    return res.status(200).json(orders);
  }

}