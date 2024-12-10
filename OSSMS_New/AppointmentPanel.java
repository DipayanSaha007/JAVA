import java.awt.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class AppointmentPanel extends JLabel {
    private final MainAppPanel mainapp;
    private final JLabel title;
    public String selectedAppointment = null;
    public String selectedTime = null;
    public String selectedDate = null;

    public AppointmentPanel(MainAppPanel app) {
        this.mainapp = app;
        setLayout(null);

        // title of the panel
        title = new JLabel("Appointment Panel");
        title.setBounds(100, 5, 200, 50);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        // lable for list of time
        JLabel lbl1 = new JLabel("Select Time");
        lbl1.setBounds(100,50,200,50);
        add(lbl1);

        // list of appointment
        String[] appointment = {"9 A.M", "11 A.M", "1 P.M", "3 P.M", "5 P.M", "7 P.M"};
        JList<String> appointmentList = new JList<>(appointment);
        JScrollPane scrollPane = new JScrollPane(appointmentList);
        scrollPane.setBounds(100, 100, 200, 300);

        // adding ListSelectionListener to the JList
        appointmentList.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()) {
                selectedTime = appointmentList.getSelectedValue();
            }
        });
        add(scrollPane);

        // lable for list of time
        JLabel lbl2 = new JLabel("Select Date");
        lbl2.setBounds(350,50,200,50);
        add(lbl2);

        // List of available appointment dates (from tomorrow onwards)
        JList<String> dateList = new JList<>(getAvailableDates());
        JScrollPane dateScrollPane = new JScrollPane(dateList);
        dateScrollPane.setBounds(350, 100, 200, 300);

        // Adding ListSelectionListener to the JList for date selection
        dateList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                selectedDate = dateList.getSelectedValue();
            }
        });
        add(dateScrollPane);


        // adding submit butten
        JButton submitservice = new JButton("Submit Appointment");
        submitservice.setBounds(100, 500, 200, 50);
        submitservice.addActionListener(a -> submit_appointment());
        add(submitservice);

        // go back button
        JButton goback = new JButton("Go Back");
        goback.setBounds(350, 500, 200, 50);
        goback.addActionListener(a -> go_back());
        add(goback);
    }

    public void submit_appointment() {
        if (selectedTime != null && selectedDate != null) {
            JOptionPane.showMessageDialog(null, "Appointment Added Successfully!");
            mainapp.switchPanel("Payment");
        }
        else {
            JOptionPane.showMessageDialog(null, "Select a Appointment First");
        }
    }
    
    // Method to get a list of dates starting from tomorrow
    private String[] getAvailableDates() {
        LocalDate today = LocalDate.now();
        ArrayList<String> availableDates = new ArrayList<>();

        // Add the next 7 days (from tomorrow)
        for (int i = 1; i <= 7; i++) {
            LocalDate futureDate = today.plusDays(i);
            availableDates.add(futureDate.toString());
        }

        // Convert list to an array and return
        return availableDates.toArray(String[]::new);
    }

    private void go_back() {
        mainapp.switchPanel("Service");
    }

    public String getAppointment() {
        selectedAppointment = selectedDate + " - " + selectedTime;
        return selectedAppointment;
    }
}