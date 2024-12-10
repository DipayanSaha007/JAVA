import java.awt.*;
import javax.swing.*;

public class GuiNew {
    JTextField fld1, fld2;
    JLabel lbl, lbl1, lbl2;
    JButton btn;

    GuiNew() {
        /* Initial setup */
		JFrame frm=new JFrame("Count Calculate"); 	// Create new frame
		frm.setSize(500, 300); 							// Set frame's initial size
		frm.setLayout( new FlowLayout() ); 				// Specify FlowLayout for Layout Manager
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminate when user closes application

		/* Create items */
		fld1 = new JTextField(5);
		fld2 = new JTextField(5);						// Create field with 5 width
		JButton btn = new JButton("Submit");			// Create push buttons
		btn.addActionListener(a -> submit());					// Set action listners for buttons
		lbl = new JLabel("               "); // Create text-based label
		
		/* Add items to content pane */
		lbl1 = new JLabel("CSE: ");
		frm.add(lbl1);
		frm.add(fld1);
		lbl2 = new JLabel("CSBS: ");
		frm.add(lbl2);
		frm.add(fld2);	
		frm.add(btn); 	
		frm.add(lbl); 	

		/* Display frame */
		frm.setVisible(true);
	}
    
    void submit() {
        int num1=0;
		int num2=0;
		boolean invalidFlag = false;
		try { num1 = Integer.parseInt(fld1.getText());
			num2 = Integer.parseInt(fld2.getText()); 
			if(num1 < 0 || num2 < 0) {invalidFlag = true;} 
		}
		catch(NumberFormatException ex) { invalidFlag = true; }

        if(invalidFlag) {			
            lbl.setText("Error: Invalid Number");
        }
        else {
            int sum = num1 + num2;
            lbl.setText("Total: " + sum);
        }
    }

    public static void main(String[] args) {
        new GuiNew();
    }
}