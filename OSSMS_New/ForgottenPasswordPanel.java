import java.awt.*;
import java.sql.*;
import java.util.Random;
import javax.swing.*;

public class ForgottenPasswordPanel extends JPanel {
    private final MainAppPanel mainapp;
    private final JLabel title;
    private final JTextField email;
    private final JTextField code;
    private final JPasswordField newPass;
    private final JLabel lblNewPass;
    private final JButton submitpass;
    private Connection conn; // SQLite connection setup
    private int code1 = 0;

    public ForgottenPasswordPanel(MainAppPanel app) {
        this.mainapp = app;
        setLayout(null);

        // Title of the panel
        title = new JLabel("Forgotten Password Panel");
        title.setBounds(100, 5, 500, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Email field
        JLabel lbl1 = new JLabel("Email-id: ");
        lbl1.setBounds(100, 70, 200, 50);
        add(lbl1);
        email = new JTextField(5);
        email.setBounds(200, 70, 200, 50);
        add(email);

        // Send code button
        JButton sendcode = new JButton("Send Code");
        sendcode.setBounds(100, 140, 200, 50);
        sendcode.addActionListener(a -> send_code());
        add(sendcode);

        // Enter code field
        JLabel lbl2 = new JLabel("Code: ");
        lbl2.setBounds(100, 210, 200, 50);
        add(lbl2);
        code = new JTextField(5);
        code.setBounds(200, 210, 200, 50);
        add(code);

        // Submit code button
        JButton submitcode = new JButton("Submit Code");
        submitcode.setBounds(100, 280, 200, 50);
        submitcode.addActionListener(a -> submit_code());
        add(submitcode);

        // New password label (initially invisible)
        lblNewPass = new JLabel("New Password: ");
        lblNewPass.setBounds(100, 350, 200, 50);
        lblNewPass.setVisible(false);
        add(lblNewPass);

        // New password field (initially invisible)
        newPass = new JPasswordField(10);
        newPass.setBounds(200, 350, 200, 50);
        newPass.setVisible(false);
        add(newPass);

        // Submit password button
        submitpass = new JButton("Submit Password");
        submitpass.setBounds(100, 420, 200, 50);
        submitpass.setVisible(false);
        submitpass.addActionListener(a -> submit_pass());
        add(submitpass);

        // Go back button
        JButton goback = new JButton("Go Back");
        goback.setBounds(100, 490, 200, 50);
        goback.addActionListener(a -> go_back());
        add(goback);

        // Initialize the database connection
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\OneDrive\\Desktop\\Java\\OSSMS_New\\DataBase.db");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            // e.printStackTrace();
        }
    }

    private void submit_code() {
        String c = code.getText();
        int i;
        try {
            i = Integer.parseInt(c);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid numeric code");
            return;
        }

        if (i == code1) {
            JOptionPane.showMessageDialog(null, "Code verified! Enter your new password.");
            // Make the new password label, field, and button visible
            lblNewPass.setVisible(true);
            newPass.setVisible(true);
            submitpass.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect code. Please try again.");
        }
    }

    private void send_code() {
        String mail = email.getText();
        boolean userFound = false;
        Random rand = new Random();
        code1 = rand.nextInt(1000, 9999);

        // SQL query to check if the user exists
        String query = "SELECT email FROM users WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userFound = true;
                JOptionPane.showMessageDialog(null, "The code is " + code1);
                // Code sent to the user's email can be added here
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(null, "Email Not Found");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
    }

    private void submit_pass() {
        String pass = new String(newPass.getPassword());
        String userEmail = email.getText();

        // SQL query to update the password
        String query = "UPDATE users SET password = ? WHERE email = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, pass);
            pstmt.setString(2, userEmail);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Password updated successfully!");
                mainapp.switchPanel("SignIn");
            } else {
                JOptionPane.showMessageDialog(null, "User not found. Please try again.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
        }
    }

    private void go_back() {
        mainapp.switchPanel("SignIn");
    }
}
