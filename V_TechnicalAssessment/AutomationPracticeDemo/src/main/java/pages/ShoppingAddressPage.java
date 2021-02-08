package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingAddressPage {

    private WebDriver driver;
    private By proceedToShippingBtn = By.xpath("//button[@class='button btn btn-default button-medium']");

    public ShoppingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage proceedToShippingPage() {
        driver.findElement(proceedToShippingBtn).click();

        return new ShippingPage(driver);
    }
}
