package Queue;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyApplication extends JFrame {
  JTextField numberField = new JTextField(10);
  JTextField resultField = new JTextField(20);

  public static void main(String[] args) {
    MyApplication app = new MyApplication();
    app.setVisible(true);
  }

  private MyApplication() {
    super("Number doubler");
    resultField.setEditable(false);
    add(new JLabel("Number to double (n):"), BorderLayout.WEST);
    add(numberField, BorderLayout.CENTER);
    add(resultField, BorderLayout.SOUTH);
    JButton butt = new JButton("Calculate");
    butt.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String numberStr = numberField.getText();
        numberStr = numberStr.trim();
        double n = Double.parseDouble(numberStr);
        n *= 2;
        resultField.setText("n * 2 = " + String.format("%.2f", n));
      }
    });
    add(butt, BorderLayout.EAST);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
  }
}