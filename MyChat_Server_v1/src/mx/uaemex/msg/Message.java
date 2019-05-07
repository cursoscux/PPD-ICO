package mx.uaemex.msg;

import java.io.Serializable;

public class Message implements Serializable{

  /**
   * @return the idMessage
   */
  public int getIdMessage() {
    return idMessage;
  }

  /**
   * @return the msgSender
   */
  public String getMsgSender() {
    return msgSender;
  }

  /**
   * @return the msgBody
   */
  public String getMsgBody() {
    return msgBody;
  }
  private int idMessage;
  private String msgSender;
  private String msgBody;

  public Message(int idMessage, String msgSender, String msgBody) {
    this.idMessage = idMessage;
    this.msgSender = msgSender;
    this.msgBody = msgBody;
  }
    
}
