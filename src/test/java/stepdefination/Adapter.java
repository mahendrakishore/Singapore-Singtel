package stepdefination;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Adapter {

	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
	private static final Context CONTEXT = new Context();

	public void getUserList() {
		CONTEXT.setUri(BASE_URL);
		Response response;
		String uri = CONTEXT.getUri();
		String userListUri = uri + "users";
		System.out.println(userListUri);
		RestAssured.baseURI = userListUri;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.get();
		CONTEXT.setUserListGetResponse(response);
	}

	public void userListValidation(int lCount) {
		Response repString = (Response) CONTEXT.getUserListGetResponse();
		System.out.println(repString);
		Assert.assertEquals("Wrong Status Code", 200, repString.statusCode());
		JsonPath js = new JsonPath(repString.asString());
		int cSize = js.getList("$").size();
		System.out.println(cSize);
		Assert.assertEquals("User list count not matching", 10, cSize);
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

	public void createPostRequest() {
		CONTEXT.setUri(BASE_URL);
		Response response;
		String uri = CONTEXT.getUri();
		String postsUri = uri + "posts";
		System.out.println(postsUri);
		RestAssured.baseURI = postsUri;
		String body = (String) CONTEXT.getPostRequestString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(body).post();
		CONTEXT.setPostResponse(response);
			}
	
	public void postsValidation() {
		Response repString = (Response) CONTEXT.getPostResponse();
		System.out.println(repString);
		Assert.assertEquals("Wrong Status Code", 201, repString.statusCode());
		int postID = 101;
		JsonPath js = new JsonPath(repString.asString()); 
		int respPostId = js.get("id");
		Assert.assertEquals("postis not matching",postID,respPostId);
		 
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

	public void createCommentOnPostRequest(String id) {
		CONTEXT.setUri(BASE_URL);
		CONTEXT.setPostId(id);
		Response response;
		String uri = CONTEXT.getUri();
		String commentUri = uri + "posts" + "/" + id + "/comments";
		System.out.println(commentUri);
		RestAssured.baseURI = commentUri;
		String body = (String) CONTEXT.getCommentOnPostRequestString();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		response = request.body(body).post();
		CONTEXT.setCommentOnPostResponse(response);
	}

	public void commentValidation() {
		Response repString = (Response) CONTEXT.getCommentOnPostResponse();
		System.out.println(repString);
		Assert.assertEquals("Wrong Status Code", 201, repString.statusCode());
		String postID = (String) CONTEXT.getPostId();
		JsonPath js = new JsonPath(repString.asString()); 
		String respPostId = js.get("postId");
		Assert.assertEquals("postid not matching on comment",postID,respPostId);
		 
	}
}
