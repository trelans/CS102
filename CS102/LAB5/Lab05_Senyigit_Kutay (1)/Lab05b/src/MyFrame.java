/**
 * __JFrame for converter___
 */
import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

    // Variables
    JPanel jp ;

    JLabel decimal;
    JLabel hex;
    JLabel binary;

    JTextField dec;
    JTextField he;
    JTextField bi;

    int number;


 public MyFrame () {
     // sets frames properties
     this.setTitle("Convert Numbers");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it helps to exit
     this.setSize(600 , 600);
     this.setVisible(true); // make frame visible

     jp = new JPanel();
     decimal = new JLabel("Decimal");
     hex = new JLabel("Hex");
     binary = new JLabel("Binary");

     dec =  new JTextField();
     he = new JTextField();
     bi = new JTextField();
     // adds action listener to Jtextfields
     dec.addActionListener(this::actionPerformed);
     he.addActionListener(this::actionPerformed);
     bi.addActionListener(this::actionPerformed);


     jp.setLayout(new GridLayout(3,2));
     jp.add(decimal);
     jp.add(dec);
     jp.add(hex);
     jp.add(he);
     jp.add(binary);
     jp.add(bi);

     this.add(jp);

 }

 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == dec) {
         number = Integer.parseInt(dec.getText());
         he.setText( Integer.toHexString(number));
         bi.setText(Integer.toBinaryString(number));
     }
     else if (e.getSource() == he) {
         number = Integer.parseInt( he.getText() , 16);
         dec.setText("" + number);
         bi.setText( Integer.toBinaryString(number));

     }
     else if (e.getSource() == bi) {
         number = Integer.parseInt(bi.getText(), 2);
         dec.setText("" + number);
         he.setText(Integer.toBinaryString(number));

     }

 }


}
