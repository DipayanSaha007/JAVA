import java.awt.*;
import javax.swing.*;

public class ForgottenPasswordPanel extends JPanel {
    private MainApp mainApp;
    private JTextField emailField;

    public ForgottenPasswordPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new GridLayout(2, 1));

        add(new JLabel("Enter your email:"));
        emailField = new JTextField();
        add(emailField);

        JButton resetButton = new JButton("Reset Password");
        resetButton.addActionListener(e -> resetPassword());
        add(resetButton);
    }

    private void resetPassword() {
        String email = emailField.getText();
        // Add SQL code to check if email exists and reset the password
        JOptionPane.showMessageDialog(this, "Password has been reset!");
        mainApp.switchPanel("SignIn");
    }
}
