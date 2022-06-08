/**
 * JFrame for game
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    // variables
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton button10;
    JButton button11;
    JButton button12;
    JButton button13;
    JButton button14;
    JButton button15;
    JButton button16;
    JButton button17;
    JButton button18;
    JButton button19;
    JButton button20;
    JButton button21;
    JButton button22;
    JButton button23;
    JButton button24;
    JButton button25;
    MyPanel bomb;
    JPanel status;
    JTextField text;
    JLabel statusText;
    JPanel buttons;
    GridLayout gL;
    int attempt;
    boolean gameOver;


    int bomb_place1;
    int bomb_place2;
    int price_place;


    public MyFrame() {
        gameOver = false;
        buttons = new JPanel();
        gL = new GridLayout(5, 5);
        buttons.setLayout(gL);
        statusText = new JLabel();
        attempt = 0;
        bomb = new MyPanel();
        bomb.setBackground(Color.WHITE);
        status = new JPanel();
        button1 = new JButton();

        // adds button actionListener
        button1.addActionListener(this);
        button1.setText("1");

        button2 = new JButton();
        button2.addActionListener(this);
        button2.setText("2");

        button3 = new JButton();
        button3.addActionListener(this);
        button3.setText("3");

        button4 = new JButton();
        button4.addActionListener(this);
        button4.setText("4");

        button5 = new JButton();
        button5.addActionListener(this);
        button5.setText("5");

        button6 = new JButton();
        button6.addActionListener(this);
        button6.setText("6");

        button7 = new JButton();
        button7.addActionListener(this);
        button7.setText("7");

        button8 = new JButton();
        button8.addActionListener(this);
        button8.setText("8");

        button9 = new JButton();
        button9.addActionListener(this);
        button9.setText("9");

        button10 = new JButton();
        button10.addActionListener(this);
        button10.setText("10");

        button11 = new JButton();
        button11.addActionListener(this);
        button11.setText("11");

        button12 = new JButton();
        button12.addActionListener(this);
        button12.setText("12");

        button13 = new JButton();
        button13.addActionListener(this);
        button13.setText("13");

        button14 = new JButton();
        button14.addActionListener(this);
        button14.setText("14");

        button15 = new JButton();
        button15.addActionListener(this);
        button15.setText("15");

        button16 = new JButton();
        button16.addActionListener(this);
        button16.setText("16");

        button17 = new JButton();
        button17.addActionListener(this);
        button17.setText("17");

        button18 = new JButton();
        button18.addActionListener(this);
        button18.setText("18");

        button19 = new JButton();
        button19.addActionListener(this);
        button19.setText("19");

        button20 = new JButton();
        button20.addActionListener(this);
        button20.setText("20");

        button21 = new JButton();
        button21.addActionListener(this);
        button21.setText("21");

        button22 = new JButton();
        button22.addActionListener(this);
        button22.setText("22");

        button23 = new JButton();
        button23.addActionListener(this);
        button23.setText("23");

        button24 = new JButton();
        button24.addActionListener(this);
        button24.setText("24");

        button25 = new JButton();
        button25.addActionListener(this);
        button25.setText("25");

        // adding Panel that includes buttons
        this.add(buttons);
        // setting Jframe
        this.setTitle("PotLuck");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // it helps to exit
        this.setSize(600 , 600);
        this.setVisible(true); // make frame visible
        // adding buttons panel to buttons
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);
        buttons.add(button17);
        buttons.add(button18);
        buttons.add(button19);
        buttons.add(button20);
        buttons.add(button21);
        buttons.add(button22);
        buttons.add(button23);
        buttons.add(button24);
        buttons.add(button25);
        // putting status panel to down
        this.add(status , BorderLayout.SOUTH);

        // determines bombs and price
        determine_places();
        // sets status
        status.add(statusText);
        statusText.setText("Please select a button!");


    }


    // Button click listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {

            if (e.getSource()== button1) {
                attempt++;
                if (bomb_place1 == 1 || bomb_place2 == 1) {
                    button1.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                if (price_place == 1) {
                   button1.setText(" \u2605");
                   button1.setFont(new Font("Default", Font.BOLD, 66));
                   button1.setForeground((Color.orange));
                   statusText.setText("You got it in " + attempt + " attempts.");
                   gameOver = true;

                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button1.setEnabled(false);
                }


            }
            if (e.getSource()== button2) {
                attempt++;
                if (bomb_place1 == 2 || bomb_place2 == 2) {
                    button2.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
               else if (price_place == 2) {
                    button2.setText(" \u2605");
                    button2.setFont(new Font("Default", Font.BOLD, 66));
                    button2.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button2.setEnabled(false);
                }


            }
            if (e.getSource()== button3) {
                attempt++;
                if (bomb_place1 == 3 || bomb_place2 == 3) {
                    button3.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
               else if (price_place == 3) {
                    button3.setText(" \u2605");
                    button3.setFont(new Font("Default", Font.BOLD, 66));
                    button3.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
               else {
                   statusText.setText("Choose another button! Your attempt: " + attempt);
                   button3.setEnabled(false);
                }
            }
            if (e.getSource()== button4) {
                attempt++;
                if (bomb_place1 == 4 || bomb_place2 == 4) {
                    button4.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
               else if (price_place == 4) {
                    button4.setText(" \u2605");
                    button4.setFont(new Font("Default", Font.BOLD, 66));
                    button4.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button4.setEnabled(false);
                }

            }
            if (e.getSource()== button5) {
                attempt++;
                if (bomb_place1 == 5 || bomb_place2 == 5) {
                    button5.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
               else if (price_place == 5) {
                    button5.setText(" \u2605");
                    button5.setFont(new Font("Default", Font.BOLD, 66));
                    button5.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button5.setEnabled(false);
                }

            }
            if (e.getSource()== button6) {
                attempt++;
                if (bomb_place1 == 6 || bomb_place2 == 6) {
                    button6.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 6) {
                    button6.setText(" \u2605");
                    button6.setFont(new Font("Default", Font.BOLD, 66));
                    button6.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button6.setEnabled(false);
                }

            }
            if (e.getSource()== button7) {
                attempt++;
                if (bomb_place1 == 7 || bomb_place2 == 7) {
                    button7.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 7) {
                    button7.setText(" \u2605");
                    button7.setFont(new Font("Default", Font.BOLD, 66));
                    button7.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button7.setEnabled(false);
                }

            }
            if (e.getSource()== button8) {
                attempt++;
                if (bomb_place1 == 8 || bomb_place2 == 8) {
                    button8.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 8) {
                    button8.setText(" \u2605");
                    button8.setFont(new Font("Default", Font.BOLD, 66));
                    button8.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button8.setEnabled(false);
                }

            }
            if (e.getSource()== button9) {
                attempt++;
                if (bomb_place1 == 9 || bomb_place2 == 9) {
                    button9.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 9) {
                    button9.setText(" \u2605");
                    button9.setFont(new Font("Default", Font.BOLD, 66));
                    button9.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button9.setEnabled(false);
                }

            }
            if (e.getSource()== button10) {
                attempt++;
                if (bomb_place1 == 10 || bomb_place2 == 10) {
                    button10.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 10) {
                    button10.setText(" \u2605");
                    button10.setFont(new Font("Default", Font.BOLD, 66));
                    button10.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button10.setEnabled(false);
                }

            }
            if (e.getSource()== button11) {
                attempt++;
                if (bomb_place1 == 11 || bomb_place2 == 11) {
                    button11.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 11) {
                    button11.setText(" \u2605");
                    button11.setFont(new Font("Default", Font.BOLD, 66));
                    button11.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button11.setEnabled(false);
                }

            }
            if (e.getSource()== button12) {
                attempt++;
                if (bomb_place1 == 12 || bomb_place2 == 12) {
                    button12.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 12) {
                    button12.setText(" \u2605");
                    button12.setFont(new Font("Default", Font.BOLD, 66));
                    button12.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button12.setEnabled(false);
                }

            }
            if (e.getSource()== button13) {
                attempt++;
                if (bomb_place1 == 13 || bomb_place2 == 13) {
                    button13.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 13) {
                    button13.setText(" \u2605");
                    button13.setFont(new Font("Default", Font.BOLD, 66));
                    button13.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button13.setEnabled(false);
                }

            }
            if (e.getSource()== button14) {
                attempt++;
                if (bomb_place1 == 14 || bomb_place2 == 14) {
                    button14.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 14) {
                    button14.setText(" \u2605");
                    button14.setFont(new Font("Default", Font.BOLD, 66));
                    button14.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button14.setEnabled(false);
                }

            }
            if (e.getSource()== button15) {
                attempt++;
                if (bomb_place1 == 15 || bomb_place2 == 15) {
                    button15.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 15) {
                    button15.setText(" \u2605");
                    button15.setFont(new Font("Default", Font.BOLD, 66));
                    button15.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button15.setEnabled(false);
                }

            }
            if (e.getSource()== button16) {
                attempt++;
                if (bomb_place1 == 16 || bomb_place2 == 16) {
                    button16.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 16) {
                    button16.setText(" \u2605");
                    button16.setFont(new Font("Default", Font.BOLD, 66));
                    button16.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button16.setEnabled(false);
                }

            }
            if (e.getSource()== button17) {
                attempt++;
                if (bomb_place1 == 17 || bomb_place2 == 17) {
                    button17.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 17) {
                    button17.setText(" \u2605");
                    button17.setFont(new Font("Default", Font.BOLD, 66));
                    button17.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button17.setEnabled(false);
                }

            }
            if (e.getSource()== button18) {
                attempt++;
                if (bomb_place1 == 18 || bomb_place2 == 18) {
                    button18.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 18) {
                    button18.setText(" \u2605");
                    button18.setFont(new Font("Default", Font.BOLD, 66));
                    button18.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button18.setEnabled(false);
                }

            }
            if (e.getSource()== button19) {
                attempt++;
                if (bomb_place1 == 19 || bomb_place2 == 19) {
                    button19.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 19) {
                    button19.setText(" \u2605");
                    button19.setFont(new Font("Default", Font.BOLD, 66));
                    button19.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button19.setEnabled(false);
                }

            }
            if (e.getSource()== button20) {
                attempt++;
                if (bomb_place1 == 20 || bomb_place2 == 20) {
                    button20.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 20) {
                    button20.setText(" \u2605");
                    button20.setFont(new Font("Default", Font.BOLD, 66));
                    button20.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button20.setEnabled(false);
                }

            }
            if (e.getSource()== button21) {
                attempt++;
                if (bomb_place1 == 21 || bomb_place2 == 21) {
                    button21.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 21) {
                    button21.setText(" \u2605");
                    button21.setFont(new Font("Default", Font.BOLD, 66));
                    button21.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button21.setEnabled(false);
                }

            }
            if (e.getSource()== button22) {
                attempt++;
                if (bomb_place1 == 22 || bomb_place2 == 22) {
                    button22.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 22) {
                    button22.setText(" \u2605");
                    button22.setFont(new Font("Default", Font.BOLD, 66));
                    button22.setForeground((Color.orange));
                    statusText.setText("You got it in " + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button22.setEnabled(false);
                }

            }
            if (e.getSource()== button23) {
                attempt++;
                if (bomb_place1 == 23 || bomb_place2 == 23) {
                    button23.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 23) {
                    button23.setText(" \u2605");
                    button23.setFont(new Font("Default", Font.BOLD, 66));
                    button23.setForeground((Color.orange));
                    statusText.setText("You got it in" + attempt + " attempts.");
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button23.setEnabled(false);
                }

            }
            if (e.getSource()== button24) {
                attempt++;
                if (bomb_place1 == 24 || bomb_place2 == 24) {
                    button24.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else if (price_place == 24) {
                    button24.setText(" \u2605");
                    button24.setFont(new Font("Default", Font.BOLD, 66));
                    button24.setForeground((Color.orange));
                    gameOver = true;
                }
                else {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button24.setEnabled(false);
                }

            }
            if (e.getSource()== button25) {
                attempt++;
                if (bomb_place1 == 25 || bomb_place2 == 25) {
                    button25.add(bomb);
                    String stat = "Sorry! You are blown up at attempt " + attempt + " !";
                    statusText.setText(stat);
                    gameOver = true;
                }
                else  if (price_place == 25) {
                    button25.setText(" \u2605");
                    button25.setFont(new Font("Default", Font.BOLD, 66));
                    button25.setForeground((Color.orange));
                    gameOver = true;
                }
                else  {
                    statusText.setText("Choose another button! Your attempt: " + attempt);
                    button25.setEnabled(false);
                }

        }    }
    }
    /**
     * __This method determines two bombs' position and one price's position (1 to 25)___
     *
     */
    public void determine_places() {
        // Since there is 25 buttons range is 1 to 25
         bomb_place1 = (int) (Math.random() * 25) + 1 ;
         bomb_place2 = (int) (Math.random() * 25) + 1 ;
         price_place = (int) (Math.random() * 25) + 1 ;
        // in case they are at same button
        while (bomb_place1 == bomb_place2) {
           bomb_place2 = (int) (Math.random() * 25) + 1 ;
        }
        while (price_place == bomb_place1 || price_place == bomb_place2) {
            price_place = (int) (Math.random() * 25) + 1 ;
        }

    }




}
