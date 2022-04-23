package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By TOTAL_PRICE = By.className("summary_total_label");
    public static final By FINISH_CHECKOUT = By.id("finish");
    public static final By SUCCESSFUL_ORDER = By.className("complete-header");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");
    public static final By PRODUCT_IN_CART = By.className("cart_item");


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrderInformation(String firstName, String lastname, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys("test");
        driver.findElement(LAST_NAME_INPUT).sendKeys("test");
        driver.findElement(POSTAL_CODE_INPUT).sendKeys("222525");
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Getting total price")
    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText().split(" ")[1];

    }

    @Step("Getting product price")
    public int getProductCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }

    @Step("Finishing the order")
    public void finishOrder() {
        driver.findElement(FINISH_CHECKOUT).click();
    }

    @Step("Checking order status")
    public String checkOrderStatus() {
        return driver.findElement(SUCCESSFUL_ORDER).getText();
    }

    @Step("Going homePage")
    public void goToHomePage() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
