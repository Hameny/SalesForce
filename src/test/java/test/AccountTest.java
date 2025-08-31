package test;

import com.github.javafaker.Faker;
import dto.Account;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.AccountStep;
import steps.LoginStep;

public class AccountTest extends BaseTest {

  @Test(priority = 1,
      description = "Создание карточки компании",
      testName = "Позитивный тест.Создание карточки компании",
      groups = {"smoke"})
  @Description("Создание карточки компании")
  @Owner("PavelHameny")
  public void checkCreateAccount() {
    Faker faker = new Faker();
    Account account1 = Account.builder()
        .name(faker.name().name())
        .phone(faker.phoneNumber().phoneNumber())
        .textBiling(faker.address().streetAddress())
        .rating("Cold")
        .fax(faker.phoneNumber().phoneNumber())
        .accountSite(faker.internet().emailAddress())
        .code(faker.number().digit())
        .checkboxVip(true)
        .checkboxSkills(true)
        .build();
    loginStep.auth("tborodich@tms.sandbox", "Password003!");
    accountStep.createAccount(account1);
    Assert.assertTrue(accountPage.checkNotification(), "Account was created");
  }

//  @Test(priority = 1,
//      description = "Создание карточки компании с пустыми полями",
//      testName = "Негативный тест.Создание карточки компании с пустыми полями",
//      groups = {"smoke"})
//  @Description("Создание карточки компании с пустыми полями")
//  @Owner("PavelHameny")
//  public void checkCreateAccountWithEmptyFields() {
//    Account account2 = Account.builder().build();
//    loginStep.auth("tborodich@tms.sandbox", "Password003!");
//    accountStep.createAccount(account2);
//    Assert.assertTrue(accountPage.checkNotificationWeHitASnag(), "We hit a snag.");
//  }
}
