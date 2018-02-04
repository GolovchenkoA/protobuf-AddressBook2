package ua.artem.golovchenko;// See README.txt for information and build instructions.

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

class ListPeople {
  // Iterates though all people in the AddressBook and prints info about them.
  static void Print(AddressBook addressBook) {
    for (Person person: addressBook.getPeopleList()) {

        System.out.println("To String method: \n");
        System.out.println(person.toString());
        System.out.println("-------------\n");


        try {
            System.out.println("To JSON \n");
            System.out.println(com.google.protobuf.util.JsonFormat.printer().print(person));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println("-------------\n");


      System.out.println("Person ID: " + person.getId());
      System.out.println("  Name: " + person.getName());
      if (!person.getEmail().isEmpty()) {
        System.out.println("  E-mail address: " + person.getEmail());
      }

      for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
        switch (phoneNumber.getType()) {
          case MOBILE:
            System.out.print("  Mobile phone #: ");
            break;
          case HOME:
            System.out.print("  Home phone #: ");
            break;
          case WORK:
            System.out.print("  Work phone #: ");
            break;
          default:
            System.out.println(" Unknown phone #: ");
            break;
        }
        System.out.println(phoneNumber.getNumber());
      }

    }
  }

  // Main function:  Reads the entire address book from a file and prints all
  //   the information inside.
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.err.println("Usage:  ua.artem.golovchenko.ListPeople ADDRESS_BOOK_FILE");
      System.exit(-1);
    }

    // Read the existing address book.
    AddressBook addressBook =
      AddressBook.parseFrom(new FileInputStream(args[0]));

    Print(addressBook);
  }
}
