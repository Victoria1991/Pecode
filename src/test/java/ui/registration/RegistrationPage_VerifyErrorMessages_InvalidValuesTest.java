package ui.registration;

import constans.Endpoints;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.BasePage;
import tools.LocalDriverManager;
import ui.BaseTest;
import ui.registration.data.RegistrationInvalidData;

import java.io.IOException;

import static constans.PathsToFiles.Registration.*;

public class RegistrationPage_VerifyErrorMessages_InvalidValuesTest extends BaseTest {

    private RegistrationInvalidData[] invalidData;

    private BasePage basePage;
    protected WebDriver webDriver;

    @BeforeClass
    public void setUp() throws IOException {
        invalidData = RegistrationInvalidData.getData(REGISTRATION_INVALID_DATA);
        webDriver = LocalDriverManager.getWebDriver();
        basePage = BasePage.init(webDriver);

        webDriver.get(Endpoints.WebPageURLS.BASE_URL);
    }


    @DataProvider(name = "invalidData")
    public Object[][] provide() {
        Object[][] list = new Object[invalidData.length][1];
        for (int i = 0; i < invalidData.length; i++) {
            list[i][0] = invalidData[i];
        }
        return list;
    }

    @Test(description = "111", dataProvider = "invalidData")
    public void verifyErrorMessages(RegistrationInvalidData data) {
        basePage
                .fillName(data.getName())
                .verifyNameValue(data.getName())
                .fillPass(data.getPassword())
                .verifyPasswordValue(data.getPassword())
                .clickLogInButton()
                .verifyErrorMassagePassword(data.getPasswordError())
                .verifyErrorMassageName("sdfg");

    }

    @AfterClass
    protected void tearDown() {
        uiTools.makeScreenShot((Math.random() * 10) + "test");
        webDriver.quit();
        webDriver.close();
        log.info("Quit");
    }
}
