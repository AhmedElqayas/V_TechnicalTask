package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

public class OrderProduct extends BaseTest {

    private String[][] emails = ExcelTestData.collectData("Emails");
    private String[][] regData = ExcelTestData.collectData("RegistrationData");
    private String[][] productData = ExcelTestData.collectData("Product");
    private AuthenticationPage authenticationPage;
    private CreateAccountPage createAccountPage;
    private MyAccountPage myAccountPage;
    private OrderHistoryPage orderHistoryPage;
    private String createAccountHeader = "CREATE AN ACCOUNT";
    private String myAccountHeader = "MY ACCOUNT";

    @Before()
    public void initialize(){
        setUp();
    }

    @After()
    public void terminate() {
        finish();
    }

    @Given("the user enters a registration email")
    public void the_user_enters_a_registration_email() {
        authenticationPage = homePage.clickSignInBtn();
        createAccountPage = authenticationPage.createAccount(emails[0][0]);
    }

    @When("the user create an account")
    public void the_user_create_an_account() {
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.textToBe(createAccountPage.createAccountPageHeader, createAccountHeader));

        myAccountPage = createAccountPage.register(regData[0][0], regData[0][1],
                regData[0][2], regData[0][3], regData[0][4], regData[0][5], regData[0][6],
                regData[0][7]);
        Assert.assertEquals(myAccountPage.getMyAccountPageHeader(), myAccountHeader);
        System.out.println("Your Account Created Successfully");
    }

    @When("complete the purchase process")
    public void complete_the_purchase_process() {
        myAccountPage.hoverOverWomenCategory();

        WomenBlousesPage womenBlousesPage = myAccountPage.chooseBlousesSubcategory();

        ProductPage productPage = womenBlousesPage.chooseResultedProduct();

        ShoppingCartPage shoppingCartPage =productPage.addProductToCart(productData[0][0], productData[0][1]);

        ShoppingAddressPage shoppingAddressPage = shoppingCartPage.proceedToAddressPage();

        ShippingPage shippingPage = shoppingAddressPage.proceedToShippingPage();

        PaymentPage paymentPage = shippingPage.proceedToPaymentPage();

        PayByBankWirePage payByBankWirePage = paymentPage.proceedToPayByBankWirePage();

        OrderConfirmationPage orderConfirmationPage = payByBankWirePage.confirmOrder();

        orderHistoryPage = orderConfirmationPage.proceedToOrderHistoryPage();
    }

    @Then("the user can find the product in the order history")
    public void the_user_can_find_the_product_in_the_order_history() {
        orderHistoryPage.validateOrderExistence();
    }

}
