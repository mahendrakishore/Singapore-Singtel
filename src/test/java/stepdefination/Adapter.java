package stepdefination;

import java.util.List;
import java.util.Map;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Adapter {
	
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";
	private static final Context CONTEXT = new Context();
	
	
	/*
	 * public void getPost() { Response response =
	 * RestAssured.get("https://jsonplaceholder.typicode.com/posts");
	 * System.out.println(response.prettyPrint());
	 * System.out.println(response.getStatusCode());
	 * System.out.println(response.getTime());}
	 */	
	public void getPostWithValidation() {
		CONTEXT.setUri(BASE_URL);
		Response response;
		String uri = CONTEXT.getUri();
		System.out.println(uri);
		RestAssured.baseURI = uri;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.get();
		CONTEXT.setGetResponse(response);
		Response repString = (Response) CONTEXT.getGetResponse();
		System.out.println(repString.prettyPrint());
		}


    public void createPost(List<Map<String, String>> dtl) throws JsonProcessingException {
    	PostPojoClass postPojoClass = new PostPojoClass();
        for (int i = 0; i < dtl.size(); i++) {
            postPojoClass.setUserId(dtl.get(i).get("userId"));
            postPojoClass.setTitle(dtl.get(i).get("title"));
            postPojoClass.setBody(dtl.get(i).get("body"));
        }
        ObjectMapper om = new ObjectMapper();
        String postString = om.writeValueAsString(postPojoClass);
        CONTEXT.setPostRequestString(postString);
        System.out.println(CONTEXT.getPostRequestString().toString());
    }
    
    public void createPostRequest()  {
    	CONTEXT.setUri(BASE_URL);
		Response response;
		String uri = CONTEXT.getUri();
		System.out.println(uri);
		RestAssured.baseURI = uri;
		String body =  (String) CONTEXT.getPostRequestString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(body).post();
		CONTEXT.setPostResponse(response);
		Response repString = (Response) CONTEXT.getPostResponse();
		System.out.println(repString.prettyPrint());
    }
    
    public void createCommentOnPost(List<Map<String, String>> dtl) throws JsonProcessingException {
    	PostPojoClass postPojoClass = new PostPojoClass();
        for (int i = 0; i < dtl.size(); i++) {
            postPojoClass.setUserId(dtl.get(i).get("name"));
            postPojoClass.setTitle(dtl.get(i).get("email"));
            postPojoClass.setBody(dtl.get(i).get("body"));
        }
        ObjectMapper om = new ObjectMapper();
        String postString = om.writeValueAsString(postPojoClass);
        CONTEXT.setCommentOnPostRequestString(postString);
        System.out.println(CONTEXT.getCommentOnPostRequestString().toString());
    }
    public void createCommentOnPostRequest(String id)  {
    	CONTEXT.setUri(BASE_URL);
		Response response;
		String uri = CONTEXT.getUri();
		String commentUri = uri+"/"+id+"/comments";
		System.out.println(commentUri);
		RestAssured.baseURI = commentUri;
		String body =  (String) CONTEXT.getCommentOnPostRequestString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(body).post();
		CONTEXT.setCommentOnPostResponse(response);
		Response repString = (Response) CONTEXT.getCommentOnPostResponse();
		System.out.println(repString.prettyPrint());
    }
}
