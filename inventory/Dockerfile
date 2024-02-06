FROM node:18

WORKDIR /app

COPY package* .

RUN npm ci

COPY . .

CMD ["npm", "start"]