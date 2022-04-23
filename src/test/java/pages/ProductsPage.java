package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    public static final String productLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    public static final By SORT = By.cssSelector(".product_sort_container");
    public static final By DESCRIPTION = By.className("description");
    public static final By PRICE = By.className("inventory_item_price");
    public static final By TWITTER_LINK = By.className("social_twitter");
    public static final By FACEBOOK_LINK = By.className("social_facebook");
    public static final By LINKEDIN_LINK = By.className("social_linkedin");
    public static final By MENU_LINK = By.id("react-burger-menu-btn");
    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By CART_LINK = By.id("shopping_cart_container");


    public ProductsPage(WebDriver driver) {
        super(driver);

    }

    @Step("Opening products page")
    public void open() {
        driver.get(baseUrl + "/inventory.html");
    }

    @Step("Opening cart")
    public void clickCart() {
        driver.findElement(CART_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your cart']")));
    }

    @Step("Adding to cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productLocator, product))).click();
    }

    @Step("Removing from cart")
    public void removeFromCart() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    public void sort(String sorting) {
        new Select(driver.findElement(SORT)).selectByVisibleText(sorting);
    }

    public String getProductDescription(String product) {
        return driver.findElement(DESCRIPTION).getText();
    }

    @Step("Getting Twitter link")
    public String getTwitterLink() {
        return driver.findElement(TWITTER_LINK).getText();
    }

    @Step("Getting Facebook link")
    public String getFacebookLink() {
        return driver.findElement(FACEBOOK_LINK).getText();
    }

    @Step("Getting LinkedIn link")
    public String getLinkedInLink() {
        return driver.findElement(LINKEDIN_LINK).getText();
    }

    @Step("Getting menu icon")
    public void getMenu() {
        driver.findElement(MENU_LINK).click();
    }
}
