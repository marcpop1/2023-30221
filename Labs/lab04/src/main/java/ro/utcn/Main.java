package ro.utcn;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");

//    Person person = new Person("Something");
//    System.out.println(person.getName());
//    person.setName("Bondor");
//    System.out.println(person.getName());
//    person.setName("Alex");
//    System.out.println(person.getName());

    Person person = Person.getInstance();
  }
}