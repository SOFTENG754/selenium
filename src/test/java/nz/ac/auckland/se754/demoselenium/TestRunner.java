package nz.ac.auckland.se754.demoselenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue={"nz.ac.auckland.se754.demoselenium"},
        plugin={"pretty", "html:target/cucumber-reports.html"})
public class TestRunner {
    @AfterClass
    public static void close(){
        DriverSingleton.getInstance().getDriver().close();
    }


}

