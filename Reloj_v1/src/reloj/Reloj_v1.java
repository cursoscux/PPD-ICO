
package reloj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reloj_v1 {

  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    String strDate = dateFormat.format(date);
    System.out.println("Hora: " + strDate);
  }
  
}
