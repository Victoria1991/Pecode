package tools

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class LocalDriverManager {

    protected WebDriver driver;

    public static WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver chromeWebDriver = new ChromeDriver();
        chromeWebDriver.manage().window().maximize();
        return chromeWebDriver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
