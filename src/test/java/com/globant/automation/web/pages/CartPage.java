package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

  @FindBy(id = "checkout")
  private WebElement checkoutButton;

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public CheckoutInformationPage clickCheckout() {
    click(checkoutButton);
    return new CheckoutInformationPage(driver);
  }
}

