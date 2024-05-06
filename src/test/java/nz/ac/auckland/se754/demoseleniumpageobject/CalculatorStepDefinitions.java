package nz.ac.auckland.se754.demoseleniumpageobject;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.ac.auckland.se754.CalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorStepDefinitions {

    private WebDriver driver;
    private CalculatorPage calculatorPage;

    @Before
    public void setup() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        } else if (osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/windows/chromedriver");
        } else if (osName.contains("linux")){
            System.setProperty("webdriver.chrome.driver", "webdrivers/linux/chromedriver");
        }else{
            throw new RuntimeException("not supported os");
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        calculatorPage = new CalculatorPage(driver);
    }


    @AfterStep
    public void afterEachStep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
       driver.close();
    }

    @Given("I open the calculator page")
    public void i_open_the_calculator_page() {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
    }


    @Given("I enter {int} into the calculator")
    public void i_enter_into_the_calculator(Integer int1) {
        calculatorPage.enterFirstNumber(int1);
    }

    @Given("I also enter {int} into the calculator")
    public void i_also_enter_into_the_calculator(Integer int1) {
       calculatorPage.enterSecondNumber(int1);
    }

    @When("I press add")
    public void i_press_add() {
        calculatorPage.clickCalculate();
    }

    @Then("the result should be {int}")
    public void the_result_should_be(Integer int1) {
       int result = calculatorPage.getAnswer();
       assertEquals(int1,result);
    }



}
