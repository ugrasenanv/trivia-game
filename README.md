Build and Run
Build the project:

Run mvn clean package to build the project and generate the JAR file.
Build Docker containers:

Run docker-compose build to build the Docker images.
Run the application:

Run docker-compose up to start the application.
Final Setup Check
Verify that the application is running by visiting http://localhost:8080/trivia/start.
Test the /reply/{triviaId} endpoint using tools like Postman.


POST /trivia/start
PUT /trivia/reply



src\main\java\com\springproject\SpringTriviaApp\service\TriviaService.java


