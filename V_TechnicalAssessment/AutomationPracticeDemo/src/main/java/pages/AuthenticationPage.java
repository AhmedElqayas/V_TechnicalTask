package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage {
    private WebDriver driver;
    private By authenticationPageHeader = By.xpath("//h1[@class='page-heading']");
    private By emailEditText = By.id("email_create");
    private By createAccountBtn = By.id("SubmitCreate");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAuthenticationPageHeader() {
       return driver.findElement(authenticationPageHeader).getText();
    }

    public CreateAccountPage createAccount(String email) {
        driver.findElement(emailEditText).sendKeys(email);
        driver.findElement(createAccountBtn).click();
        return new CreateAccountPage(driver);
    }
}
