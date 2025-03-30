package com.globant.automation.core.data;

import org.testng.annotations.DataProvider;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonDataProvider {

  @DataProvider(name = "loginData")
  public Object[][] getUsersData() throws Exception {
    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("src/test/resources/test_data/users.json");
    Object obj = jsonParser.parse(reader);
    JSONArray userList = (JSONArray) obj;

    Object[][] data = new Object[userList.size()][2];
    for (int i = 0; i < userList.size(); i++) {
      JSONObject user = (JSONObject) userList.get(i);
      data[i][0] = user.get("username");
      data[i][1] = user.get("password");
    }
    return data;
  }

  @DataProvider(name = "clientsData")
  public Object[][] getClientsData() throws Exception {
    JSONParser jsonParser = new JSONParser();
    FileReader reader = new FileReader("src/test/resources/test_data/clients.json");
    Object obj = jsonParser.parse(reader);
    JSONArray clients = (JSONArray) obj;

    Object[][] userData = getUsersData();

    Object[][] data = new Object[clients.size()][5];
    for (int i = 0; i < clients.size(); i++) {
      JSONObject client = (JSONObject) clients.get(i);
      data[i][0] = userData[0][0];
      data[i][1] = userData[0][1];
      data[i][2] = client.get("firstName");
      data[i][3] = client.get("lastName");
      data[i][4] = client.get("postalCode");
    }
    return data;
  }
}

