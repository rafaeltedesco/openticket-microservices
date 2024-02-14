import { ModelStatic } from 'sequelize';
// import NotFoundError from '../utils/errors/not-found-error';
import Order from '../database/models/Orders';

export default class OrdersServices {
  constructor(
    private orderModel: ModelStatic<Order> = Order,
  ) {}

  public async show(): Promise<Order[]> {
    const orders = await this.orderModel.findAll();
    return orders;
  }
}