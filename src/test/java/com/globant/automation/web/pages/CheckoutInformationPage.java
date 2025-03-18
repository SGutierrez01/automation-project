package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

  @FindBy(id = "first-name")
  private WebElement firstNameField;

  @FindBy(id = "last-name")
  private WebElement lastNameField;

  @FindBy(id = "postal-code")
  private WebElement postalCodeField;

  @FindBy(id = "continue")
  private WebElement continueButton;

  public CheckoutInformationPage(WebDriver driver) {
    super(driver);
  }

  public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
    type(firstNameField, firstName);
    type(lastNameField, lastName);
    type(postalCodeField, postalCode);
  }

  public CheckoutOverviewPage clickContinue() {
    click(continueButton);
    return new CheckoutOverviewPage(driver);
  }
}

