package com.globant.automation.web.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

  public static String takeScreenshot(WebDriver driver, String testName) {
    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String screenshotName = testName + "_" + timestamp + ".png";
    String screenshotPath = "test-output/screenshots/" + screenshotName;

    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destFile = new File(screenshotPath);

    try {
      FileUtils.copyFile(srcFile, destFile);
      System.out.println("✅ Screenshot saved in: " + screenshotPath);
    } catch (IOException e) {
      System.out.println("❌ Failed to save screenshot: " + e.getMessage());
    }

    return destFile.getAbsolutePath();
  }

  public static byte[] takeScreenshot(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }
}
