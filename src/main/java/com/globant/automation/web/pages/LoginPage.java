package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPage extends BasePage {

  @FindBy(id = "user-name")
  private WebElement userField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "h3[data-test='error']")
  private WebElement errorMessage;
}
