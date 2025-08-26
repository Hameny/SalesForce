package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

  private final By TITLE = By.xpath("//button[@title='App Launcher']");

  public MainPage(WebDriver driver) {
    super(driver);
  }

  @Step("Open main page")
  public void open() {
    driver.get(MAIN_URL);
  }

  @Step("Main page is opend")
  public void isPageOpened() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
  }
}
