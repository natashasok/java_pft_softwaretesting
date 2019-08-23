package ru.stqa.pft.mantis.tests;

import com.google.common.collect.Streams;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase{


  @Test
  public void testChangePassword() throws IOException, MessagingException {
    String password = "password";
    String passwordNew = "passwordNew";
    String passwordAdmin = "root";
    String loginAdmin = "administrator";
    Users users = app.db().users();
    UserData user = users.iterator().next();
    System.out.println(user.getUsername());
    if (app.james().doesUserExist(user.getUsername())){
      app.james().deleteUser(user.getUsername());
    }
    app.james().createUser(user.getUsername(), password);
    app.registration().login(loginAdmin, passwordAdmin);
    app.registration().choiceUser(user.getUsername(), passwordAdmin);
    app.registration().resetPassword();
    app.james().drainEmail(user.getUsername(), password);
    List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), password, 60000);
    String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
    app.registration().finish(confirmationLink, passwordNew);
    HttpSession session = app.newSession();
    assertTrue( session.login(user.getUsername(), passwordNew));
    assertTrue(session.isLoggedInAs(user.getUsername()));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
  //  MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
   MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).collect(Collectors.toList()).get(mailMessages.size()-1);
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
