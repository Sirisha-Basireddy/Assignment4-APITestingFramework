# API-Testing-Framework

**Project Overview**

This project is a REST API testing framework built using RestAssured and TestNG. It is designed to validate endpoints of the JSONPlaceholder API, a free fake API for testing and prototyping. The framework covers HTTP methods such as GET, POST, and PUT, ensuring endpoint functionality through comprehensive assertions and validations.

The project is modular and designed for extensibility, enabling the addition of more endpoints and tests with minimal effort. It also provides a base for implementing advanced testing techniques like response schema validation, performance testing, and dynamic data-driven testing.

**Prerequisites**

To set up and run this project, ensure you have the following installed:

1. Java Development Kit (JDK): Version 8 or later.
2. Maven: Dependency management and build automation tool.
3. Git: For cloning and version control.
4. Integrated Development Environment (IDE): IntelliJ IDEA, Eclipse, or any Java-compatible IDE.
   
**Project Structure**

1. src/test/java/ApiTest.java: Contains test cases to validate the API endpoints.
2. pom.xml: Manages project dependencies and build configurations.
3. README.md: Provides an overview of the project, setup instructions, and usage.
4. .gitignore: Specifies files to be ignored by Git.
   
**Dependencies**

The project uses the following dependencies, specified in the pom.xml file:

1. RestAssured: For REST API testing.
2. TestNG: For writing and managing test cases.
3. JSON Path: For JSON parsing and validation.
Maven automatically handles dependency installation.

**Setup Instructions**

1. Clone the Repository: Use the following command to clone the repository to your local machine:
bash
Copy code
git clone https://github.com/Sirisha-Basireddy/API-Testing-Framework.git
cd API-Testing-Framework
2. Open in IDE:
Open the project in your preferred IDE.
Import the Maven project to ensure dependencies are resolved.
3. Build the Project: Run the following command to download dependencies and build the project:
mvn clean install

**Running the Tests**

You can execute the test cases using Maven or an IDE:

1. Run All Tests with Maven:
mvn test
2. Run Tests Individually:
Open ApiTest.java in your IDE.
Right-click on a specific test method or the class and select "Run".

**Test Case Summary**

The test cases in this framework validate different aspects of the JSONPlaceholder API. Below is a summary:

1. GET Requests:

Validates the retrieval of a single post (testGetRequest).
Ensures the response body contains required fields (testJsonResponseStructure).
Checks retrieval of all posts (testGetAllPosts).
Handles edge cases, such as fetching posts for a non-existent user (testGetPostsForNonExistentUser).

2. POST Requests:

Creates a new post with valid data (testCreatePost and testCreatePostWithValidData).
Verifies server response and status codes.

3. PUT Requests:

Updates an existing post with valid data (testUpdatePost and testUpdatePostWithValidData).

4. Performance Validation:

Checks if the response time is under an acceptable threshold (testGetRequestStatusAndResponseTime).

**Future Improvements**

The project currently uses hardcoded values and basic assertions. Planned enhancements include:

1. Dynamic Test Data: Use parameterized tests with data-driven inputs.
2. Response Schema Validation: Use JSON Schema Validator to ensure response integrity.
3. Error Handling: Add comprehensive error handling for failed API calls.
4. Retry Logic: Implement retry mechanisms for transient failures.
5. Performance Testing: Extend tests to analyze server performance under high loads.
   
**Known Issues**

1. Some tests rely on hardcoded data and are not dynamic.
2. The framework lacks retry logic for unstable endpoints.
3. High cyclomatic complexity in some methods (problematicMethod).
   
**Contributing**

If you wish to contribute:

1. Fork the repository.
2. Create a new branch for your changes.
3. Submit a pull request with detailed documentation of your updates.

**Repository Link**

Access the project repository on GitHub: API Testing Framework.

