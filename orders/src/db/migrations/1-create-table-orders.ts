import { Model, QueryInterface, DataTypes } from 'sequelize';
import IOrder from '../../interfaces/IOrders';

export default {
  up(queryInterface: QueryInterface) {
    return queryInterface.createTable<Model<IOrder>>('orders', {
      id: {
        type: DataTypes.INTEGER,
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
      },
      userId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        field: 'user_id',
      },
      eventId: {
        type: DataTypes.INTEGER,
        allowNull: false,
        field: 'event_id',
      },
      ticketsRequested: {
        type: DataTypes.INTEGER,
        allowNull: false,
        field: 'tickets_requested',
      },
    })
  },
  down(queryInterface: QueryInterface) {
    return queryInterface.dropTable('orders');
  }
}
