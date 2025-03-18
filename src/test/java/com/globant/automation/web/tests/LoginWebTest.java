package com.globant.automation.web.tests;

import com.globant.automation.web.base.test.BaseWebTest;
import com.globant.automation.web.data.JsonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.globant.automation.web.pages.LoginPage;

public class LoginWebTest extends BaseWebTest {

  @Test(dataProvider = "loginData", dataProviderClass = JsonDataProvider.class)
  public void testLogin(String username, String password) {
    LoginPage loginPage = new LoginPage(getDriver());

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickLogin();

    if (username.equals("locked_out_user")) {
      Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Fail Message not displayed.");
      String error = loginPage.getErrorMessage();
      Assert.assertTrue(error.contains("locked out"), "Failing displayed 'locked out'.");
    } else {
      Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"), "Inventory not displayed.");
    }
  }
}

