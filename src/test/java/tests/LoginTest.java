package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Входящие данные для негативных тестов на Login")
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"standard_user", "standard_user", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(dataProvider = "Входящие данные для негативных тестов на Login")
    public void passwordShouldBeRequired(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error, "Сообщение об ошибке при логине некоректное");
    }

    @Test(description = "Проверка на успешную авторизацию")
    public void loginShouldBeSuccessful() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(loginPage.getSuccessfulRegistrationMessage(), "PRODUCTS", "Пользователь не авторизирован");
    }
}
