package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PayByBankWirePage {

    private WebDriver driver;
    private By confirmOrderBtn = By.xpath("//button[@class='button btn btn-default button-medium']");

    public PayByBankWirePage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderConfirmationPage confirmOrder() {
        driver.findElement(confirmOrderBtn).click();

        return new OrderConfirmationPage(driver);
    }
}
