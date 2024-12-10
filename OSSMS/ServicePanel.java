import javax.swing.*;

public class ServicePanel extends JPanel {
    private MainApp mainApp;
    private DefaultListModel<String> serviceModel;
    private JList<String> serviceList;

    public ServicePanel(MainApp app) {
        this.mainApp = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Select a Service:"));

        serviceModel = new DefaultListModel<>();
        String[] services = {
            "Haircut - Rs. 400",
            "Facial - Rs. 600",
            "Manicure - Rs. 500",
            // Add other services here
        };

        for (String service : services) {
            serviceModel.addElement(service);
        }

        serviceList = new JList<>(serviceModel);
        JScrollPane scrollPane = new JScrollPane(serviceList);
        add(scrollPane);

        JButton bookButton = new JButton("Book Appointment");
        bookButton.addActionListener(e -> {
            String selectedService = serviceList.getSelectedValue();
            if (selectedService != null) {
                // Store selected service data and switch to AppointmentPanel
                mainApp.switchPanel("Appointment");
            } else {
                JOptionPane.showMessageDialog(null, "Please select a service.");
            }
        });
        add(bookButton);
    }
}
