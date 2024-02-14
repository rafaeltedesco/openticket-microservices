import { ModelStatic } from 'sequelize';
// import NotFoundError from '../utils/errors/not-found-error';
import Order from '../db/models/Order';
import IOrderRequest from '../interfaces/IOrderRequest';

export default class OrdersServices {
  constructor(
    private orderModel: ModelStatic<Order> = Order,
  ) {}

  public async createOrder({ userId, eventId, ticketsRequested }: IOrderRequest): Promise<Order> {
    const newOrder = await this.orderModel.create({ userId, eventId, ticketsRequested });    
    return newOrder;
  }

  public async showOrders(): Promise<Order[]> {
    const orders = await this.orderModel.findAll();
    return orders;
  }
}