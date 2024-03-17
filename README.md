# Word Square API

This Spring Boot application generates a valid Word Square given:

- The size of the grid (n).
- A pool of characters to generate words from.

The characters provided in the pool MUST be equal to the grid size squared (n²).

## Getting Started

### Prerequisites

- Git
- Java 11
- Maven (optional if you use the Maven wrapper included in the project)
- IDE of your choice (optional for running directly from the IDE)
- Postman (optional for making API calls)

### Running the Application

1. Open your terminal or command prompt.

2. Clone the repository using Git:

   ```bash
   git clone https://github.com/arsy786/word-square-api.git
   ```

3. Navigate to the cloned repository's root directory:

   ```bash
   cd word-square-api
   ```

4. Run the following Maven command to build and start the service:

   ```bash
   # For Maven
   mvn spring-boot:run

   # For Maven Wrapper (automatically uses the correct Maven version)
   ./mvnw spring-boot:run
   ```

   This command compiles the application, starts the Spring Boot application, and deploys it on the embedded server. It's convenient during development for quick testing and debugging.

   The application should now be running on `localhost:8080`.

### Building the Application

1. To build the application for deployment, run the following command:

   ```bash
   # For Maven
   mvn clean package

   # For Maven Wrapper
   ./mvnw clean package
   ```

   This command compiles the application, runs any tests, and packages the compiled code into a runnable .jar file located in the target directory.

2. After building the application, you can run it using the following command:

   ```bash
   java -jar target/football-club-management-system-0.0.1-SNAPSHOT.jar
   ```

   This starts the Spring Boot application using the packaged .jar file. It's suitable for deploying or sharing the application in a production-like environment.

### Using the API

You can send a POST request through two methods: by specifying data in the request body or by embedding data in the path variables. Both methods generate a word square using the provided grid size and character pool.

<ins>Request Body approach:</ins>

    Method: POST
    URL: http://localhost:8080/api/v2/wordsquare/
    Body (raw JSON):
    {
      "gridSize": 4,
      "charPool": "aaccdeeeemmnnnoo"
    }

<ins>Path Variable approach:</ins>

```bash
# Format
[POST] http://localhost:8080/api/v2/wordsquare/{gridSize}/{charPool}

# Example
[POST] http://localhost:8080/api/v2/wordsquare/7/aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy
```
