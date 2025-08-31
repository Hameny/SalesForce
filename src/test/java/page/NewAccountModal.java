package page;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.CheckBox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

@Log4j2
public class NewAccountModal extends BasePage {

  private final By BUTTON = By.xpath("//button[@name='SaveEdit']");

  public NewAccountModal(WebDriver driver) {
    super(driver);
  }

  @Step("Create company account")
  public NewAccountModal createAccount(Account account) {
    log.info("Rating: {}", account.getRating());
    new PickList(driver, "Rating").selectPickList(account.getRating());
    log.info("Type: {}", account.getType());
    new PickList(driver, "Type").selectPickList(account.getType());
    log.info("Industry: {}", account.getIndustry());
    new PickList(driver, "Industry").selectPickList(account.getIndustry());
    log.info("Ownership: {}", account.getOwnership());
    new PickList(driver, "Ownership").selectPickList(account.getOwnership());
    log.info("Account Name: {}", account.getName());
    new Input(driver, "Account Name").writeText(account.getName());
    log.info("Phone: {}", account.getPhone());
    new Input(driver, "Phone").writeText(account.getPhone());
    log.info("Fax: {}", account.getFax());
    new Input(driver, "Fax").writeText(account.getFax());
    log.info("Website: {}", account.getWebsite());
    new Input(driver, "Website").writeText(account.getWebsite());
    log.info("Account Number: {}", account.getNumber());
    new Input(driver, "Account Number").writeText(account.getNumber());
    log.info("Account Site: {}", account.getAccountSite());
    new Input(driver, "Account Site").writeText(account.getAccountSite());
    log.info("Ticker Symbol: {}", account.getSymbol());
    new Input(driver, "Ticker Symbol").writeText(account.getSymbol());
    log.info("Employees: {}", account.getEmployees());
    new Input(driver, "Employees").writeText(account.getEmployees());
    log.info("Annual Revenue: {}", account.getRevenue());
    new Input(driver, "Annual Revenue").writeText(account.getRevenue());
    log.info("SIC Code: {}", account.getCode());
    new Input(driver, "SIC Code").writeText(account.getCode());
    log.info("Billing Street: {}", account.getTextBiling());
    new TextArea(driver, "Billing Street").writeTextArea(account.getTextBiling());
    log.info("Shipping Street: {}", account.getTextShiping());
    new TextArea(driver, "Shipping Street").writeTextArea(account.getTextShiping());
    log.info("VIP Client: {}", account.getCheckboxVip());
    new CheckBox(driver, "VIP Client").check(account.getCheckboxVip());
    log.info("TeachMeSkill: {}", account.getCheckboxSkills());
    new CheckBox(driver, "TeachMeSkills").check(account.getCheckboxSkills());
    return this;
  }

  @Step("Open page for create new account")
  public NewAccountModal open() {
    log.info("Login open page");
    driver.get(NEW_ACCOUNT_URL);
    return this;
  }

  @Step("New_account_page is opened")
  public NewAccountModal isPageOpened() {
    log.info("Paga NewAccountModal is opened");
    wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON));
    return this;
  }

  @Step("Save account")
  public NewAccountModal saveAccount() {
    log.info("Click save account");
    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
    return this;
  }
}
