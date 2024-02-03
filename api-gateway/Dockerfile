FROM python:3.11-alpine

RUN apk update && apk add make && \
  apk add poetry

WORKDIR /api-gateway

COPY poetry.lock pyproject.toml ./

RUN poetry install --no-root

COPY . .

ENV API_GATEWAY_PORT=80

EXPOSE ${API_GATEWAY_PORT}

CMD ["make", "run"]