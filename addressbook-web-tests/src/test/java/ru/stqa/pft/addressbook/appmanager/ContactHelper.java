package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickName());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhoneHome());
    type(By.name("mobile"), contactData.getPhoneMobile());
    type(By.name("work"), contactData.getPhoneWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[20]"));
    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[43]"));
    type(By.name("byear"), contactData.getByear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPreasent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("(//img[@alt='Edit'])")).get(index).click();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id="+ id + "']")).click();
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

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
  }
  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    closeDialog();
  }

  public boolean isThereAContact() {
    return isElementPreasent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement element : elements) {
      String firstName = element.findElement(By.xpath(".//td[3]")).getText();
      String lastName = element.findElement(By.xpath(".//td[2]")).getText();
      //String adress = element.findElement(By.xpath(".//td[4]")).getText();
      int id = Integer.parseInt(element.findElement(By.xpath(".//td[1]/input[@type='checkbox']")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName);
      contacts.add(contact);
    }
    return contacts;
  }
}
