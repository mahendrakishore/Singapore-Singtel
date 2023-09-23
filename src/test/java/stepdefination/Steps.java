package stepdefination;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Steps {
	
	private static Adapter ADAPTER = new Adapter();

	@Given("I want to write a step with precondition")
	public void  methodget(){	
		ADAPTER.getPost();
	}
}
