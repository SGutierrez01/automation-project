package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  @FindBy(id = "user-name")
  private WebElement userField;

  @FindBy(id = "password")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "h3[data-test='error']")
  private WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void enterUsername(String username) {
    type(userField, username);
  }

  public void enterPassword(String password) {
    type(passwordField, password);
  }

  public ProductsPage clickLogin() {
    click(loginButton);
    return new ProductsPage(driver);
  }

  public String getErrorMessage() {
    return getText(errorMessage);
  }

  public boolean isErrorMessageDisplayed() {
    return isDisplayed(errorMessage);
  }
}
