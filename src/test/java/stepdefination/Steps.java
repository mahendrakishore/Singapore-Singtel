package stepdefination;

import java.util.List;
import java.util.Map;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Steps {
	
	private static Adapter ADAPTER = new Adapter();

	@Given("User hit the typidode get request")
	public void  methodget(){	
		ADAPTER.getPostWithValidation();
	}
	
	   @Given("User make a posts on typidode with below values")
	    public void makePosts(DataTable dt) throws JsonProcessingException {
	        List<Map<String, String>> dtlm = dt.asMaps(String.class,String.class);
	       ADAPTER.createPost(dtlm);
	       ADAPTER.createPostRequest();
	    }
	   
	   @Given("User make a comment with below values")
	    public void makeCommentPosts(DataTable dt) throws JsonProcessingException {
	        List<Map<String, String>> dtlm = dt.asMaps(String.class,String.class);
	       ADAPTER.createCommentOnPost(dtlm);
	     	    }
	   
	   @Given("User post the comment on postsid {string} on typidode")
	    public void makeCommentOnPosts(String id) throws JsonProcessingException {
	          ADAPTER.createCommentOnPostRequest(id);
	    }
}
