# Word Square API

## Application Information

This Spring Boot application generates a valid Word Square given:

- The size of the grid (n).
- A pool of characters to generate words from.

### Disclaimer

**Note:** The characters provided in the pool MUST be equal to the grid size squared (n²).

## Prerequisites

- Java Development Kit (JDK) 11 or newer.
- Maven for building the project (optional if you use the Maven wrapper included in the project).
- IDE of your choice (optional for running directly from the IDE).

## Building & Running the Application

### Cloning the Repository

1. Open your terminal or command prompt.

2. Clone the repository using Git:

   ```bash
   git clone https://github.com/arsy786/word-square-api.git
   ```

3. Navigate to the cloned repository's root directory:

   ```bash
   cd word-square-api
   ```

### Using Maven Wrapper

1. Navigate to the project's root directory in your terminal and run:

   ```bash
   ./mvnw clean package
   ```

This command compiles the application and packages it into a runnable .jar file located in the target directory.

2. If you have Maven installed globally, you can run:

   ```bash
   mvn clean package
   ```

3. After building the application, you can run it using the following command:

   ```bash
   java -jar target/word-square-api-0.0.1-SNAPSHOT.jar
   ```

## Using the API

### Making a POST Request

You can use tools like Postman or curl to make a POST request to the application.

Using Postman

    Method: POST
    URL: http://localhost:8080/api/v2/wordsquare/
    Body (raw JSON):
    {
      "gridSize": 4,
      "charPool": "aaccdeeeemmnnnoo"
    }

Using curl

```bash
curl -X POST -H "Content-Type: application/json" -d '{"gridSize": 4, "charPool": "aaccdeeeemmnnnoo"}' http://localhost:8080/api/v2/wordsquare/
```

## Direct URL Access

Alternatively, you can directly access the API using the following URL format:

```bash
[POST] http://localhost:8080/api/v2/wordsquare/{gridSize}/{charPool}
```

For example:

```bash
[POST] http://localhost:8080/api/v2/wordsquare/7/aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy
```

This will return the generated word square based on the specified grid size and character pool.
