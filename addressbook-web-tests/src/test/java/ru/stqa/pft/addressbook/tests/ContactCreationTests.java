package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

   /*@DataProvider
  public Iterator<Object[]> validContact() {
    File photo = new File("src/test/resources/stru.png");
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstName("Nataliia2").withMiddleName("Sergeevna")
        .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
        .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
        .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
        .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
        .withByear("1989").withBday("18").withBmonth("September").withGroup("test1")});
    list.add(new Object[] {new ContactData().withFirstName("Nataliia3").withMiddleName("Sergeevna3")
        .withLastName("Sokolova").withNickName("natasha_sok").withTitle("ns")
        .withCompany("N_company").withAddress("Yaroslavl").withPhoneHome("70-80-90")
        .withPhoneMobile("+7910-123-67-08").withPhoneWork("99-70-54").withFax("nsokolova_fax")
        .withEmail("nsokolova@N_company.ru").withEmail2("nsokolova2@N_company.ru")
        .withByear("1989").withBday("18").withBmonth("September").withGroup("test1").withPhoto(photo)});
    return list.iterator();
  }*/

 @DataProvider
  public Iterator<Object[]> validContact() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validContact")
  public void testContactCreation(ContactData contact) {
    Groups groups = app.db().groups();
    Contacts before =app.db().contacts();
    app.contact().initContactCreation();
    app.contact().create( contact, true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after =app.db().contacts();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
    verifyContactListInUI();
  }

  @Test (enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
