package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstName("Nataliia2").withMiddleName("Sergeevna")
              .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
              .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
              .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
              .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
              .withByear("1989").withBday("18").withBmonth("September").withGroup("test1"), true);
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactModification(){
    Set<ContactData> before =app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Nataliia2").withMiddleName("Sergeevna")
            .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
            .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
            .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
            .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
            .withByear("1989").withBday("18").withBmonth("September");
    app.contact().modify(contact);
    app.goTo().homePage();
    Set<ContactData> after =app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}
