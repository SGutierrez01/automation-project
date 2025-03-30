package com.globant.automation.web.questions;

import com.globant.automation.web.pages.CartPage;
import org.testng.Assert;

import static com.globant.automation.core.utils.TestContextManager.getTestContext;
import static com.globant.automation.web.utils.enums.Keys.ITEM_NAME;

public class CartQuestions extends CartPage {

  public void shouldSeeTheCheapestProduct() {
    String cheapestProduct = getTestContext().get(ITEM_NAME.name());
    Assert.assertEquals(getNameList().get(0).getText(), cheapestProduct, "Cheapest product not found.");
  }
}
