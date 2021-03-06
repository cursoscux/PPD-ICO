package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import mx.uaemex.gui.MyClientGUI;
import mx.uaemex.msg.Message;

public class MsgListener extends Thread{

  private ObjectInputStream oIS;
  private JTextPane txtCharla;

  public MsgListener(ObjectInputStream oIS, JTextPane txtCharla) {
    this.oIS = oIS;
    this.txtCharla = txtCharla;
  }
  
  private boolean isRunning;
  
  @Override
  public void run() {
    super.run(); 
    isRunning = true;
    while (isRunning) {
      try {
        Message msg = (Message) oIS.readObject();
        MyClientGUI.append(Message.CHAT_MESSAGE , txtCharla, msg.getMsgSender() + ": " +  msg.getMsgBody() + "\n");
        txtCharla.setCaretPosition(txtCharla.getDocument().getLength());
      } catch (IOException ex) {        
      } catch (ClassNotFoundException ex) {        
      }
    }
  }
  
  public void stopMsgListener() {
    isRunning = false;
  }
}
