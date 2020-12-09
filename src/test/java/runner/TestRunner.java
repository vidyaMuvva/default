package runner;


import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
	    ,plugin = {"json:target/cucumber.json"}
		,glue={"stepDefinition"}
		,tags={"@Deals"}
		//,monochrome=true //to display clear output on console in readable format
		//,dryRun=true //checks the mapping between feature file and stepDef file
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
