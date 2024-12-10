import java.awt.*;
import javax.swing.*;

public class SignInPanel extends JPanel {
    private MainApp mainApp;
    private JTextField emailField;
    private JPasswordField passwordField;

    public SignInPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(e -> signIn());
        add(signInButton);
    }

    private void signIn() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Add SQL code to validate user credentials
        // if valid, switch to Dashboard
        mainApp.switchPanel("Dashboard");
    }
}
