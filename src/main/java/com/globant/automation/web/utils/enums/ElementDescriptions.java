package com.globant.automation.web.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ElementDescriptions {
  USERNAME_INPUT("Username input"),
  PASSWORD_INPUT("Password input"),
  LOGIN_BUTTON("Login button"),
  ADD_TO_CART_BUTTON("Add to cart button"),
  CHECKOUT_BUTTON("Checkout button"),
  FIRST_NAME_INPUT("First name input"),
  LASTNAME_INPUT("Last name input"),
  POSTAL_CODE_INPUT("Postal code input"),
  CONTINUE_BUTTON("Continue button"),
  FINISH_BUTTON("Finish button");

  private final String value;
}
