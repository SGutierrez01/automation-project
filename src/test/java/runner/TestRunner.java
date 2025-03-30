package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.globant.automation",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    monochrome = true,
    plugin = {"pretty",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "html:reports/tests/cucumber/cucumber-pretty.html",
        "testng:reports/tests/cucumber/testng/cucumber.xml",
        "json:reports/tests/cucumber/json/cucumberTestReport.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
