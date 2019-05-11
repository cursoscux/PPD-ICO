package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import mx.uaemex.msg.Message;

public class MsgSender {
<<<<<<< HEAD
    private ObjectOutputStream oOS;

    public MsgSender(ObjectOutputStream oOS) {
        this.oOS = oOS;
    }
    
    public void sendMessage(Message msg) {
        try {
            oOS.writeObject(msg);
        } catch (IOException ex) {}
    }
=======
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
>>>>>>> 59ea8d660763356c58a85f735da9f901e3c8b268
}
