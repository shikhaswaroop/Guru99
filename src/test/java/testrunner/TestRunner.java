package testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
/**
 * 
 * @author Bhanu Pratap Singh
 * https:\\\\www.udemy.com\\seleniumbybhanu\\
 * https:\\\\www.youtube.com\\user\\MrBhanupratap29\\playlists
 *
 */
@CucumberOptions(features = "E:\\SeleniumProject_qedze\\guru99_Project\\src\\test\\resources\\features\\Login.feature", glue = { "E:\\SeleniumProject_qedze\\guru99_Project\\src\\test\\java\\stepdefinations\\LoginStepDefinitations.java" }, plugin = { "pretty", "html:target\\cucumber-reports\\cucumber-pretty",
		"json:target\\cucumber-reports\\CucumberTestReport.json", "rerun:target\\cucumber-reports\\rerun.txt" })
public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucmber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}

}
