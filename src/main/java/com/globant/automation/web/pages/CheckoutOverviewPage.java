package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutOverviewPage extends BasePage {

  @FindBy(id = "finish")
  private WebElement finishButton;
}

