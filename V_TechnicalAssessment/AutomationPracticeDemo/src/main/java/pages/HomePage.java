package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By signInBtn = By.xpath("//a[@class='login']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthenticationPage clickSignInBtn() {
        driver.findElement(signInBtn).click();
        return new AuthenticationPage(driver);
    }
}
