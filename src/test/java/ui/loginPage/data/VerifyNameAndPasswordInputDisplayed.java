package ui.loginPage.data;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BasePage;
import tools.LocalDriverManager;
import ui.BaseTest;

import java.io.IOException;

import static constans.Endpoints.WebPageURLS.BASE_URL;
import static constans.PathsToFiles.LoginContext.LOGIN_INVALID_DATA;

public class VerifyNameAndPasswordInputDisplayed extends BaseTest {

    protected WebDriver webDriver;
    private LoginInvalidData[] invalidData;
    private BasePage basePage;

    @BeforeClass
    public void setUp() throws IOException {
        invalidData = LoginInvalidData.getData(LOGIN_INVALID_DATA);
        webDriver = LocalDriverManager.getWebDriver();
        basePage = BasePage.init(webDriver);

        webDriver.get(BASE_URL);
    }


    @DataProvider(name = "invalidData")
    public Object[][] provide() {
        Object[][] list = new Object[invalidData.length][1];
        for (int i = 0; i < invalidData.length; i++) {
            list[i][0] = invalidData[i];
        }
        return list;
    }

    @Test()
    public void verifyNameAndPasswordInputDisplayed() {
        basePage
                .verifyNameInputDisplayed(true)
                .verifyPasswordInputDisplayed(true);

    }

    @AfterClass
    protected void tearDown() {
        uiTools.makeScreenShot(webDriver, (Math.random() * 10) + "test");
        webDriver.quit();
        log.info("Quit");
    }
}

