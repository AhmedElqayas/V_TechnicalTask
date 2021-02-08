package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {

    private WebDriver driver;
    private By payByBankWireLinkText = By.xpath("//a[@title='Pay by bank wire']");


    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public PayByBankWirePage proceedToPayByBankWirePage() {
        driver.findElement(payByBankWireLinkText).click();

        return new PayByBankWirePage(driver);
    }
}
