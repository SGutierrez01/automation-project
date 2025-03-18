package com.globant.automation.web.utils;

import io.qameta.allure.Allure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AllureUtils {

  public static void attachScreenshotToAllure(String screenshotPath) {
    try {
      FileInputStream fis = new FileInputStream(screenshotPath);
      Allure.addAttachment("Screenshot fail", fis);
    } catch (FileNotFoundException e) {
      System.out.println("❌ Not found screenshot to attach to Allure: " + e.getMessage());
    }
  }
}
