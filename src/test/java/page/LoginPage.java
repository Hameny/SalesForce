package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

  private final By LOGIN_FIELD = By.id("username");
  private final By PASSWORD_FIELD = By.id("password");
  private final By LOGIN_BUTTON = By.id("Login");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("Open Login page")
  public LoginPage open() {
    driver.get(BASE_URL);
    return this;
  }

  @Step("Login page is opened")
  public LoginPage isPageOpened() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
      return this;
  }

  @Step("Authorized")
  public MainPage login(String user, String password) {
    log.info("Authorization");
    driver.findElement(LOGIN_FIELD).sendKeys(user);
    driver.findElement(PASSWORD_FIELD).sendKeys(password);
    driver.findElement(LOGIN_BUTTON).click();
    return new MainPage(driver);
  }
}
