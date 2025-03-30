package com.globant.automation.web.tasks;

import com.globant.automation.web.pages.CheckoutInformationPage;

import static com.globant.automation.web.utils.PageActions.sendKeys;
import static com.globant.automation.web.utils.PageActions.click;
import static com.globant.automation.web.utils.enums.ElementDescriptions.CONTINUE_BUTTON;
import static com.globant.automation.web.utils.enums.ElementDescriptions.FIRST_NAME_INPUT;
import static com.globant.automation.web.utils.enums.ElementDescriptions.LASTNAME_INPUT;
import static com.globant.automation.web.utils.enums.ElementDescriptions.POSTAL_CODE_INPUT;

public class CheckoutInformationTasks extends CheckoutInformationPage {

  public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
    sendKeys(getFirstNameField(), firstName, FIRST_NAME_INPUT.getValue());
    sendKeys(getLastNameField(), lastName, LASTNAME_INPUT.getValue());
    sendKeys(getPostalCodeField(), postalCode, POSTAL_CODE_INPUT.getValue());
  }

  public void continueToOverview() {
    click(getContinueButton(), CONTINUE_BUTTON.getValue());
  }
}
