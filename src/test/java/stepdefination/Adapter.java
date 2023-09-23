package stepdefination;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Adapter {
	
	
	
	
	public void getPost() {
		Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
		System.out.println(response.prettyPrint());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());}
	

}
