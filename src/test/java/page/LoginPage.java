package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

  private final By LOGIN_FIELD = By.id("username");
  private final By PASSWORD_FIELD = By.id("password");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Step("Open Login page")
  public void open() {
    driver.get(BASE_URL);
  }

  @Step("Login page is opened")
  public void isPageOpened() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
  }

  @Step("Authorized")
  public void login(String user, String password) {
    driver.findElement(LOGIN_FIELD).sendKeys(user);
    driver.findElement(PASSWORD_FIELD).sendKeys(password);
    driver.findElement(By.id("Login")).click();
  }
}
