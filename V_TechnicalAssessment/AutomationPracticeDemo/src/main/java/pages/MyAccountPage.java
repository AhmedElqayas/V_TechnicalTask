package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage {
    private WebDriver driver;
    private By myAccountPageHeader = By.xpath("//h1[@class='page-heading']");
    private By womenCategoryLinkText = By.xpath("//a[@title='Women']");
    private By blousesSubcategoryLinkText = By.xpath("//a[@title='Blouses']");


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getMyAccountPageHeader() {
        return driver.findElement(myAccountPageHeader).getText();
    }

    public void hoverOverWomenCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(womenCategoryLinkText)).perform();
    }

    public WomenBlousesPage chooseBlousesSubcategory() {
        hoverOverWomenCategory();
        driver.findElement(blousesSubcategoryLinkText).click();
        return new WomenBlousesPage(driver);
    }
}
