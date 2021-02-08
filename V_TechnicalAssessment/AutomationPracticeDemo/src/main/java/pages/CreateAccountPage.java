package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    private WebDriver driver;
    public By createAccountPageHeader = By.xpath("//h1[@class='page-heading']");
    private By maleGenderRadioBtn = By.id("id_gender1");
    private By firstNameEditText = By.id("customer_firstname");
    private By lastNameEditText = By.id("customer_lastname");
    private By registrationPasswordEditText = By.id("passwd");
    private By address1EditText = By.id("address1");
    private By cityEditText = By.id("city");
    private By stateDropDownMenu = By.id("id_state");
    private By postCodeEditText = By.id("postcode");
    private By mobileEditText = By.id("phone_mobile");
    private By registerBtn = By.id("submitAccount");


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCreateAccountPageHeader() {
        return driver.findElement(createAccountPageHeader).getText();
    }

    public MyAccountPage register(String firstName, String lastName,
                                  String password, String address,
                                  String city, String state,
                                  String postCode, String mobilePhone) {
        driver.findElement(maleGenderRadioBtn).click();
        driver.findElement(firstNameEditText).sendKeys(firstName);
        driver.findElement(lastNameEditText).sendKeys(lastName);
        driver.findElement(registrationPasswordEditText).sendKeys(password);
        driver.findElement(address1EditText).sendKeys(address);
        driver.findElement(cityEditText).sendKeys(city);
        chooseStateFromDropDownMenu(state);
        driver.findElement(postCodeEditText).sendKeys(postCode);
        driver.findElement(mobileEditText).sendKeys(mobilePhone);
        driver.findElement(registerBtn).click();
        return new MyAccountPage(driver);

    }

    public void chooseStateFromDropDownMenu(String state) {
        Select states = new Select(driver.findElement(stateDropDownMenu));
        states.selectByVisibleText(state);
    }
}
