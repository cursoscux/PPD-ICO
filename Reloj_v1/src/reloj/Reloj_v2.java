package reloj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renecruz
 */
public class Reloj_v2 {

  public static void main(String[] args) {
    while (true) {
      Calendar cal = Calendar.getInstance();
      Date date = cal.getTime();
      DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
      String strDate = dateFormat.format(date);
      System.out.println("Hora: " + strDate);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        //TODO something...
      }
    }
  }

}
