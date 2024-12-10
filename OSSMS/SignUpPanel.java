import java.awt.*;
import javax.swing.*;

public class SignUpPanel extends JPanel {
    private MainApp mainApp;
    private JTextField emailField;
    private JPasswordField passwordField;

    public SignUpPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(e -> signUp());
        add(signUpButton);
    }

    private void signUp() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Add SQL code to insert user into the database
        JOptionPane.showMessageDialog(this, "Sign Up Successful!");
        mainApp.switchPanel("SignIn");
    }
}
