# OpenTicket - Microservices Demonstration Application

### 🚧🚧🚧🚧🚧 Under Construction 🚧🚧🚧🚧🚧 

This application has been developed to showcase the operation and implementation of microservices.

## Microservices and Technologies Used

The application utilizes different programming languages for each microservice:

- **Python with FastAPI:** [api-gateway](./api-gateway/)
- **Java with Spring Boot:** [catalog](./catalog/)
- **JavaScript with Express:** [inventory](./inventory/)
- **Golang:** [users](./users/)
- **Typescript with Nest.js:** *in progress*


## How to Use

1 - Clone the repository.
2 - Run `docker-compose -f compose-kafka.yml up -d` to start Kafka and Zookeeper.
3 - Choose the microservice you want to explore and execute the Docker Compose command for the corresponding file.

Feel free to explore and learn from the codebase! If you have any questions or feedback, don't hesitate to reach out.
