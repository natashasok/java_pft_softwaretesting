package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.pft.addressbook.tests.TestBase.app;

public class ContactAddToGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0){
      Groups groups = app.db().groups();
      app.contact().create(new ContactData().withFirstName("Nataliia2").withMiddleName("Sergeevna")
              .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
              .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
              .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
              .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
              .withByear("1989").withBday("18").withBmonth("September"), true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactAddToGroup(){
    Groups groups = app.db().groups();
    Contacts before =app.db().contacts();
    ContactData addContact = before.iterator().next();
    ContactData contact = new ContactData().withId(addContact.getId()).inGroup(groups.iterator().next());
    app.contact().addToGroup(contact);
    app.goTo().goHomeLink();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after =app.db().contacts();
    assertThat(after, equalTo(before.without(addContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
