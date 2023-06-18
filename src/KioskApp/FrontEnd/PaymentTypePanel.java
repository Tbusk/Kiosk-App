package KioskApp.FrontEnd;

import com.vonage.client.VonageClient;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * A class that extends JPanel that is a UI for the payments portion of KioskApp.
 * This contains various payment options as buttons as well as a back button and a request assistance button.
 * The payment options available are: Cash, Debit, Credit, Check, EBT, and NFC.
 * This class also contains all the logic around the buttons used and the design of the payment panel.
 */
public class PaymentTypePanel extends JPanel {

    static String paymentType;

    JLabel selectPaymentTypeLabel;
    JButton paymentCashButton;
    JButton paymentDebitButton;
    JButton paymentCreditButton;
    JButton paymentCheckButton;
    JButton paymentEBTButton;
    JButton paymentNFCButton;
    JButton goBackButton;
    JButton getAssistanceButton;
    public PaymentTypePanel() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        this.setPreferredSize(new Dimension(1000,600));
        this.setBackground(new Color(43, 43, 43));

        selectPaymentTypeLabel = new JLabel("select payment type");
        selectPaymentTypeLabel.setForeground(Color.WHITE);
        selectPaymentTypeLabel.setVerticalAlignment(JLabel.TOP);
        selectPaymentTypeLabel.setHorizontalAlignment(JLabel.CENTER);
        selectPaymentTypeLabel.setFont(new Font(null, Font.PLAIN, 68));
        selectPaymentTypeLabel.setPreferredSize(new Dimension(1000,125));
        this.add(selectPaymentTypeLabel);

        paymentCashButton = new JButton("Cash");
        paymentCashButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentCashButton.setPreferredSize(new Dimension(300,125));
        paymentCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Insert Cash", "KioskApp - Pay with Cash", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "Cash";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentCashButton.setFocusable(false);
        this.add(paymentCashButton);

        paymentDebitButton = new JButton("Debit");
        paymentDebitButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentDebitButton.setPreferredSize(new Dimension(300,125));
        paymentDebitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Insert Debit Card", "KioskApp - Pay with Debit Card", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "Debit";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentDebitButton.setFocusable(false);
        this.add(paymentDebitButton);


        paymentCreditButton = new JButton("Credit");
        paymentCreditButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentCreditButton.setPreferredSize(new Dimension(300,125));
        paymentCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Insert Credit Card", "KioskApp - Pay with Credit Card", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "Credit";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentCreditButton.setFocusable(false);
        this.add(paymentCreditButton);


        paymentCheckButton = new JButton("Check");
        paymentCheckButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentCheckButton.setPreferredSize(new Dimension(300,125));
        paymentCheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Insert Check", "KioskApp - Pay with Check", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "Check";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentCheckButton.setFocusable(false);
        this.add(paymentCheckButton);

        paymentEBTButton = new JButton("EBT");
        paymentEBTButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentEBTButton.setPreferredSize(new Dimension(300,125));
        paymentEBTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Insert EBT Card", "KioskApp - Pay with EBT", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "EBT";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }

                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentEBTButton.setFocusable(false);
        this.add(paymentEBTButton);


        paymentNFCButton = new JButton("NFC");
        paymentNFCButton.setFont(new Font(null, Font.PLAIN, 45));
        paymentNFCButton.setPreferredSize(new Dimension(300,125));
        paymentNFCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Place NFC-enabled device next to reader.", "KioskApp - Pay with NFC", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        switch (JOptionPane.showConfirmDialog(getParent(),"Do you want a receipt?", "KioskApp Receipt Option", JOptionPane.YES_NO_OPTION)) {
                            case JOptionPane.YES_OPTION-> {
                                ReceiptGenerator receiptGenerator = new ReceiptGenerator();
                                try {
                                    paymentType = "NFC";
                                    receiptGenerator.receiptOutput();
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                            case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                                frame.dispose();
                            }
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        paymentNFCButton.setFocusable(false);
        this.add(paymentNFCButton);

        this.add(Box.createRigidArea(new Dimension(1000,25)));

        goBackButton = new JButton("back");
        goBackButton.setFont(new Font(null, Font.PLAIN, 35));
        goBackButton.setPreferredSize(new Dimension(250,75));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Do you want to go back?", "KioskApp - Go Back to Checkout Screen", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(getParent());
                        frame.dispose();
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });
        goBackButton.setFocusable(false);
        this.add(goBackButton);

        getAssistanceButton = new JButton("get help");
        getAssistanceButton.setFont(new Font(null, Font.PLAIN, 35));
        getAssistanceButton.setPreferredSize(new Dimension(250,75));
        getAssistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (JOptionPane.showConfirmDialog(getParent(),"Do you need assistance?", "KioskApp - Request Assistance", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.YES_OPTION-> {
                        VonageClient client = VonageClient.builder().apiKey("e625e571").apiSecret("ctTyUoBJLpir4Rd6").build();
                        TextMessage message = new TextMessage("18334391790", "12695125088","KioskApp: A customer is requesting assistance at the self-checkout.  Please give them assistance!");
                        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

                        if(response.getMessages().get(0).getStatus() == MessageStatus.OK) {
                            System.out.println("Message " + message.getMessageBody() + ", sent successfully");
                        } else {
                            System.out.println("Message sending failed.  Error: " + response.getMessages().get(0).getErrorText());
                        }
                    }
                    case JOptionPane.NO_OPTION, JOptionPane.CANCEL_OPTION -> {
                    }
                }
            }
        });

        getAssistanceButton.setFocusable(false);
        this.add(getAssistanceButton);

    }
}
