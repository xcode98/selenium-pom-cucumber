package runner;



import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.BasePage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(  
    features = "src/test/resources/features",
    glue = "steps",
    tags = "@Test",
    //plugin = {"pretty", "html:target/cucumber-reports"},
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)


public class Runner{
    @AfterClass
    public static void cleanDriver(){ 
        BasePage.closeBrowser();
    }
}
