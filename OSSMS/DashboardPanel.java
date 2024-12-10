import java.awt.*;
import javax.swing.*;

public class DashboardPanel extends JPanel {
    private MainApp mainApp;

    public DashboardPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new GridLayout(3, 1));

        JButton newServiceButton = new JButton("New Service");
        newServiceButton.addActionListener(e -> mainApp.switchPanel("Service"));
        add(newServiceButton);

        JButton yourAppointmentButton = new JButton("Your Appointments");
        yourAppointmentButton.addActionListener(e -> mainApp.switchPanel("YourAppointment"));
        add(yourAppointmentButton);

        JButton customerQueryButton = new JButton("Customer Query");
        customerQueryButton.addActionListener(e -> mainApp.switchPanel("CustomerQuery"));
        add(customerQueryButton);
    }
}
