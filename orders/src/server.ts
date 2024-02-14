import { App } from './app'; 

const PORT = process.env.APP_PORT || 3008;

new App().start(PORT);
export { PORT };
export default App;