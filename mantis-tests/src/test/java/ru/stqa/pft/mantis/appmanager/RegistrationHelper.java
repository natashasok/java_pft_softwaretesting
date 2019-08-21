package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"), username);
    type(By.name("email"), email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.xpath("//*[@id=\"account-update-form\"]/fieldset/span/button/span"));
  }

  public void choiceUser(String user, String passwordAdmin) {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    click(By.xpath("//a[text()='"+ user +"']"));
  //  type(By.name("password"), passwordAdmin);
  //  click(By.cssSelector("input[value='Login']"));
  }

  public void login(String user, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), user);
    click(By.cssSelector("input[value='Login']"));
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }


  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }
}
