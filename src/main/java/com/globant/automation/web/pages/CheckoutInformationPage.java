package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutInformationPage extends BasePage {

  @FindBy(id = "first-name")
  private WebElement firstNameField;

  @FindBy(id = "last-name")
  private WebElement lastNameField;

  @FindBy(id = "postal-code")
  private WebElement postalCodeField;

  @FindBy(id = "continue")
  private WebElement continueButton;
}

