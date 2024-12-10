import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AppointmentPanel extends JPanel {
    private MainApp mainApp;
    private JComboBox<String> timeList;
    private JDateChooser dateChooser; // Use JDateChooser instead of JDatePicker

    public AppointmentPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Select an appointment date:"));
        dateChooser = new JDateChooser(); // Instantiate JDateChooser
        add(dateChooser); // Add to the panel

        add(new JLabel("Select an appointment time:"));
        String[] times = {"9:00 AM", "11:00 AM", "1:00 PM", "3:00 PM"};
        timeList = new JComboBox<>(times);
        add(timeList);

        JButton confirmButton = new JButton("Confirm Appointment");
        confirmButton.addActionListener(e -> {
            // Store the appointment data and switch to PaymentPanel
            mainApp.switchPanel("Payment");
        });
        add(confirmButton);
    }
}
