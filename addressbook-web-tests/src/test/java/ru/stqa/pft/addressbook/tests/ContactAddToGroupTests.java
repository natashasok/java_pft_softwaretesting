package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

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
    if (app.db().groups().size() == 0){
      app.group().create(new GroupData().withName("test").withFooter("footer").withHeader("header"));
      app.goTo().goHomeLink();
    }
  }

  @Test
  public void testContactAddToGroup(){
    Groups groups = app.db().groups();
    Groups groupsWithoutGroupContacts = app.db().groups();
    Contacts before =app.db().contacts();
    ContactData addContact = before.iterator().next();
   if (addContact.getGroups().size() > 0){
      Groups allGroupsContact = addContact.getGroups();
      System.out.println(allGroupsContact);
      for(GroupData group :addContact.getGroups()) {
        groupsWithoutGroupContacts.remove(group);
      }
      System.out.println(groupsWithoutGroupContacts);
      ContactData contact1 = new ContactData().withId(addContact.getId()).inGroup(groupsWithoutGroupContacts.iterator().next()).
              withFirstName(addContact.getFirstName()).withAddress(addContact.getAddress()).withLastName(addContact.getLastName());
      app.contact().addToGroup(contact1);
     app.goTo().goHomeLink();
     app.contact().selectAllGroups();
     assertThat(app.contact().count(), equalTo(before.size()));
     Contacts after =app.db().contacts();
     assertThat(after, equalTo(before.without(addContact).withAdded(contact1)));
     verifyContactListInUI();
    } else { ContactData contact = new ContactData().withId(addContact.getId()).inGroup(groups.iterator().next()).
            withFirstName(addContact.getFirstName()).withAddress(addContact.getAddress()).withLastName(addContact.getLastName());
     app.contact().addToGroup(contact);
     app.goTo().goHomeLink();
     app.contact().selectAllGroups();
     assertThat(app.contact().count(), equalTo(before.size()));
     Contacts after =app.db().contacts();
     assertThat(after, equalTo(before.without(addContact).withAdded(contact)));
     verifyContactListInUI();
   }
  }
}
