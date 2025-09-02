package page;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class AccountPage extends BasePage {

  private final By MESSAGE = By.cssSelector("div[data-key='success']");

  public AccountPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public BasePage open() {
    return null;
  }

  @Step("AccountPage is opened")
  public AccountPage isPageOpened() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE));
    return this;
  }

  @Step("Проверка сообщения о создании аккаунта")
  public boolean checkNotification() {
    log.info("Check Notification");
    String notification = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-key='success']")))
        .getText();
    return notification.contains("Account") && notification.contains("was created");
  }

  @Step("Проверка сообщения о незаполнении обязательных полей")
  public boolean checkNotificationWeHitASnag() {
    String notification = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//h2[@class='slds-truncate slds-text-heading_medium' and text()='We hit a snag.']"
            )))
        .getText();
    return notification.contains("We hit a snag.");
  }
}
