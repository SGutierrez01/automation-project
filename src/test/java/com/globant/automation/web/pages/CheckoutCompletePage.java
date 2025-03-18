package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

  @FindBy(className = "complete-header")
  private WebElement completeHeader;

  public CheckoutCompletePage(WebDriver driver) {
    super(driver);
  }

  public String getCompleteMessage() {
    return getText(completeHeader);
  }
}

