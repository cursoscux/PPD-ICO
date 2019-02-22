package mx.uaemex.threads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Alarma_Thread extends Thread {

  private JTextField txtReloj;
  private boolean corriendo = true;
  private String pais;
  private String strHora;
  private String strMsg;
  private boolean hayAlarma = false;

  public Alarma_Thread(JTextField txtReloj, String pais) {
    this.txtReloj = txtReloj;
    this.pais = pais;
  }

  public void addAlarma(String strHora, String strMsg) {
    this.strHora = strHora;
    this.strMsg = strMsg;
    hayAlarma = true;
  }

  @Override
  public void run() {
    super.run();
    int horasDiferentes = 0;
    if (pais.equals("MX")) {
      horasDiferentes = 0;
    } else if (pais.equals("BR")) {
      horasDiferentes = 3;
    } else if (pais.equals("TK")) {
      horasDiferentes = 15;
    }

    while (corriendo) {

      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.HOUR, horasDiferentes);
      Date date = cal.getTime();
      DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
      String strDate = dateFormat.format(date);
      if (strDate.equals(strHora)) {
        JOptionPane.showMessageDialog(null, strMsg);
        hayAlarma = false;
      }
      System.out.println("Hora: " + strDate);
      txtReloj.setText(strDate);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        //TODO something...
      }

    }

  }

  public void stopThread() {
    corriendo = false;
    txtReloj.setText("");
  }
}
