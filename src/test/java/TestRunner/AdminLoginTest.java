package TestRunner;

//import org.junit.runner.RunWith;
import org.openqa.selenium.remote.html5.AddLocationContext;

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/adminlogin.feature",glue="stepdefinitions",dryRun=false,plugin= {"com.cucumber.listener.ExtentCucumberFormatter:reports/admintest.html"})
public class AdminLoginTest extends AbstractTestNGCucumberTests
{

	
	
}
