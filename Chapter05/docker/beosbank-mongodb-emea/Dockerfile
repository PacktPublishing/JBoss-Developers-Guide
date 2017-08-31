FROM mongo:3.4.4
COPY ./init.json /init.json
CMD mongoimport --host mongo_db_emea -d beosbank-emea-ref -c countries /init.json

