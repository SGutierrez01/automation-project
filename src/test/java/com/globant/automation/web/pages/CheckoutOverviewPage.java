package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

  @FindBy(id = "finish")
  private WebElement finishButton;

  public CheckoutOverviewPage(WebDriver driver) {
    super(driver);
  }

  public CheckoutCompletePage clickFinish() {
    click(finishButton);
    return new CheckoutCompletePage(driver);
  }
}

