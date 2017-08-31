FROM library/postgres

MAINTAINER elvadas nono<enono>

ENV POSTGRES_DB=beosbank-europa \
    POSTGRES_USER=root \
    POSTGRES_PASSWORD=Europa01# 


ADD  beosbank-europa.sql /docker-entrypoint-initdb.d

EXPOSE 5432

