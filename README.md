**Bookstore Application**

**Overview**

This is a Spring Boot-based demo project for an online bookstore, featuring three microservices:

**Book Catalog** - Manages book-related data.
**User Info** - Manages user-related data.
**Book Order Management** - Handles orders, including carts and payments.
The application uses a centralized DynamoDB NoSQL database with three tables (Book, User, and Order) and supports concurrent writes with DynamoDbEnhancedAsyncClient.

**Project Features**

**Microservices:**

**Book Catalog Service**: CRUD operations for books.
**User Info Service**: CRUD operations for users.
**Order Management Service**: Handles book orders and concurrency.

**DynamoDB Integration:**

Uses DynamoDbEnhancedAsyncClient for asynchronous database interactions.
Automatically creates DynamoDB tables (Book, User, Order) on startup.

**Concurrency Support:**
Simulates multiple users placing orders simultaneously.
REST API Endpoints for each service.

**Technologies Used**
Java 17
Spring Boot (Latest version)
AWS SDK v2 for DynamoDB
Lombok for cleaner code
Maven for dependency management
JUnit 5 for unit testing

**Setup and Installation**

**Prerequisites**

Java 17 or later installed.
Maven installed.
AWS DynamoDB: Use a local DynamoDB instance for testing (e.g., via AWS DynamoDB Local) or connect to a remote DynamoDB instance in AWS.

Optional: Postman or cURL for API testing.

**Steps**

Clone the Repository:

git clone git@github.com:someswar07/BookOrderManagement.git
cd bookstore-app
Build the Project:

mvn clean install
Configure DynamoDB: Update the src/main/resources/application.yml file with your AWS DynamoDB configuration:

aws:
  dynamodb:
    region: <your-region>
    endpoint: <your-dynamodb-endpoint>
Run the Application:

mvn spring-boot:run
Verify DynamoDB Tables: Ensure that Book, User, and Order tables are created automatically in DynamoDB.

**REST API Endpoints**

The following endpoints are available:

**Book Catalog Service**

Add a Book:

POST /book/addBook

Request Body:
{
  "id": "b1",
  "title": "The Art of Java",
  "author": "John Doe"
}


**User Info Service**

Add a User:

POST /users/register
Request Body:
{
  "id": "u1",
  "name": "Alice"
}

**Order Management Service**

Place an Order:

POST /order/place
Request Body:
{
  "id": "o1",
  "userId": "u1",
  "bookId": "b1",
  "quantity": 1
}

**Testing**

Unit tests are provided for the core functionality. Run the tests with:

mvn test
Future Enhancements
Implement more robust error handling.
Add additional endpoints (e.g., update and delete operations).
Integrate payment gateways for realistic order processing.
Deploy to a cloud environment (AWS ECS, Fargate, or Elastic Beanstalk).

**Contributing**

Feel free to fork the repository, create a new branch, and submit a pull request. Contributions are always welcome!

**License**

This project is licensed under the MIT License. See the LICENSE file for details.
