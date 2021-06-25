package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"
		, "html:target/cucumber"
		, "summary"
		, "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"}
,features = {"src/test/resources/features/"}
,glue = {"steps"}
,snippets = CAMELCASE
,dryRun=false
,monochrome=true
,strict=true
,tags = "@SmokeTest")
public class TestRunnerTest {

}
