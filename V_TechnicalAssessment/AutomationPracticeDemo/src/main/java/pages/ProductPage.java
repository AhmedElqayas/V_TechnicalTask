package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private WebDriver driver;
    private By sizeDropDownMenu = By.id("group_1");
    private By whiteColor = By.xpath("//a[@title='White']");
    private By addToCartBtn = By.xpath("//button[@name='Submit']");
    private By proceedToShoppingCartBtn = By.xpath("//a[@class='btn btn-default button button-medium']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private void chooseSizeFromDropDownMenu(String size) {
        Select sizes = new Select(driver.findElement(sizeDropDownMenu));
        sizes.selectByVisibleText(size);
    }

    private void chooseColor(By color) {
        driver.findElement(color).click();
    }

    public ShoppingCartPage addProductToCart(String size, String color) {
        chooseSizeFromDropDownMenu(size);
        if(color.equalsIgnoreCase("white"))
            chooseColor(whiteColor);
        else
            System.out.println("Your color is not white");
        driver.findElement(addToCartBtn).click();
        driver.findElement(proceedToShoppingCartBtn).click();

        return new ShoppingCartPage(driver);
    }






}
