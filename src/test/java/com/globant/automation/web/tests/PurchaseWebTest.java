package com.globant.automation.web.tests;

import com.globant.automation.web.base.test.BaseWebTest;
import com.globant.automation.web.data.JsonDataProvider;
import com.globant.automation.web.pages.CartPage;
import com.globant.automation.web.pages.CheckoutCompletePage;
import com.globant.automation.web.pages.CheckoutInformationPage;
import com.globant.automation.web.pages.CheckoutOverviewPage;
import com.globant.automation.web.pages.LoginPage;
import com.globant.automation.web.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseWebTest extends BaseWebTest {

  @Test(dataProvider = "clientsData", dataProviderClass = JsonDataProvider.class)
  public void testPurchaseCheapestProduct(
      String username,
      String password,
      String firstName,
      String lastName,
      String postalCode
  ) {

    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.enterUsername(username);
    loginPage.enterPassword(password);

    ProductsPage productsPage = loginPage.clickLogin();;
    productsPage.addCheapestProductToCart();

    CartPage cartPage = productsPage.goToCart();


    CheckoutInformationPage infoPage = cartPage.clickCheckout();
    infoPage.fillCheckoutInfo(firstName, lastName, postalCode);

    CheckoutOverviewPage overviewPage = infoPage.clickContinue();

    CheckoutCompletePage completePage = overviewPage.clickFinish();
    String message = completePage.getCompleteMessage();

    Assert.assertEquals(message, "Thank you for your order!", "Message does not match.");
  }
}

