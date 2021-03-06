package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTextPane;
import mx.uaemex.msg.Message;
import mx.uaemex.gui.MyServerGUI;

public class MsgListener extends Thread{

  private ObjectInputStream oIS;
  private JTextPane txtCharla;
  private MyChatServer myChatServer;
  
  public MsgListener(ObjectInputStream oIS, JTextPane txtCharla, MyChatServer myChatServer) {
    this.oIS = oIS;
    this.txtCharla = txtCharla;
    this.myChatServer = myChatServer;
  }
  
  private boolean isRunning;
  
  @Override
  public void run() {
    super.run(); 
    isRunning = true;
    while (isRunning) {
      try {
        Message msg = (Message) oIS.readObject();
        MyServerGUI.append(Message.CHAT_MESSAGE, txtCharla,  msg.getMsgSender() + ": " +  msg.getMsgBody() + "\n");
        txtCharla.setCaretPosition(txtCharla.getDocument().getLength());
        myChatServer.sendMessage(msg);
      } catch (IOException ex) {        
      } catch (ClassNotFoundException ex) {        
      }
    }
  }
  
  public void stopMsgListener() {
    isRunning = false;
  }
  
}
