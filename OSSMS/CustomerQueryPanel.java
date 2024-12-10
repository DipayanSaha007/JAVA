import java.awt.*;
import javax.swing.*;

public class CustomerQueryPanel extends JPanel {
    private MainApp mainApp;
    private JTextArea queryTextArea;

    public CustomerQueryPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new BorderLayout());

        queryTextArea = new JTextArea(10, 30);
        add(new JScrollPane(queryTextArea), BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit Query");
        submitButton.addActionListener(e -> submitQuery());
        add(submitButton, BorderLayout.SOUTH);
    }

    private void submitQuery() {
        String query = queryTextArea.getText().trim();
        if (!query.isEmpty()) {
            // Send the query to the developers via email or store it in the database
            JOptionPane.showMessageDialog(this, "Your query has been submitted to the developers.");
            queryTextArea.setText(""); // Clear the text area
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a query before submitting.");
        }
    }
}
