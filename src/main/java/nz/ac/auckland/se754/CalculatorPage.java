package nz.ac.auckland.se754;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public CalculatorPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "number1Field")
    private WebElement txtFirstNumber;

    @FindBy(how = How.NAME, using = "number2")
    private WebElement txtSecondNumber;

    @FindBy(how = How.XPATH, using = "//input[@id='calculateButton']")
    private WebElement btnCalculate;

    @FindBy(how = How.ID, using = "numberAnswerField")
    private WebElement txtAnswer;




    public void enterFirstNumber(int firstNumber) {
        txtFirstNumber.sendKeys(String.valueOf(firstNumber));
    }

    public void enterSecondNumber(int secondNumber) {
        txtSecondNumber.sendKeys(String.valueOf(secondNumber));
    }

    public void clickCalculate() {
        btnCalculate.click();
    }

    public int getAnswer() {
        String answerValue = txtAnswer.getAttribute("value");
        return Integer.parseInt(answerValue);
    }


}

