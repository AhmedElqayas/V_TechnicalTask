package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

public class Try extends BaseTest {

    private String[][] emails = ExcelTestData.collectData("Emails");
    private String[][] regData = ExcelTestData.collectData("RegistrationData");
    private String[][] productData = ExcelTestData.collectData("Product");


    public void createNewAccountUser() {
        AuthenticationPage authenticationPage = homePage.clickSignInBtn();

        CreateAccountPage createAccountPage = authenticationPage.createAccount(emails[0][0]);

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.textToBe(createAccountPage.createAccountPageHeader, "CREATE AN ACCOUNT"));

        //Assert.assertEquals(createAccountPage.getCreateAccountPageTitle(), "CREATE AN ACCOUNT");

        MyAccountPage myAccountPage = createAccountPage.register(regData[0][0], regData[0][1],
                regData[0][2], regData[0][3], regData[0][4], regData[0][5], regData[0][6],
                regData[0][7]);
        Assert.assertEquals(myAccountPage.getMyAccountPageHeader(), "MY ACCOUNT");

       myAccountPage.hoverOverWomenCategory();

        WomenBlousesPage womenBlousesPage = myAccountPage.chooseBlousesSubcategory();

      ProductPage productPage = womenBlousesPage.chooseResultedProduct();

        ShoppingCartPage shoppingCartPage =productPage.addProductToCart(productData[0][0], productData[0][1]);

        ShoppingAddressPage shoppingAddressPage = shoppingCartPage.proceedToAddressPage();

        ShippingPage shippingPage = shoppingAddressPage.proceedToShippingPage();

        PaymentPage paymentPage = shippingPage.proceedToPaymentPage();

        PayByBankWirePage payByBankWirePage = paymentPage.proceedToPayByBankWirePage();

        OrderConfirmationPage orderConfirmationPage = payByBankWirePage.confirmOrder();

        OrderHistoryPage orderHistoryPage = orderConfirmationPage.proceedToOrderHistoryPage();
        orderHistoryPage.validateOrderExistence();
    }
}
