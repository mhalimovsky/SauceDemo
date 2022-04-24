package tests;

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


}
