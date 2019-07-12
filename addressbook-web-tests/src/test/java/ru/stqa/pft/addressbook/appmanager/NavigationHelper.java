package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPreasent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Group")
            && isElementPreasent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void gotoHomePage() {
    if (isElementPreasent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home page"));
  }
}
