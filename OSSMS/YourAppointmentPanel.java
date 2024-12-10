import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class YourAppointmentPanel extends JPanel {
    private MainApp mainApp;
    private JList<String> appointmentList;

    public YourAppointmentPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new BorderLayout());

        add(new JLabel("Your Appointments:"), BorderLayout.NORTH);

        ArrayList<String> appointments = fetchAppointmentsFromDatabase("user_id"); // Replace with actual user ID
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String appointment : appointments) {
            listModel.addElement(appointment);
        }

        appointmentList = new JList<>(listModel);
        add(new JScrollPane(appointmentList), BorderLayout.CENTER);

        JButton cancelButton = new JButton("Cancel Appointment");
        cancelButton.addActionListener(e -> {
            String selectedAppointment = appointmentList.getSelectedValue();
            if (selectedAppointment != null) {
                // Code to cancel the appointment in the database
                JOptionPane.showMessageDialog(this, "Appointment canceled.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select an appointment to cancel.");
            }
        });
        add(cancelButton, BorderLayout.SOUTH);
    }

    private ArrayList<String> fetchAppointmentsFromDatabase(String userId) {
        ArrayList<String> appointments = new ArrayList<>();
        // SQL code to fetch appointments from the database
        return appointments;
    }
}
