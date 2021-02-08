package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    private String url = "http://automationpractice.com/index.php";


    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension resolution = new Dimension(1024,768);
        driver.manage().window().setSize(resolution);

        homePage = new HomePage(driver);
    }

    public void finish() {
        driver.quit();
    }
}
