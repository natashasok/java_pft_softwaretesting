package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification(){

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Nataliia", "Sergeevna", "Sokolova", "natasha_sok", "ns", "N_company", "Yaroslavl", "70-80-90", "+7910-123-67-08", "99-70-54", "nsokolova_fax", "nsokolova@N_company.ru", "nsokolova2@N_company.ru", "1989", "18", "September", "test1"), true);
    }
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before =app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Nataliia", "Sergeevna", "Sokolova", "natasha_sok", "ns", "N_company", "Yaroslavl", "70-80-90", "+7910-123-67-08", "99-70-54", "nsokolova_fax", "nsokolova@N_company.ru", "nsokolova2@N_company.ru", "1989", "18", "September", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after =app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    app.logout();
  }
}
