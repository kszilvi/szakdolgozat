package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/features",
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = "steps",
        tags = {"@current"})
public class TestRunner extends AbstractTestNGCucumberTests {

    //private TestNGCucumberRunner testNGCucumberRunner;

    /*@BeforeClass
    public void setUpClass(){
        ChromeDriverManager.getInstance().setup();
        //WebDriverManager.firefoxdriver().setup();
    }

    /*@AfterClass(alwaysRun = true)
    public void tearDownClass(){
        testNGCucumberRunner.finish();
    }*/
}
