import * as express from 'express';
import 'express-async-errors';
import ordersRouter from './routers/orders.router';

// import errorMiddleware from './middlewares/errorMiddleware';

class App {
  public app: express.Express;

  constructor() {
    this.app = express();

    this.config();
    this.routes();

    this.app.get('/', (req, res) => res.json({ ok: true }));

    // this.app.use(errorMiddleware);
  }

  private routes(): void {
    this.app.use('/orders', ordersRouter);
  }

  private config(): void {
    const accessControl: express.RequestHandler = (_req, res, next) => {
      res.header('Access-Control-Allow-Origin', '*');
      res.header('Access-Control-Allow-Methods', 'GET,POST,DELETE,OPTIONS,PUT,PATCH');
      res.header('Access-Control-Allow-Headers', '*');
      next();
    };

    this.app.use(express.json());
    this.app.use(accessControl);
  }

  public start(PORT: string | number): void {
    this.app.listen(PORT, () => console.log(`Running on port ${PORT}`));
  }
}

export { App };

export const { app } = new App();