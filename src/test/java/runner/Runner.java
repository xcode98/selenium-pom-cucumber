package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(  
    features = "src/test/resources/features",
    glue = "steps",
    tags = "@Test",
    //plugin = {"pretty", "html:target/cucumber-reports"},
    // plugin = {"summary","pretty","html:target/cucumber-reports",
    //           "json:target/cucumber-reports",
    //           "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)


public class Runner{   
        
}
