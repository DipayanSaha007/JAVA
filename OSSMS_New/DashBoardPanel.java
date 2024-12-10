import java.awt.*;
import javax.swing.*;

public class DashBoardPanel extends JPanel{
    private final MainAppPanel mainapp;
    private final JLabel title;
    

    public DashBoardPanel(MainAppPanel app) {
        this.mainapp = app;
        setLayout(null);

        // title of the panel
        title = new JLabel("DashBoard Panel");
        title.setBounds(100, 5, 500, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);
        
        // new service button
        JButton newservice = new JButton("New Service");
        newservice.setBounds(100, 70, 200, 50);
        newservice.addActionListener(a -> new_service());
        add(newservice);

        // your appointment
        JButton yourappointment = new JButton("Your Appointment");
        yourappointment.setBounds(100, 140, 200, 50);
        yourappointment.addActionListener(a -> your_appointment());
        add(yourappointment);

        // customer support
        JButton support = new JButton("Customer Support");
        support.setBounds(100, 210, 200, 50);
        support.addActionListener(a -> customer_support());
        add(support);

        // sign out
        JButton editProfile = new JButton("Edit Profile");
        editProfile.setBounds(100, 280, 200, 50);
        editProfile.addActionListener(a -> edit_profile());
        add(editProfile);

        // sign out
        JButton signout = new JButton("Sign Out");
        signout.setBounds(100, 350, 200, 50);
        signout.addActionListener(a -> sign_out());
        add(signout);
    }

    private void new_service() {
        mainapp.switchPanel("Service");
    }

    private void your_appointment() {
        mainapp.switchPanel("YourAppointment");
    }

    private void customer_support() {
        mainapp.switchPanel("CustomerSupport");
    }

    private void edit_profile() {
        mainapp.switchPanel("EditProfile");
    }

    private void sign_out() {
        mainapp.switchPanel("SignIn");
    }
}
