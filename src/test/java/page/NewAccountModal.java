package page;

import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.PickList;

public class NewAccountModal extends BasePage {

  public NewAccountModal(WebDriver driver) {
    super(driver);
  }

  public void createAccount(String name, String phone, String fax,String rating) {
    new Input(driver, "Account Name").writeText(name);
    new Input(driver, "Phone").writeText(phone);
    new Input(driver, "Fax").writeText(fax);
    new PickList(driver,"Rating").selectPickList(rating);
  }
}
