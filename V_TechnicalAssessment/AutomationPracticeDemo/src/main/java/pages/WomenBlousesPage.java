package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenBlousesPage {

    private WebDriver driver;
    private By resultedProduct = By.xpath("//img[@title='Blouse']");

    public WomenBlousesPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage chooseResultedProduct() {
        driver.findElement(resultedProduct).click();
        return new ProductPage(driver);
    }
}
