package com.globant.automation.web.utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesUtils {

  private static Properties prop;

  public void loadProperties() throws IOException {
    prop = new Properties();
    try (InputStream input = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
      if (input == null) {
        throw new IllegalArgumentException("config.properties not found in classpath.");
      }
      prop.load(input);
    }
  }

  public String getProperty(String property) {
    try {
      if (prop == null) {
        loadProperties();
      }
      String value = prop.getProperty(property);
      if (value == null) {
        throw new IllegalArgumentException("Property '" + property + "' is not defined in config.properties");
      }
      return value;
    } catch (IOException e) {
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }
}