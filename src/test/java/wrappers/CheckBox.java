package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

  WebDriver driver;
  String span;

  public CheckBox(WebDriver driver, String span) {
    this.driver = driver;
    this.span = span;
  }

  public void check(Boolean shouldCheck) {
    WebElement checkbox = driver.findElement(By.xpath(String.format
        ("//lightning-primitive-input-checkbox[.//span[normalize-space(text())='%s']]//input[@type='checkbox']", span)));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
  }
}
