package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0){
      app.contact().create(new ContactData("Nataliia", "Sergeevna", "Sokolova",
              "natasha_sok", "ns", "N_company", "Yaroslavl", "70-80-90",
              "+7910-123-67-08", "99-70-54", "nsokolova_fax", "nsokolova@N_company.ru",
              "nsokolova2@N_company.ru", "1989", "18", "September", "test1"), true);
    }
    app.goTo().homePage();
  }

  @Test (enabled = false)
  public void testContactModification(){
    List<ContactData> before =app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"Nataliia", "Sergeevna",
            "Sokolova", "natasha_sok", "ns", "N_company", "Yaroslavl",
            "70-80-90", "+7910-123-67-08", "99-70-54", "nsokolova_fax", "nsokolova@N_company.ru",
            "nsokolova2@N_company.ru", "1989", "18", "September", null);
    app.contact().modify(index, contact);
    app.goTo().homePage();
    List<ContactData> after =app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (с1, с2) -> Integer.compare(с1.getId(), с2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
