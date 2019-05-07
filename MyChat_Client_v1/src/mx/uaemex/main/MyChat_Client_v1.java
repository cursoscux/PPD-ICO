package mx.uaemex.main;

import mx.uaemex.sockets.MyChatClient;

public class MyChat_Client_v1 {

  public static void main(String[] args) {
    MyChatClient client = new MyChatClient("Cliente A");
    client.start();
  }
  
}
