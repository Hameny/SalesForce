package test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

  @Test(priority = 1,
      description = "Создание карточки компании",
      testName = "Позитивный тест.Создание карточки компании",
      groups = {"smoke"})
  @Description("Создание карточки компании")
  @Owner("PavelHameny")
  public void checkCreateAccount() throws InterruptedException {
    loginPage.open();
    loginPage.isPageOpened();
    loginPage.login("tborodich@tms.sandbox", "Password003!");
    Thread.sleep(2000);
    newAccountModal.open();
    newAccountModal.isPageOpened();
    newAccountModal.createAccount("123", "333333", "2222", "Cold", "Other",
        "Banking", "Public", "www.kleenka.by", "12-1", "unknow",
        "19", "1", "150 000 0000", "212342", "Nekrasova 12",
        "Pobediteley 10", true, false);
    newAccountModal.saveAccount();
    accountPage.checkNotification();
  }

  @Test(priority = 1,
      description = "Создание карточки компании с пустыми полями",
      testName = "Негативный тест.Создание карточки компании с пустыми полями",
      groups = {"smoke"})
  @Description("Создание карточки компании с пустыми полями")
  @Owner("PavelHameny")
  public void checkCreateAccountWithEmptyFields() throws InterruptedException {
    loginPage.open();
    loginPage.isPageOpened();
    loginPage.login("tborodich@tms.sandbox", "Password003!");
    Thread.sleep(2000);
    newAccountModal.open();
    newAccountModal.isPageOpened();
    newAccountModal.saveAccount();
    accountPage.checkNotificationWeHitASnag();
  }
}
