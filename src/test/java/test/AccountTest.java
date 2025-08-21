package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

  @Test
  public void checkCreateAccount() throws InterruptedException {
    driver.get("https://tms9-dev-ed.develop.my.salesforce.com/");
    driver.findElement(By.id("username")).sendKeys("tborodich@tms.sandbox");
    driver.findElement(By.id("password")).sendKeys("Password003!");
    driver.findElement(By.id("Login")).click();
    Thread.sleep(2000);
    driver.get("https://tms9-dev-ed.develop.lightning.force.com/lightning/o/Account/new");
    Thread.sleep(2000);
    newAccountModal.createAccount("123","333333","2222","Cold");
    driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
  }
}
