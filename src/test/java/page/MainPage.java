package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class MainPage extends BasePage {

  private final By TITLE = By.xpath("//button[@title='App Launcher']");

  public MainPage(WebDriver driver) {
    super(driver);
  }

  @Step("Open main page")
  public MainPage open() {
    log.info("Login open page");
    driver.get(MAIN_URL);
    return this;
  }

  @Step("Main page is opend")
  public MainPage isPageOpened() {
    log.info("MainPage is open");
    wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    return this;
  }
}
