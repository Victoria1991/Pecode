package page;

import constans.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static constans.Endpoints.WebPageURLS.BASE_URL;
import static constans.Locators.RegistrationPage.*;
import static org.awaitility.Awaitility.await;

public class BasePage extends BaseElement{
    @FindBy(xpath = NAME_INPUT)
    WebElement nameInput;

    @FindBy(xpath = PASSWORD_INPUT)
    WebElement passwordInput;

    @FindBy(xpath = BUTTON_INPUT)
    WebElement loginButton;

    @FindBy(xpath = NAME_ERROR)
    WebElement nameErrorMassege;

    @FindBy(xpath = PASSWORD_ERROR)
    WebElement passwordErrorMessege;



    public BasePage(WebDriver driver)  {
        super(driver);
    }

    //region Action
    public BasePage fillName(String name) {

        fillField(nameInput, name);
        return this;
    }

    public BasePage fillPass(String pass) {
        fillField(passwordInput, pass);
        return this;
    }

    public BasePage clickLogInButton() {
        clickElement(loginButton);
        return this;
    }


    //endregion

    //region Verification
    public BasePage verifyNameValue(String expected) {
        String actual = nameInput.getAttribute("value");
        Assert.assertEquals(actual,expected,"Verify name input");
        return this;
    }
    public BasePage verifyPasswordValue(String expected) {
        String actual = passwordInput.getAttribute("value");
        Assert.assertEquals(actual,expected,"Verify password input");
        return this;
    }
    public BasePage verifyErrorMassagePassword(String expected) {
        String actual = passwordErrorMessege.getText();
        Assert.assertEquals(actual,expected,"Verify error massage password ");
        return this;
    }

    public BasePage verifyErrorMassageName(String expected) {
        String actual = nameErrorMassege.getText();
        Assert.assertEquals (actual,expected,"Verify error massage name ");
        return this;
    }
    public BasePage verifyURL(String expected) {
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Verify error massage name ");
        return this;
    }
        public BasePage verifyNameInputDisplayed(Boolean expected) {
            Boolean actual = nameInput.isDisplayed();
            Assert.assertEquals (actual,expected,"Verify name input is displayed ");
            return this;
    }
    public BasePage verifyPasswordInputDisplayed(Boolean expected) {
        Boolean actual = passwordInput.isDisplayed();
        Assert.assertEquals (actual,expected,"Verify password input is displayed ");
        return this;
    }

    //endregion

    public static BasePage init(WebDriver driver)  {
        return new BasePage(driver);
    }
}


