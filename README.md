# ControllerAdvice
Let's implement and test a simple Spring Boot application using @ControllerAdvice for centralized exception handling. 
We’ll create:
A simple REST controller.
A custom exception.
Global exception handling with @ControllerAdvice.
Testing the setup with Postman.

Step 1: Set Up a Simple REST Controller
We'll create a UserController with a sample endpoint to fetch a user by ID. If the user is not found, a custom ResourceNotFoundException will be thrown.

UserController.java

Step 2: Create a Custom Exception
We'll define a ResourceNotFoundException class to represent cases where a resource is not found.

ResourceNotFoundException.java

Step 3: Implement the Global Exception Handler
We'll now use @ControllerAdvice to create a GlobalExceptionHandler that handles ResourceNotFoundException and any other generic Exception.

GlobalExceptionHandler.java

Step 4: Run and Test the Application with Postman
Run the Spring Boot application.

Open Postman and test the following cases:

Valid Request: Send a GET request to http://localhost:8080/api/users/1. You should receive:

{
  "message": "User 1"
}

Resource Not Found: Send a GET request to http://localhost:8080/api/users/100. You should receive a 404 Not Found response:

{
  "status": 404,
  "error": "Resource Not Found",
  "message": "User not found with ID: 100",
  "timestamp": 1693253525000
}

Global Exception: Test a scenario that might throw a generic exception, such as a database connection issue (you can simulate one by stopping your database if connected). You should receive a 500 Internal Server Error response:
{
  "status": 500,
  "error": "Internal Server Error",
  "message": "Some generic error message",
  "timestamp": 1693253525000
}
