package com.globant.automation.web.pages;

import com.globant.automation.web.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

  @FindBy(className = "inventory_item")
  private List<WebElement> productList;

  @FindBy(className = "inventory_item_price")
  private List<WebElement> priceList;

  @FindBy(className = "btn_inventory")
  private List<WebElement> addToCartButtons;

  @FindBy(className = "shopping_cart_link")
  private WebElement cartIcon;

  public ProductsPage(WebDriver driver) {
    super(driver);
  }

  public void addCheapestProductToCart() {
    double cheapestPrice = Double.MAX_VALUE;
    int cheapestIndex = -1;

    for (int i = 0; i < priceList.size(); i++) {
      String priceText = priceList.get(i).getText().replace("$", "");
      double price = Double.parseDouble(priceText);

      if (price < cheapestPrice) {
        cheapestPrice = price;
        cheapestIndex = i;
      }
    }

    if (cheapestIndex != -1) {
      click(addToCartButtons.get(cheapestIndex));
    } else {
      throw new RuntimeException("❌ Not found any product to add to cart");
    }
  }

  public CartPage goToCart() {
    click(cartIcon);
    return new CartPage(driver);
  }
}
