FROM node:alpine

EXPOSE 3000

RUN mkdir app

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

CMD ["npm", "start"]