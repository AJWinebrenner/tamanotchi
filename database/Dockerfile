FROM postgres:alpine

EXPOSE 5432

WORKDIR /app

COPY ./init_db.sh /docker-entrypoint-initdb.d

COPY ./tamanotchi.sql ./tamanotchi.sql