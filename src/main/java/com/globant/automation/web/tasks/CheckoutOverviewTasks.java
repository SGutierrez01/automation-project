package com.globant.automation.web.tasks;

import com.globant.automation.web.pages.CheckoutOverviewPage;
import static com.globant.automation.web.utils.PageActions.click;
import static com.globant.automation.web.utils.enums.ElementDescriptions.FINISH_BUTTON;

public class CheckoutOverviewTasks extends CheckoutOverviewPage {

  public void finishPurchase() {
    click(getFinishButton(), FINISH_BUTTON.getValue());
  }
}
