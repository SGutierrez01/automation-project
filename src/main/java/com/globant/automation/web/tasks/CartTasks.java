package com.globant.automation.web.tasks;

import com.globant.automation.web.pages.CartPage;
import static com.globant.automation.web.utils.PageActions.click;
import static com.globant.automation.web.utils.enums.ElementDescriptions.CHECKOUT_BUTTON;

public class CartTasks extends CartPage {

  public void clickCheckoutButton() {
    click(getCheckoutButton(), CHECKOUT_BUTTON.getValue());
  }
}
