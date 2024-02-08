const autocannon = require('autocannon');
const { faker } = require('@faker-js/faker');
const uuid = require('uuid');

const initialEvent = generateRandomEvent();

const options = {
  url: 'http://localhost/inventory/',
  method: 'POST',
  connections: 40,
  duration: 60,
  body: JSON.stringify(initialEvent),
  headers: {
    'Content-Type': 'application/json',
  },
}

const instance = autocannon(options);

instance.on('response', (client, statusCode, _resBytes) => {
  console.log(`Got response with status code: ${statusCode}`);

  const randomEvent = generateRandomEvent();
  const requestBody = JSON.stringify(randomEvent);

  console.log(requestBody);
  client.setHeaders('content-length', Buffer.byteLength(requestBody));
  client.setBody(requestBody);
});

autocannon.track(instance, { renderProgressBar: true, renderLatencyTable: true });

process.on('SIGINT', () => {
  autocannon.destroy(instance);
});

process.on('SIGTERM', () => {
  autocannon.destroy(instance);
});

function generateRandomEvent() {
  return {
    name: faker.word.words(2) + uuid.v4(),
    eventDateTime: faker.date.future(),
    ticketsAvailable: faker.number.int(100, 10000),
  };
}
