package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().createContact(new ContactData("Nataliia", "Sergeevna", "Sokolova", "natasha_sok", "ns", "N_company", "Yaroslavl", "70-80-90", "+7910-123-67-08", "99-70-54", "nsokolova_fax", "nsokolova@N_company.ru", "nsokolova2@N_company.ru", "1989", "18", "September", "test1"), true);
    app.getNavigationHelper().gotoHomePage();
    app.logout();
  }

}
