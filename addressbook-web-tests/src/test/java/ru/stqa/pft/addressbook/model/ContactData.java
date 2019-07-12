package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String phoneHome;
  private final String phoneMobile;
  private final String phoneWork;
  private final String fax;
  private final String email;
  private final String email2;
  private final String byear;
  private final String bday;
  private final String bmonth;
  private String group;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address, String phoneHome, String phoneMobile, String phoneWork, String fax, String email, String email2, String byear, String bday, String bmonth, String group) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.phoneHome = phoneHome;
    this.phoneMobile = phoneMobile;
    this.phoneWork = phoneWork;
    this.fax = fax;
    this.email = email;
    this.email2 = email2;
    this.byear = byear;
    this.bday = bday;
    this.bmonth = bmonth;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneHome() {
    return phoneHome;
  }

  public String getPhoneMobile() {
    return phoneMobile;
  }

  public String getPhoneWork() {
    return phoneWork;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getByear() {
    return byear;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getGroup(){
    return group;
  }
}
