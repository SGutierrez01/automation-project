package com.globant.automation.core.base.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
  protected Properties prop;

  protected void loadProperties(String path) throws IOException {
    prop = new Properties();
    FileInputStream fis = new FileInputStream(path);
    prop.load(fis);
  }

  protected String getProperty(String key) {
    return prop.getProperty(key);
  }

  protected int getIntProperty(String key) {
    return Integer.parseInt(prop.getProperty(key));
  }
}
