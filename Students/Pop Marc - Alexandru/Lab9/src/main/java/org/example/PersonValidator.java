package org.example;

public class PersonValidator {

  public void validate(Person person) throws PersonNotValidException {
    if (person == null) {
      throw new PersonNotValidException();
    }

    if (person.getName() == null) {
      throw new PersonNotValidException();
    }

    if (person.getAddress() == null) {
      
    }
  }
}
