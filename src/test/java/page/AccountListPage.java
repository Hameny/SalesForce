package page;

import org.openqa.selenium.WebDriver;

public class AccountListPage extends BasePage{

  public AccountListPage(WebDriver driver) {
    super(driver);
  }

  public AccountListPage open(){
    driver.get("");
    return this;
  }

  @Override
  public BasePage isPageOpened() {
    return null;
  }
}
