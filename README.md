# paygoal-api

ApiRest - Productos

1) End Points:

* productos/getAll
* productos/byId/{id}
* productos/byName/{nombre}
* productos/saveProduct
* productos/delete/{id}
* productos/update/{id}
* productos/orderByPrice

2) En el archivo "application.properties" dentro de la carpeta resources, estara setteada la configuracion para la DB
   en este caso una H2, de la siguiente forma:
* usuario y password = prueba
* server.port = 8080

3) Dentro de la carpeta postman collection, encontraran el JSON para ejecutar las solicitudes a los endpoints.
