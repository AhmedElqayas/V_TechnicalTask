package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private WebDriver driver;
    private By proceedToAddressBtn = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShoppingAddressPage proceedToAddressPage() {
        driver.findElement(proceedToAddressBtn).click();

        return new ShoppingAddressPage(driver);
    }


}
