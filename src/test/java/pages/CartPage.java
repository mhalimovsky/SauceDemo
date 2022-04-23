package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By CART_CLICK = By.id("shopping_cart_container");
    public static final By ITEM_NAME = By.className("inventory_item_name");
    public static final By ITEM_PRICE = By.className("inventory_item_price");
    public static final By CART_ITEMS = By.className("cart_item_label");
    public static final By CHECKOUT_BUTTON = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening cart page")
    public void open() {
        driver.get(baseUrl + "/cart.html");
    }

    @Step("Getting items names")
    public String getItemsName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    @Step("Getting items prices")
    public String getItemsPrice(String product) {
        return driver.findElement(By.className("inventory_item_price")).getText();
    }

    @Step("Removal from cart")
    public void removeFromCartPage() {
        driver.findElement(By.className("btn_secondary")).click();
    }

    @Step("Complete the order")
    public void completeTheOrder() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
