package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Проверка на корректное отображение корзины")
    public void cartLinkShouldBeWorking() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        cartPage.open();
        assertEquals(driver.findElement(By.className("title")).getText(), "YOUR CART", "Корзина не открывается");
    }

    @Test(description = "Проверка на обязательность продукта")
    public void productShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
    }

    @Test(description = "Проверка на добавление продукта в корзину")
    public void productShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.open();
        String itemInTheCart = cartPage.getItemsName();
        assertEquals(itemInTheCart, "Sauce Labs Backpack");
        String cart_quantity = driver.findElement(By.className("cart_quantity")).getText();
        assertEquals(cart_quantity, "1", "Продукт не добавлен в корзину");
    }

    @Test(description = "Проверка на удаление продукта из корзины")
    public void productShouldBeRemovedFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.removeFromCart();
        cartPage.open();
        String itemInTheCart = cartPage.getItemsName();
        assertEquals(itemInTheCart, "Sauce Labs Bike Light");
        String cart_quantity = driver.findElement(By.className("cart_quantity")).getText();
        assertEquals(cart_quantity, "1", "Ошибка удаления товара из корзины");
    }
}
