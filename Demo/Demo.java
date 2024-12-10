import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo {
    JTextField txt;
    JLabel lbl, lbl1;
    JButton btn;
    Demo() {
        JFrame frm = new JFrame("Digit Sum...");
        frm.setSize(800, 600);
        frm.setLayout( new FlowLayout() );
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl = new JLabel("Number = ");
        frm.add(lbl);
        txt = new JTextField(5);
        frm.add(txt);
        lbl1 = new JLabel("");
        frm.add(lbl1);
        btn = new JButton("Submit");
        // btn.addActionListener(this);
        btn.addActionListener(a -> submit());
        frm.add(btn);

        frm.setVisible(true);
    }

    void submit() {
        int num = 0;
        int size = 0;
        int sum = 0;
        boolean flag = false;
        try {
            num = Integer.parseInt(txt.getText());
            size = txt.getText().length();
        } catch (NumberFormatException e) {
            flag = true;
        }
        for(int i=0; i<size; i++) {
            sum += (num % 10);
            num = (num / 10);
        }
        if(!flag) {
            lbl1.setText("Sum of digits = " + sum);
        } else {
            lbl1.setText("Input an Integer");
        }
    }

    // @Override
    // public void actionPerformed(ActionEvent ae) {
    //     int num = 0;
    //     int size = 0;
    //     int sum = 0;
    //     boolean flag = false;
    //     try {
    //         num = Integer.parseInt(txt.getText());
    //         size = txt.getText().length();
    //     } catch (NumberFormatException e) {
    //         flag = true;
    //     }
    //     if(ae.getActionCommand().equals("Submit")) {
    //         for(int i=0; i<size; i++) {
    //             sum += (num % 10);
    //             num = (num / 10);
    //         }
    //         if(!flag) {
    //             lbl1.setText("Sum of digits = " + sum);
    //         } else {
    //             lbl1.setText("Input an Integer");
    //         }
    //     }
    // }

    public static void main(String[] args) {
        new Demo();
    }
}