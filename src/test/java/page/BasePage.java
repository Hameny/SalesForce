package page;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  final String BASE_URL = "https://tms9-dev-ed.develop.lightning.force.com/";
  final String MAIN_URL = BASE_URL + "lightning/setup/SetupOneHome/home";
  final String NEW_ACCOUNT_URL = BASE_URL + "lightning/o/Account/new";
  WebDriver driver;
  WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  }

  public void open(){
    driver.get(BASE_URL);
  }

  public void clickJs(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("argument[0].click;", element);
  }

  public void waitForPageLoaded() {
    new ExpectedCondition<Boolean>() {
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor) driver)
            .executeScript("return document.readyState")
            .toString().equals("complete");
      }
    };
  }
}
