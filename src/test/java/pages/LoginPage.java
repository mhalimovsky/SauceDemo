package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By USER_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");
    public static final By SUCCESSFUL_REGISTRATION_MESSAGE = By.className("title");
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void open() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Logining in by user {user} using password {password}")
    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting error message")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Getting successful registration message")
    public String getSuccessfulRegistrationMessage() {
        return driver.findElement(SUCCESSFUL_REGISTRATION_MESSAGE).getText();
    }
}
