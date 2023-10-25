package ro.utcn;

public class Person {

  private String name;
  private Person contactPerson;

  private static Person instance;

  private Person(String name) {
    this.name = name;
  }

  public static Person getInstance() {
    if (instance == null) {
      instance = new Person("ABC");
    }
    return instance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(Person contactPerson) {
    this.contactPerson = contactPerson;
  }

  public String processName(String name) {
    // we're doing some other stuff with name before
    return removeVocals(name);
  }

  public String removeVocals(String value) {
    // remove vocals from a string
  }
}
