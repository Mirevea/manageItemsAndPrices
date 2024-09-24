
# Product REST Microservice

This microservice is built on **Spring Boot 3.3.4** using **Java JDK 17** and **Maven**. Its purpose is to retrieve relevant information about products from a database.

## Requirements

- Java JDK 17
- Maven 3.9.6 or higher

## Installation

1. **Clone the repository**:

   ```bash
   git clone <https://github.com/Mirevea/manageItemsAndPrices>
   cd <manageItemsAndPrices>
   ```

2. **Build and install the project**:

   Run the following command to compile the project. This step also ensures that the `pricesdatabase.yml` file is executed to perform the initial data insertion into the database.

   ```bash
   mvn clean install
   ```

## Running

To run the microservice, use the following command:

```bash
mvn spring-boot:run
```

Once the microservice is up and running, you can access the application at:

```
http://localhost:8080
```

## Endpoints

- **GET /api/itemsAndPrices/page-query**: Retrieves a list of all products based on specified conditions (valid JSON body).
- **GET /products/{id}**: Retrieves the information of a specific product by its ID.

## Notes
