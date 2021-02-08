package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    private WebDriver driver;
    private By termsOfServiceCheckBox = By.id("uniform-cgv");
    private By proceedToPaymentPageBtn = By.xpath("//button[@name='processCarrier']");

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public PaymentPage proceedToPaymentPage() {
        driver.findElement(termsOfServiceCheckBox).click();
        driver.findElement(proceedToPaymentPageBtn).click();

        return new PaymentPage(driver);
    }

}
