# Pokedemo

Pokedemo es un wrapper de la API alojada en pokeapi.co con Spring Boot y React web.

## Deploy

Backend:

```bash
cd backend \
mvn clean install && java -jar target/pokedemo-0.0.1-SNAPSHOT.jar
```


Frontend:

Configurar IP donde se aloja el backend en el archivo ```src/frontend/config/config.js``` y luego:


```bash
cd frontend \
yarn start
```