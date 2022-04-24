package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {


    @Test(description = "Проверка корректности работы ссылки Twitter")
    public void twitterLinkShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.open();
        assertEquals(productsPage.getTwitterLink(), "Twitter", "NOT FOUND");

    }

    @Test(description = "Проверка корректности работы ссылки Facebook")
    public void facebookLinkShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.open();
        assertEquals(productsPage.getFacebookLink(), "Facebook", "NOT FOUND");

    }

    @Test(description = "Проверка корректности работы ссылки Linkedin")
    public void linkedInLinkShouldBeCorrect() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.open();
        assertEquals(productsPage.getLinkedInLink(), "LinkedIn", "NOT FOUND");

    }

    @Test(description = "Проверка на возможность выхода из сайта", enabled = false)
    public void logOutTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.getMenu();
        driver.findElement(By.id("logout_sidebar_link")).click();
        String loginButton = driver.findElement(By.id("login-button")).getAttribute("value");
        assertEquals(loginButton, "Login", "Неуспешный выход из сайта");
    }
}
