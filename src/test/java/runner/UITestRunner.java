package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/UITest.feature", glue = "steps", tags = "@SmokeTest", plugin = {"pretty","html:target/reports.html"})
public class UITestRunner {

}
