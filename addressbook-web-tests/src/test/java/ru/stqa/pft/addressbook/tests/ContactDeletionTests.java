package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
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
  public void testContactDeletion() {
    List<ContactData> before =app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    app.goTo().goHomeLink();
    List<ContactData> after =app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
