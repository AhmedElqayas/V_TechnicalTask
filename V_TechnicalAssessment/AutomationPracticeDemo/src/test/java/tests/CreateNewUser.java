package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;


public class CreateNewUser extends BaseTest{


    private String[][] emails = ExcelTestData.collectData("Emails");
    private String[][] regData = ExcelTestData.collectData("RegistrationData");
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private String createAccountHeader = "CREATE AN ACCOUNT";
    private String myAccountHeader = "MY ACCOUNT";

    @Before
    public void initialize(){
       setUp();
    }


    @After
    public void terminate() {
        finish();
    }


    @Given("the user at the website authentication page")
    public void the_user_at_the_website_authentication_page() {
        authenticationPage = homePage.clickSignInBtn();
    }

    @When("the user enters a valid email")
    public void the_user_enters_a_valid_email() {
        createAccountPage = authenticationPage.createAccount(emails[0][0]);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(createAccountPage.createAccountPageHeader, createAccountHeader));
    }

    @Then("the user can create a new user account")
    public void the_user_can_create_a_new_user_account() {

        MyAccountPage myAccountPage = createAccountPage.register(regData[0][0], regData[0][1],
                regData[0][2], regData[0][3], regData[0][4], regData[0][5], regData[0][6],
                regData[0][7]);
        Assert.assertEquals(myAccountPage.getMyAccountPageHeader(), myAccountHeader);
        System.out.println("Your Account Created Successfully");
    }
}
