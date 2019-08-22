package ru.stqa.pft.mantis.tests;

import com.google.common.collect.Streams;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase{


  @Test
  public void testChangePassword() throws IOException, MessagingException {
    String user = "user1566400874029";
    String password = "password";
    String passwordNew = "passwordNew";
    String email = "user1566400874029@localhost";
    String passwordAdmin = "root";
    String loginAdmin = "administrator";
    app.james().deleteUser(user);
    app.james().createUser(user, password);
    app.registration().login(loginAdmin, passwordAdmin);
    app.registration().choiceUser(user, passwordAdmin);
    app.registration().resetPassword();
    List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, passwordNew);
    HttpSession session = app.newSession();
    assertTrue( session.login(user, passwordNew));
    assertTrue(session.isLoggedInAs(user));
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
   // MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
   // MailMessage mailMessage = Streams.findLast(mailMessages.stream().filter((m) -> m.to.equals(email))).get();
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).reduce((first, second) -> second).orElse(null);
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
