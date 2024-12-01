import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

	@Test
	public void testGetRequest() {
	    // Sending a GET request to JSONPlaceholder API
	    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

	    // Assert status code 200 (OK)
	    Assert.assertEquals(response.getStatusCode(), 200);

	    // Assert response body is not null
	    Assert.assertNotNull(response.getBody());

	    // Check if the response contains expected fields
	    Assert.assertTrue(response.getBody().asString().contains("userId"));
	    Assert.assertTrue(response.getBody().asString().contains("title"));
	    Assert.assertTrue(response.getBody().asString().contains("body"));
	

        
        /*
         * This test is a temporary solution to verify the status code of a GET request.
         * In the future, we can enhance this test to:
         * 1. Validate the response body for specific fields and values.
         * 2. Handle different response scenarios (e.g., non-200 status codes, timeouts).
         * 3. Implement data-driven testing for multiple endpoints and different parameters.
         */

        /*
         * Plan to reduce tech-debt:
         * 1. Add assertions to validate the response body (e.g., check fields like userId, title).
         * 2. Handle different response scenarios (e.g., 404, 500 status codes).
         * 3. Implement data-driven testing for multiple endpoints and different request scenarios.
         */

        
    }
    
    @Test
    public void testAllPosts() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        // Assert status code
        Assert.assertEquals(response.getStatusCode(), 200);
        
        // Assert that the response body contains a list of posts
        Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
    }
    
    /*
     * Technical Documentation:
     * The following code section has performance issues under heavy load.
     * No immediate refactoring planned, but documented for future reference.
     */

    
    @Test
    public void testPostRequest() {
        // Known issue: This endpoint occasionally fails under heavy load.
        Response response = RestAssured.given()
                .contentType("application/json")
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .post("https://jsonplaceholder.typicode.com/posts");
        
        // Assert that the status code is 201 (Created)
        Assert.assertEquals(response.getStatusCode(), 201);
    }
    
    /*
     * Technical Debt:
     * The POST request test is a basic implementation and lacks proper error handling.
     * Future improvements should include:
     * 1. Detailed response validation (e.g., checking actual values of userId, title, body).
     * 2. Error handling for various status codes (e.g., 404, 500).
     * 3. Data-driven testing for multiple request bodies.
     */
    
    public void problematicMethod() {
        // Known issue: This method has high cyclomatic complexity.
        // Documenting for future refactoring
    }
    
    @Test
    public void testGetAllPosts() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        
        // Assert status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response body is a list and contains multiple posts
        Assert.assertTrue(response.getBody().jsonPath().getList("$").size() > 0);
    }

    
    @Test
    public void testCreatePost() {
        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        // Send POST request to create a new post
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("https://jsonplaceholder.typicode.com/posts");

        // Assert status code 201 (Created)
        Assert.assertEquals(response.getStatusCode(), 201);

        // Assert the response body contains the expected data
        Assert.assertTrue(response.getBody().asString().contains("foo"));
        Assert.assertTrue(response.getBody().asString().contains("bar"));
        Assert.assertTrue(response.getBody().asString().contains("1"));
    }
    
    @Test
    public void testUpdatePost() {
        int postId = 1; // Use an existing post for testing
        String requestBody = "{ \"id\": 1, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1 }";

        // Send PUT request to update the post
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put("https://jsonplaceholder.typicode.com/posts/" + postId);

        // Assert status code 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert the updated data is returned in the response
        Assert.assertTrue(response.getBody().asString().contains("updated title"));
        Assert.assertTrue(response.getBody().asString().contains("updated body"));
    }
    
    @Test
    public void testCreatePostWithValidData() {
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is a new post\", \"userId\": 2 }";

        // Send POST request to create a new post
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("https://jsonplaceholder.typicode.com/posts");

        // Assert status code 201 (Created)
        Assert.assertEquals(response.getStatusCode(), 201);

        // Assert that the response body contains the expected data
        Assert.assertTrue(response.getBody().asString().contains("New Post"));
        Assert.assertTrue(response.getBody().asString().contains("This is a new post"));
    }

    @Test
    public void testUpdatePostWithValidData() {
        int postId = 1; // Use an existing post ID for testing
        String requestBody = "{ \"id\": 1, \"title\": \"Updated Post Title\", \"body\": \"Updated content\", \"userId\": 1 }";

        // Send PUT request to update the post
        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put("https://jsonplaceholder.typicode.com/posts/" + postId);

        // Assert status code 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response body contains updated title and body
        Assert.assertTrue(response.getBody().asString().contains("Updated Post Title"));
        Assert.assertTrue(response.getBody().asString().contains("Updated content"));
    }

    @Test
    public void testGetRequestStatusAndResponseTime() {
        long maxResponseTime = 2000; // Maximum allowed response time in milliseconds

        // Send GET request
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        // Assert status code 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response time is below the threshold
        Assert.assertTrue(response.getTime() < maxResponseTime, "Response time is too high!");
    }
    
    @Test
    public void testJsonResponseStructure() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        // Assert status code 200 (OK)
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response body contains the expected fields
        Assert.assertTrue(response.getBody().asString().contains("id"));
        Assert.assertTrue(response.getBody().asString().contains("title"));
        Assert.assertTrue(response.getBody().asString().contains("body"));
        Assert.assertTrue(response.getBody().asString().contains("userId"));
    }
    
    @Test
    public void testGetPostsForNonExistentUser() {
        int nonExistentUserId = 999; // Using a non-existent userId

        // Send GET request with query parameter
        Response response = RestAssured.given()
                .queryParam("userId", nonExistentUserId)
                .get("https://jsonplaceholder.typicode.com/posts");

        // Assert status code 200 (OK), even though no posts exist for this user
        Assert.assertEquals(response.getStatusCode(), 200);

        // Assert that the response body is empty or contains no posts
        Assert.assertTrue(response.getBody().jsonPath().getList("$").isEmpty());
    }
}
