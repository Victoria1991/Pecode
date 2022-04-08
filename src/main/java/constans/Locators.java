package constans;

public class Locators {
    private Locators() {
    }

    public interface RegistrationPage {
        String NAME_INPUT = "//input[@name='username']";
        String PASSWORD_INPUT = "//input[@name='password']";
        String BUTTON_INPUT = "//input[@value='Login']";
        String NAME_ERROR = "//div[input[@name='username']]/span";
        String PASSWORD_ERROR = "//div[input[@name='password']]/span";
    }
}
