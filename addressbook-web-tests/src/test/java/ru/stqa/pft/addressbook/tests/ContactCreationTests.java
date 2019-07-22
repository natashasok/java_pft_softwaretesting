package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test (enabled = false)
  public void testContactCreation() {
    List<ContactData> before =app.contact().list();
    ContactData contact = new ContactData().withFirstName("Nataliia2").withMiddleName("Sergeevna")
            .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
            .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
            .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
            .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
            .withByear("1989").withBday("18").withBmonth("September").withGroup("test1");
    app.contact().initContactCreation();
    app.contact().create( contact, true);
    app.goTo().homePage();
    List<ContactData> after =app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (с1, с2) -> Integer.compare(с1.getId(), с2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
