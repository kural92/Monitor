package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features= {"src/test/resources/M2.feature"},glue= {"stepDefinition"},monochrome=true,
plugin = {"pretty","junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/Json-report.json",
		"html:Report/HtmlReports.html","rerun:Failure/rerun.txt"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
publish=true)
public class Runner_1{

}
