package mx.uaemex.msg;

import java.io.Serializable;

public class Message implements Serializable{

  public static final int LOGIN_MESSAGE = 1;
  public static final int LOGOUT_MESSAGE = 2;
  public static final int CHAT_MESSAGE = 3;
  public static final int COMM_MESSAGE = 4;
  
  public String getMsgSender() {
    return msgSender;
  }

  public String getMsgBody() {
    return msgBody;
  }

  public int getMessageType() {
    return messageType;
  }
  
  
  private int messageType;
  private String msgSender;
  private String msgBody;

  public Message(int messageType, String msgSender, String msgBody) {
    this.messageType = messageType;
    this.msgSender = msgSender;
    this.msgBody = msgBody;
  }
    
}
