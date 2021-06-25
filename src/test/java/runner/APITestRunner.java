package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/APITest.feature", glue = "steps", tags = "@SmokeTest", monochrome=true, plugin = {"pretty","html:target/reports.html"})
public class APITestRunner {

}
