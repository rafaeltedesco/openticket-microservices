const autocannon = require('autocannon');
const { faker } = require('@faker-js/faker');

function generateRandomEvent() {
  return {
    name: faker.word.words(3),
    eventDateTime: faker.date.future(),
    ticketsAvailable: faker.number.int(100, 10000),
  };
}

const options = {
  url: 'http://localhost/inventory/',
  method: 'POST',
  connections: 15,
  duration: 10,
  body: JSON.stringify(generateRandomEvent()),
  headers: {
    'Content-Type': 'application/json',
  },
}

const instance = autocannon(options);

instance.on('response', (client, statusCode, resBytes) => {
  console.log(`Got response with status code: ${statusCode}`);
  
  options.body = JSON.stringify(generateRandomEvent());
  console.log(options.body);
  client.setHeaders('content-length', Buffer.byteLength(options.body));
  client.setBody(options.body);
})

autocannon.track(instance, { renderProgressBar: true, renderLatencyTable: true });

process.on('SIGINT', () => {
  autocannon.destroy(instance);
})

process.on('SIGTERM', () => {
  autocannon.destroy(instance);
})

