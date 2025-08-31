package steps;

import dto.Account;
import org.openqa.selenium.WebDriver;
import page.AccountListPage;
import page.AccountPage;
import page.NewAccountModal;

public class AccountStep {

  AccountListPage accountListPage;
  static NewAccountModal newAccountModal;
  AccountPage accountPage;

  public AccountStep(WebDriver driver) {
    accountListPage = new AccountListPage(driver);
    newAccountModal = new NewAccountModal(driver);
    accountPage = new AccountPage(driver);
  }

  public static void createAccount(Account account) {
    newAccountModal.open()
        .isPageOpened()
        .createAccount(account)
        .saveAccount()
        .isPageOpened();
  }
}
