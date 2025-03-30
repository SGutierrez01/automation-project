package com.globant.automation.core.hooks;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Objects;

public class Hooks {

  @BeforeSuite
  public void cleanAllureResultsDir() {
    File resultsDir = new File("allure-results");
    if (resultsDir.exists()) {
      for (File file : Objects.requireNonNull(resultsDir.listFiles())) {
        file.delete();
      }
    }
  }
}
