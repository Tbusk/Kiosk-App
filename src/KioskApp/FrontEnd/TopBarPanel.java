package KioskApp.FrontEnd;

import KioskApp.Inventory.Item;
import KioskApp.Inventory.ImportItems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import com.vonage.client.*;
import com.vonage.client.sms.MessageStatus;
import com.vonage.client.sms.SmsSubmissionResponse;
import com.vonage.client.sms.messages.TextMessage;

/**
 * A class that extends JPanel that is a UI for the search bar and request assistance button that is located below the logo on the cart page.
 */
public class TopBarPanel extends JPanel{
    protected JLabel searchBarLabel;
    protected static JTextField searchBarField = new JTextField("");
    protected JButton requestAssistanceButton;
    protected String regexText = "[w.']";
    protected Pattern pattern;
    protected Matcher matcher;
    protected ImportItems importItems = new ImportItems();
    protected ArrayList<Item> itemList;
    public TopBarPanel() throws IOException {

        itemList = importItems.importItems();

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(new Color(43, 43, 43));
        this.setPreferredSize(new Dimension(1000, 80));

        searchBarLabel = new JLabel("search");
        searchBarLabel.setFont(new Font(null, Font.PLAIN, 32));
        searchBarLabel.setForeground(Color.WHITE);

        searchBarField.setPreferredSize(new Dimension(775, 50));
        searchBarField.setFont(new Font(null, Font.PLAIN, 32));
        searchBarField.setMargin(new Insets(0,15, 0, 0));
        searchBarField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getClickCount() >= 2) {
                    SearchedItemsPanel.itemsSearched.clear();
                    regexText = searchBarField.getText();

                    try {
                        pattern = Pattern.compile(regexText, Pattern.CASE_INSENSITIVE);
                        matcher = pattern.matcher(searchBarField.getText() + "^\\s");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }

                    if (regexText.length() >= 2) {
                        for (Item item : itemList) {
                            matcher = pattern.matcher(item.toString());
                            while (matcher.find()) {
                                System.out.printf("Match: %s, in item %s \n", matcher.group(), item.getItemName());
                                SearchedItemsPanel.itemsSearched.add(item);
                            }
                        }
                        try {

                            MainFrame mainFrame = new MainFrame();
                            mainFrame.setLocationRelativeTo(getParent());
                            SearchedItemsPanel searchedItemsPanel = new SearchedItemsPanel();
                            mainFrame.setPreferredSize(null);
                            mainFrame.add(searchedItemsPanel);
                            mainFrame.setResizable(false);
                            mainFrame.pack();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (regexText.length() == 0) {
                        for (Item item : itemList) {
                            SearchedItemsPanel.itemsSearched.add(item);
                        }
                        try {

                            MainFrame mainFrame = new MainFrame();
                            mainFrame.setLocationRelativeTo(getParent());
                            SearchedItemsPanel searchedItemsPanel = new SearchedItemsPanel();
                            mainFrame.add(searchedItemsPanel);
                            mainFrame.setPreferredSize(null);
                            mainFrame.setResizable(false);
                            mainFrame.pack();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    searchBarField.transferFocus();
                }


            }
        });

        requestAssistanceButton = new JButton("request assistance");
        requestAssistanceButton.setPreferredSize(new Dimension(350, 75));
        requestAssistanceButton.setFont(new Font(null, Font.PLAIN, 30));
        requestAssistanceButton.setFocusable(false);
        requestAssistanceButton.addActionListener(new ActionListener() {
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

        this.add(searchBarLabel);
        this.add(Box.createRigidArea(new Dimension(15,0)));
        this.add(searchBarField);
        this.add(Box.createRigidArea(new Dimension(40,0)));
        this.add(requestAssistanceButton);

    }




}
