package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends BaseTest {

    @Test(description = "Проверка на подтверждение успешного заказа")
    public void orderCompletion() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.completeTheOrder();
        checkOutPage.fillOrderInformation("test", "test", "222525");
        checkOutPage.finishOrder();
        assertEquals(checkOutPage.checkOrderStatus(), "THANK YOU FOR YOUR ORDER", "Покупка не совершена");
    }
}
