package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getFirstName());
    type(By.name("middlename"),contactData.getMiddleName());
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("nickname"),contactData.getNickName());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getPhoneHome());
    type(By.name("mobile"),contactData.getPhoneMobile());
    type(By.name("work"),contactData.getPhoneWork());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[20]"));
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[43]"));
    type(By.name("byear"),contactData.getByear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPreasent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void closeDialog() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPreasent(By.name("selected[]"));
  }
}
