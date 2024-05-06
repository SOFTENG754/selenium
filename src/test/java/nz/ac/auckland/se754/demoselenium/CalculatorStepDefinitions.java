package nz.ac.auckland.se754.demoselenium;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.CalculatorPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorStepDefinitions {

    private WebDriver driver;
    private CalculatorPage page;
    @Before
    public void setup(){
        driver = DriverSingleton.getInstance().getDriver();
         page = new CalculatorPage(driver);
    }

   @AfterStep
    public void afterEachStep(){
        // to make the test at human speed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
       // driver.close();
    }

    @Given("I open the calculator page")
    public void i_open_the_calculator_page() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }

    @Given("I enter {int} into the calculator")
    public void i_enter_into_the_calculator(Integer int1) {
        page.enterFirstNumber(int1);
    }

    @Given("I also enter {int} into the calculator")
    public void i_also_enter_into_the_calculator(Integer int1) {
        page.enterSecondNumber(int1);

    }

    @When("I press add")
    public void i_press_add() {
        page.clickCalculate();
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
        String result = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
        //String result =  driver.findElement(By.id("numberAnswerField")).getText();
        assertEquals(String.valueOf(int1), result);
    }


}
