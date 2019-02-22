
package reloj_v2.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import reloj_v2.RelojRunnable;
import reloj_v2.RelojThread;

public class RelojFrame extends JFrame{

  public RelojFrame()  {
    setTitle("Reloj v4.0");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());

    JLabel lblHora = new JLabel("Hora:");
    add(lblHora);
    JTextField txtHora = new JTextField(10);
    add(txtHora);
    JButton btnIniciaReloj = new JButton("Iniciar");
    add(btnIniciaReloj);
    
    btnIniciaReloj.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        RelojRunnable rr = new RelojRunnable(txtHora);
        Thread hiloReloj = new Thread(rr);
        hiloReloj.start();
      }
    });
    
    setVisible(true);
  }
  
}
