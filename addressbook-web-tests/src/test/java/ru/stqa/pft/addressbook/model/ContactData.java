package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private String phoneHome;
  private String allPhones;
  private String phoneMobile;
  private String phoneWork;
  private String fax;
  private String email;
  private String email2;
  private String byear;
  private String bday;
  private String bmonth;
  private String group;
  private String allEmail;


  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", address='" + address + '\'' +
            '}';
  }


  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withPhoneHome(String phoneHome) {
    this.phoneHome = phoneHome;
    return this;
  }

  public ContactData withPhoneMobile(String phoneMobile) {
    this.phoneMobile = phoneMobile;
    return this;
  }

  public ContactData withPhoneWork(String phoneWork) {
    this.phoneWork = phoneWork;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
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

  public String getAllEmail() {
    return allEmail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }
}
