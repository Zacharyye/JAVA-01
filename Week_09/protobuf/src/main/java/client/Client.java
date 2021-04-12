package client;

import message.AddressBookProtos;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 9988);
    //构建对象
    AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder()
            .addPeople(AddressBookProtos.Person.newBuilder().setName("Giao").build())
            .build();
    OutputStream os = socket.getOutputStream();
    os.write(addressBook.toByteArray());
    os.flush();
    os.close();
    System.out.println("client send addressBook");

  }
}
