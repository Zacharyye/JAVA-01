import message.AddressBookProtos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ListPeople {
  static void pring (AddressBookProtos.AddressBook addressBook) {
    for (AddressBookProtos.Person person : addressBook.getPeopleList()) {
      System.out.println("Person ID: " + person.getId());
      System.out.println("  Name: " + person.getName());
      if (!person.getPhonesList().isEmpty()) {
        System.out.println("  E-mail address: " + person.getEmail());
      }

      for (AddressBookProtos.Person.PhoneNumber phoneNumber : person.getPhonesList()) {
        switch (phoneNumber.getType()) {
          case MOBILE:
            System.out.println("  Mobile phone #: ");
            break;
          case HOME:
            System.out.println("  Home phone #: ");
            break;
          case WORK:
            System.out.println("  Work phone #: ");
            break;
        }
        System.out.print(phoneNumber.getNumber());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("Usage:  ListPeople ADDRESS_BOOK_FILE");
      System.exit(-1);
    }

    AddressBookProtos.AddressBook addressBook =
            AddressBookProtos.AddressBook.parseFrom(new FileInputStream(args[0]));
    pring(addressBook);
  }
}
