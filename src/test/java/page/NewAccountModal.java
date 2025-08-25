package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.CheckBox;
import wrappers.Input;
import wrappers.PickList;
import wrappers.TextArea;

public class NewAccountModal extends BasePage {

  private final By BUTTON = By.xpath("//button[@name='SaveEdit']");

  public NewAccountModal(WebDriver driver) {
    super(driver);
  }

  @Step("Create company account")
  public void createAccount(String name, String phone, String fax, String rating, String type,
      String industry, String ownership, String webSite, String accountNumber, String accountSite,
      String tickerSymbol, String employees, String annualRevenue, String sicCode,
      String BillingStreet, String ShippingStreet,Boolean vipClient, Boolean TechMeSkills) {
    new Input(driver, "Account Name").writeText(name);
    new Input(driver, "Phone").writeText(phone);
    new Input(driver, "Fax").writeText(fax);
    new PickList(driver, "Rating").selectPickList(rating);
    new PickList(driver, "Type").selectPickList(type);
    new PickList(driver, "Industry").selectPickList(industry);
    new PickList(driver, "Ownership").selectPickList(ownership);
    new Input(driver, "Website").writeText(webSite);
    new Input(driver, "Account Number").writeText(accountNumber);
    new Input(driver, "Account Site").writeText(accountSite);
    new Input(driver, "Ticker Symbol").writeText(tickerSymbol);
    new Input(driver, "Employees").writeText(employees);
    new Input(driver, "Annual Revenue").writeText(annualRevenue);
    new Input(driver, "SIC Code").writeText(sicCode);
    new TextArea(driver, "Billing Street").writeTextArea(BillingStreet);
    new TextArea(driver, "Shipping Street").writeTextArea(ShippingStreet);
    new CheckBox(driver, "VIP Client").check(vipClient);
    new CheckBox(driver, "TeachMeSkills").check(TechMeSkills);
  }

  @Step("Open page for create new account")
  public void open() {
    driver.get(NEW_ACCOUNT_URL);
  }

  @Step("New_account_page is opened")
  public void isPageOpened() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON));
  }

  @Step("Save account")
  public void saveAccount() {
    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
  }
}
