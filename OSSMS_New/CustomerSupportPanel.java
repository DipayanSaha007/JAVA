import java.awt.*;
import javax.swing.*;

public class CustomerSupportPanel extends JLabel {
    private final MainAppPanel mainapp;
    private final JLabel title;

    public CustomerSupportPanel(MainAppPanel app) {
        this.mainapp = app;
        setLayout(null);

        // title of the panel
        title = new JLabel("Customer Support Panel");
        title.setBounds(100, 5, 500, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // text area for the query
        JLabel query = new JLabel("Insert Query: ");
        query.setBounds(100, 100, 100, 50);
        add(query);
        JTextArea input = new JTextArea();
        input.setBounds(300, 100, 500, 100);
        add(input);

        // submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(300, 200, 200, 50);
        submit.addActionListener(a -> submit());
        add(submit);
    }

    private void submit() {
        JOptionPane.showMessageDialog(null, "Query Submitted!! You wiil be notified later.");
        // can add features for mail submition to the dev
        mainapp.switchPanel("DashBoard");
    }
}
