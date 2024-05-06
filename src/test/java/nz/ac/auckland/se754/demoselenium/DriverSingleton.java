package nz.ac.auckland.se754.demoselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverSingleton {

    private static DriverSingleton INSTANCE;
    private WebDriver driver;

    private DriverSingleton() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--remote-allow-origins=*");
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/macos/chromedriver");
        } else if (osName.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/windows/chromedriver");
        } else if (osName.contains("linux")){
            System.setProperty("webdriver.chrome.driver", "webdrivers/linux/chromedriver");
        }else{
            throw new RuntimeException("not supported os");
        }        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static DriverSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DriverSingleton();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }

}
