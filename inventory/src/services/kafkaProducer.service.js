const Kafka = require('node-rdkafka');

const producer = new Kafka.Producer({
  'metadata.broker.list': process.env.KAFKA_BOOTSTRAP_SERVERS || 'localhost:9092',
});

producer.connect();

const produceMessage = (topic, message) => {
  producer.produce(topic, null, Buffer.from(message));
  console.log(`Message produced to topic: ${topic}`);
};

module.exports = {
  produceMessage,
};