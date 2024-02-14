import {
  DataTypes,
  Model,
  InferAttributes,
  InferCreationAttributes,
  CreationOptional,
} from 'sequelize';
import db from '.';

class Order extends Model<InferAttributes<Order>,
InferCreationAttributes<Order>> {
  declare id: CreationOptional<number>;
  declare userId: CreationOptional<number>;
  declare eventId: CreationOptional<number>;
  declare ticketsRequested: CreationOptional<number>;
}

Order.init({
  id: {
    type: DataTypes.INTEGER,
    allowNull: false,
    primaryKey: true,
    autoIncrement: true,
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
}, {
  sequelize: db,
  modelName: 'orders',
  timestamps: false,
  underscored: true,
});

export default Order;
