import java.awt.*;
import javax.swing.*;
import java.util.*;

public class MainApp extends JFrame {
    CardLayout cardLayout;
    private Map<String, JPanel> panelMap;
    JPanel mainPanel;

    public MainApp() {
        setTitle("Online Salon Service Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        panelMap = new HashMap<>();

        mainPanel.add(new SignInPanel(this), "SignIn");
        mainPanel.add(new ForgottenPasswordPanel(this), "ForgotPassword");
        mainPanel.add(new SignUpPanel(this), "SignUp");
        panelMap.put("Dashboard", new DashboardPanel(this));
        mainPanel.add(new ServicePanel(this), "Service");
        mainPanel.add(new AppointmentPanel(this), "Appointment");
        panelMap.put("YourAppointment", new YourAppointmentPanel(this));
        panelMap.put("CustomerQuery", new CustomerQueryPanel(this));
        mainPanel.add(new PaymentPanel(this), "Payment");

        add(mainPanel);
        cardLayout.show(mainPanel, "SignIn");
    }

    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp mainApp = new MainApp();
            mainApp.setVisible(true);
        });
    }
}
