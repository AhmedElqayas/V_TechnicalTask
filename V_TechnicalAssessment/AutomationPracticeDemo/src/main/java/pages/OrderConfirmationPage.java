package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private WebDriver driver;
    private By orderHistoryBtn = By.xpath("//a[@class='button-exclusive btn btn-default']");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderHistoryPage proceedToOrderHistoryPage() {
        driver.findElement(orderHistoryBtn).click();

        return new OrderHistoryPage(driver);
    }
}
