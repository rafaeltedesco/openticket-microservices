FROM python:3.10-alpine

RUN apk update && apk add make && \
  apk add poetry

WORKDIR /api-gateway

COPY . .

RUN poetry install

ENV API_GATEWAY_PORT=80

EXPOSE ${API_GATEWAY_PORT}

CMD ["make", "run"]