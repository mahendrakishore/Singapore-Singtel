package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "@posts-post", features = "src/test/resources/features/post-comment.feature", 
glue = "stepdefination",monochrome=true,publish=true
		)

public class CucumberTestNGRunner extends AbstractTestNGCucumberTests{

}
