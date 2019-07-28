package ru.stqa.pft.addressbook.generators;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter( names = "-c", description = "Group count")
  public int count;

  @Parameter ( names = "-f", description = "Target file")
  public String file;


  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts,  new File (file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
          contact.getMiddleName(), contact.getAddress(), contact.getEmail(), contact.getGroup(),
          contact.getByear(), contact.getBday(),contact.getBmonth()));
    }
    writer.close();
  }


  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++){
      contacts.add(new ContactData().withFirstName(String.format("firstName %s", i))
          .withLastName(String.format("lastName %s", i)).withMiddleName(String.format("middleName %s", i))
          .withAddress(String.format("address %s", i)).withEmail(String.format("email %s", i)).withGroup("test1").withByear("1989").withBday("18").withBmonth("September"));
    }
    return contacts;
  }
}
