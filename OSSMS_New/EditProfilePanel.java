import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class EditProfilePanel extends JLabel {
    private final MainAppPanel mainapp;
    private final JLabel title;
    private final JTextField newusername;
    private final JPasswordField newpassword;
    private final JTextField newemail;

    // SQLite connection setup
    private Connection conn;

    public EditProfilePanel(MainAppPanel app) {
        this.mainapp = app;
        setLayout(null);

        // Title of the panel
        title = new JLabel("Edit Profile Panel");
        title.setBounds(100, 5, 500, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // Username field
        JLabel lbl1 = new JLabel("New Username: ");
        lbl1.setBounds(100, 100, 200, 50);
        add(lbl1);
        newusername = new JTextField(5);
        newusername.setBounds(200, 100, 200, 50);
        add(newusername);

        // Password field
        JLabel lbl2 = new JLabel("New Password: ");
        lbl2.setBounds(100, 200, 200, 50);
        add(lbl2);
        newpassword = new JPasswordField(5);
        newpassword.setBounds(200, 200, 200, 50);
        add(newpassword);

        // Email field
        JLabel lbl3 = new JLabel("New Email-id: ");
        lbl3.setBounds(100, 300, 200, 50);
        add(lbl3);
        newemail = new JTextField(5);
        newemail.setBounds(200, 300, 200, 50);
        add(newemail);

        // Submit button
        JButton submitButton = new JButton("Submit New Details");
        submitButton.setBounds(100, 400, 300, 50);
        submitButton.addActionListener(a -> submit());
        add(submitButton);

        // Go back button
        JButton goback = new JButton("Go Back");
        goback.setBounds(500, 400, 200, 50);
        goback.addActionListener(a -> go_back());
        add(goback);

        // Initialize the database connection
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\User\\OneDrive\\Desktop\\Java\\OSSMS_New\\DataBase.db");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.");
            //e.printStackTrace();
        }
    }

    private void submit() {
        String name = mainapp.getSignInPanel().getUserName();
        String pass = mainapp.getSignInPanel().getPassword();
        String newname = newusername.getText();
        String newpass = new String(newpassword.getPassword());
        String newid = newemail.getText();
        
        // SQL query to update user details
        String query = "UPDATE users SET name = ?, password = ?, email = ? WHERE name = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newname);
            pstmt.setString(2, newpass);
            pstmt.setString(3, newid);
            pstmt.setString(4, name);
            pstmt.setString(5, pass);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Profile Edited Successfully");
                mainapp.switchPanel("SignIn");
            } else {
                JOptionPane.showMessageDialog(null, "User Not Found or No Changes Made");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while updating profile: " + e.getMessage());
            //e.printStackTrace();
        }
    }

    private void go_back() {
        mainapp.switchPanel("DashBoard");
    }
}
