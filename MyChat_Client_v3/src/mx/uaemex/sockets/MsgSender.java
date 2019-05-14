package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import mx.uaemex.msg.Message;

public class MsgSender {
  private ObjectOutputStream oOS;

  public MsgSender(ObjectOutputStream oOS) {
    this.oOS = oOS;
  }
  
  public void sendMessage(Message msg) {
    try {
      oOS.writeObject(msg);
    } catch (IOException ex) {
    }
  }
}
