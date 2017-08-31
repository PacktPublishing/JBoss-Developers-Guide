FROM mysql:5.7.15

MAINTAINER elvadas nono<enono

ENV MYSQL_DATABASE=beosbank-africa \
    MYSQL_ROOT_PASSWORD=Africa01#

ADD beosbank-africa.sql /docker-entrypoint-initdb.d

EXPOSE 3306

