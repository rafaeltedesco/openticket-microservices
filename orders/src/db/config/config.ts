import { Options } from 'sequelize';

const config: Options = {
  username: process.env.DB_USER || 'root',
  password: process.env.DB_PASSWORD || 'mysql',
  database: 'orders',
  host: process.env.DB_HOST || 'localhost',
  dialect: 'mysql',
  port: Number(process.env.DB_PORT) || 3306,
  dialectOptions: {
    timezone: 'Z',
  },
  logging: false,
}

export = config;