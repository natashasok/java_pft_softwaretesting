package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteGroupFromContactTests extends TestBase{
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
  public void testDeleteGroupFromContact(){
    Groups groups = app.db().groups();
    Groups groupHaveContact  = new Groups();
    Groups test  = new Groups();
    //Contacts before =app.db().contacts();
      for (GroupData group : groups) {
         app.contact().selectGroupInFooter(group.getId());
         if (app.contact().all().size() > 0) {
           groupHaveContact.add(group);
         }
       }
      if (groupHaveContact.size() == 0){
        app.contact().selectAllGroups();
        app.contact().selectGroup(groups.iterator().next().getId());
        app.contact().addToGroup(app.db().contacts().iterator().next());
        app.goTo().goHomeLink();
        app.contact().selectAllGroups();
        groupHaveContact.add(groups.iterator().next());
      }
    app.contact().selectGroupInFooter(groupHaveContact.iterator().next().getId());
    ContactData contactWithGroup = app.contact().all().iterator().next();
    Contacts before = app.db().contact(contactWithGroup.getId());
    //Groups before = contactWithGroup.getGroups();
    System.out.println(before);
    ContactData contact = new ContactData().withId(contactWithGroup.getId()).
            withFirstName(contactWithGroup.getFirstName()).withAddress(contactWithGroup.getAddress()).withLastName(contactWithGroup.getLastName());
    app.contact().deleteGroupFromContact(contact);
    app.goTo().goHomeLink();
    app.contact().selectAllGroups();
    //assertThat(app.contact().count(), equalTo(before.size()));
    //assertThat(contact.getGroups().size(), equalTo(before.size() - 1));
    //Contacts after =app.db().contacts();
    Groups after =contact.getGroups();
    assertThat(after, equalTo(before.without()));
    verifyContactListInUI();
  }

}
