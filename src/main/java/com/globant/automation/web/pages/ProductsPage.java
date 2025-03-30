package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProductsPage extends BasePage {

  @FindBy(className = "inventory_item")
  private List<WebElement> productList;

  @FindBy(className = "inventory_item_name")
  private List<WebElement> nameList;

  @FindBy(className = "inventory_item_price")
  private List<WebElement> priceList;

  @FindBy(className = "btn_inventory")
  private List<WebElement> addToCartButtons;

  @FindBy(className = "shopping_cart_link")
  private WebElement cartIcon;
}
