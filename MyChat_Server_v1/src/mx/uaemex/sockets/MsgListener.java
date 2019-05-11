package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import mx.uaemex.msg.Message;

<<<<<<< HEAD
public class MsgListener extends Thread {

    private ObjectInputStream oIS;
    private JTextArea txtCharla;
    private boolean isRunning;
    private Message incomingMsg;

    public MsgListener(ObjectInputStream oIS, JTextArea txtCharla) {
        this.oIS = oIS;
        this.txtCharla = txtCharla;
    }

    @Override
    public void run() {
        super.run();
        isRunning = true;
        while (isRunning) {
            try {
                incomingMsg = (Message) oIS.readObject();
                txtCharla.append(incomingMsg.getMsgBody() + "\n");
                txtCharla.setCaretPosition(txtCharla.getDocument().getLength());
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
            }
        }
    }

    public void stopMsgListener() {
        isRunning = false;
    }
=======
public class MsgListener extends Thread{

  private ObjectInputStream oIS;
  private JTextArea txtCharla;

  public MsgListener(ObjectInputStream oIS, JTextArea txtCharla) {
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
        txtCharla.append(msg.getMsgBody() + "\n");
        txtCharla.setCaretPosition(txtCharla.getDocument().getLength());
      } catch (IOException ex) {        
      } catch (ClassNotFoundException ex) {        
      }
    }
  }
  
  public void stopMsgListener() {
    isRunning = false;
  }
>>>>>>> 59ea8d660763356c58a85f735da9f901e3c8b268
}
