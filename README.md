
# Microservicio REST de Productos

Este microservicio está construido en **Spring Boot 3.3.4** utilizando **Java JDK 17** y **Maven**. Su propósito es recuperar información relevante sobre los productos de una base de datos.

## Requisitos

- Java JDK 17
- Maven 3.9.6 o superior

## Instalación

1. **Clona el repositorio**:

   ```bash
   git clone <https://github.com/Mirevea/manageItemsAndPrices>
   cd <manageItemsAndPrices>
   ```

2. **Compila e instala el proyecto**:

   Ejecuta el siguiente comando para compilar el proyecto. Este paso también asegura que se ejecute el archivo `pricesdatabase.yml` para realizar la inserción inicial de datos en la base de datos.

   ```bash
   mvn clean install
   ```

## Ejecución

Para ejecutar el microservicio, utiliza el siguiente comando:

```bash
mvn spring-boot:run
```

Una vez que el microservicio esté en funcionamiento, podrás acceder a la aplicación en:

```
http://localhost:8080
```

## Endpoints

- **GET /api/itemsAndPrices/page-query: Recupera una lista de todos los productos en base a x condiciones (Body válido json).
- **GET /products/{id}**: Recupera la información de un producto específico por su ID.

## Notas
