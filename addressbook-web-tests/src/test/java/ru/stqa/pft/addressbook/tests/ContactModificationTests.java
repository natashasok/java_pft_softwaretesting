package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      Groups groups = app.db().groups();
      app.contact().create(new ContactData().withFirstName("Nataliia2").withMiddleName("Sergeevna")
              .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
              .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
              .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
              .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
              .withByear("1989").withBday("18").withBmonth("September").inGroup(groups.iterator().next()), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification(){
    Groups groups = app.db().groups();
    Contacts before =app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Nataliia2").withMiddleName("Sergeevna")
            .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
            .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
            .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
            .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru").withEmail3("1").withBday("18").withBmonth("September").withByear("1989").inGroup(groups.iterator().next());
    app.contact().modify(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after =app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
