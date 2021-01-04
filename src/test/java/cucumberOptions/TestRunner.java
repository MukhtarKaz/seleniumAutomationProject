package cucumberOptions;

// import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// To run test we need to give CucumberOptions with locations feature files and stepDefinition

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/", glue = "StepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
