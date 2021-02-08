package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderHistoryPage {

    private WebDriver driver;
    private int ordersCount;
    private By ordersInTable = By.xpath("//table[@id='order-list']/tbody/tr");

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateOrderExistence() {
       List<WebElement> orders = driver.findElements(ordersInTable);
       int actualOrdersCount = orders.size();

       if((actualOrdersCount - ordersCount) == 1)
           System.out.println("Your order added successfully");
       else
           System.out.println("Your order doesn't exist");
    }


}
