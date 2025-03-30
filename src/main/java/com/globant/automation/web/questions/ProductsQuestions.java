package com.globant.automation.web.questions;

import com.globant.automation.web.pages.ProductsPage;
import org.testng.Assert;

public class ProductsQuestions extends ProductsPage {

  public void shouldBeRedirectedToTheInventoryPage() {
    Assert.assertEquals(getDriver().getCurrentUrl(),
        "https://www.saucedemo.com/inventory.html");
  }
}
