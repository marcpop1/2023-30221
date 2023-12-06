package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  /**
   * Create 2 types of exceptions: checked and unchecked (e.g. PersonNotValidException, AddressNotFoundException
   * Modify PersonValidator.valid() to throw PersonNotValidException or AddressNotValidException, AddressNotFoundException
   *
   * @param args
   */
  public static void main(String[] args) {

    Person person = new Person();
    Address address = new Address();
    person.setAddress(address);

//    if (person.getAddress() != null) {
//      System.out.println(person.getAddress().getAddressDetails().getStreetName());
//    }

    System.out.println("Hello there!");

    try {
      System.out.println(person.getAddress().getStreetName());
      readFromFile();
    } catch (NullPointerException | NumberFormatException exception) {
      System.out.println("An exception occurred");
    } catch (FileNotFoundException exception) {

    } catch (IOException exception) {
      System.out.println("IOException occured");
    }

    System.out.println("Hello there!");

    System.out.println(getNumber());
  }

  private static void readFromFile() throws IOException {
    String filePath = "path/to/your/file.txt";

    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String line;

    // Read each line from the file until the end is reached
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

  private static int getNumber() {
    try {
      throw new Exception();
//      return 1;
    } catch (Exception e) {
      System.out.println("Exception occurred");
      return 2;
    } finally {
      return 3;
    }
  }
}