# Pokedemo

Pokedemo es un wrapper de la API alojada en [pokeapi.co](https://pokeapi.co/) con Spring Boot y React web.

## Deploy

Backend:

```bash
cd backend \
mvn clean install && java -jar target/pokedemo-0.0.1-SNAPSHOT.jar
```


Frontend:

Configurar IP y puerto (por defecto 8080) donde se aloja el backend en el archivo ```frontend/src/config/config.js``` y luego:


```bash
cd frontend \
yarn install && yarn start
```

La aplicación estará corriendo en el puerto 3000.
