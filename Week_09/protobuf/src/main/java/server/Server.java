package server;

import com.google.protobuf.ByteString;
import message.AddressBookProtos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(9988);
    System.out.println("Server started ... ");
    Socket socket = ss.accept();
    System.out.println("a client connected!");
    //从输入流中解析出对象
    AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.parseFrom(ByteString.readFrom(socket.getInputStream()));
    if (addressBook != null) {
      System.out.println("Server received data: \n" + addressBook.toString());
    }
  }
}
