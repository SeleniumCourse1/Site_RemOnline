package iakov_volf;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static iakov_volf.util.PropertyLoader.loadCapabilities;
import static iakov_volf.util.PropertyLoader.loadProperty;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestNgTestBase {

  protected WebDriver driver;
  protected String gridHubUrl;
  protected String baseUrl;

  @BeforeClass
  public void init() throws IOException {
    baseUrl = loadProperty("site.url");
    gridHubUrl = loadProperty("grid2.hub");

    Capabilities capabilities;
    capabilities = loadCapabilities();

    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    if (driver != null) {
      WebDriverFactory.dismissDriver(driver);
    }
  }
}
