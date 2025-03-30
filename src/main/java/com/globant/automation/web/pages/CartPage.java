package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class CartPage extends BasePage {

  @FindBy(id = "checkout")
  private WebElement checkoutButton;

  @FindBy(className = "inventory_item_name")
  private List<WebElement> nameList;
}

