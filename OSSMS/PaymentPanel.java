import javax.swing.*;

public class PaymentPanel extends JPanel {
    private MainApp mainApp;

    public PaymentPanel(MainApp app) {
        this.mainApp = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Choose a payment method:"));

        JRadioButton payNow = new JRadioButton("Pay Now");
        JRadioButton payLater = new JRadioButton("Pay Later");
        ButtonGroup paymentGroup = new ButtonGroup();
        paymentGroup.add(payNow);
        paymentGroup.add(payLater);

        add(payNow);
        add(payLater);

        JButton payButton = new JButton("Submit Payment");
        payButton.addActionListener(e -> {
            if (payNow.isSelected()) {
                JOptionPane.showMessageDialog(null, "Payment successful!");
            } else {
                JOptionPane.showMessageDialog(null, "You chose to pay later.");
            }
            mainApp.switchPanel("SignIn");
        });
        add(payButton);
    }
}
