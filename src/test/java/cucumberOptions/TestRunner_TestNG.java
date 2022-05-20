package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features/login.feature", glue="stepDefinitions")
public class TestRunner_TestNG extends AbstractTestNGCucumberTests {

 
}
