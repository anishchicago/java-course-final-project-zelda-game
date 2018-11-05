package _05dice.P10_35;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BillFrame extends JFrame {

    private static final int FRAME_WIDTH = 410;
    private static final int FRAME_HEIGHT = 1000;

    private static double TAX_RATE = 0.1;
    private static double SUGGESTED_TIP_RATE = 0.15;

    private static Map<String, Double> menuItems;
    static {
        menuItems = new HashMap<String, Double>() {{
            put("Hash Brown", 3.00);
            put("Scrambled Eggs", 3.50);
            put("Omelet", 5.00);
            put("French Toast", 5.50);
            put("Granola", 4.50);
            put("Grits", 3.00);
            put("Chicken Nuggets", 4.50);
            put("Fries", 3.50);
            put("Cheese Sandwich", 5.50);
            put("Spaghetti", 7.00);
        }};
    }

    private static Map<String, Integer> chosenMenuItemsCount = new HashMap<>();


    public BillFrame() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void addMenuItemToOrder(String itemName) {
        int newCount;
        if (chosenMenuItemsCount.containsKey(itemName))
            newCount = chosenMenuItemsCount.get(itemName) + 1;
        else newCount = 1;
        chosenMenuItemsCount.put(itemName, newCount);
    }

    private String billSummary() {

        String billSummary = "YOUR BILL:" + '\n';
        double itemExpense;
        double runningTotal = 0;

        for (String item : chosenMenuItemsCount.keySet()) {

            double itemPrice = menuItems.get(item);
            int itemCount = chosenMenuItemsCount.get(item);

            if (itemCount > 0) {
                itemExpense = itemPrice * itemCount;
                billSummary += itemCount + " x " + item + " @ $" +
                        String.format("%.2f", itemPrice) + ": $" + String.format("%.2f", itemExpense) +'\n';
                runningTotal += itemExpense;
            }
        }

        billSummary += "__________" +'\n';
        billSummary += "TOTAL BEFORE TAX: $" + String.format("%.2f", runningTotal) +'\n';
        billSummary += "TAX @ " + String.format("%.2f%%%n",TAX_RATE * 100) + ": $" + String.format("%.2f", runningTotal * TAX_RATE) +'\n';
        billSummary += "SUGGESTED TIP @ " + String.format("%.2f%%%n",SUGGESTED_TIP_RATE * 100) + ": $" +
                String.format("%.2f", runningTotal * SUGGESTED_TIP_RATE) +'\n';
        billSummary += "TOTAL AFTER TAX: $" + String.format("%.2f", runningTotal * (1 + TAX_RATE)) + '\n';
        billSummary += "TOTAL AFTER TAX AND TIP: $" + String.format("%.2f", runningTotal * (1 + TAX_RATE + SUGGESTED_TIP_RATE)) + '\n';

        return billSummary;
    }

    private void createComponents() {

        for (String item: menuItems.keySet()) {
            chosenMenuItemsCount.put(item, 0);
        }

        JTextArea myBill = new JTextArea("",50,30);
        myBill.setEditable(false);

        class myListener implements ActionListener {

            private String buttonText;

            public myListener(String buttonText) {
                super();
                this.buttonText = buttonText;
            }

            public void actionPerformed(ActionEvent event) {
                String[] splitButtonText = buttonText.split(":");
                addMenuItemToOrder(splitButtonText[0].trim());
                myBill.setText(billSummary());
            }
        }


        JPanel panel = new JPanel();

        ArrayList<JButton> buttons = new ArrayList<>();

        int counter = 0;

        for (String item : menuItems.keySet()) {
            buttons.add(new JButton((item + ": $" + String.format("%.2f",menuItems.get(item)))));
            panel.add(buttons.get(counter));
            buttons.get(counter).addActionListener(new myListener(buttons.get(counter).getText()));
            counter ++;
        }


        JTextField writeIn1 = new JTextField("",20);
        JTextField writeInPrice1 = new JTextField("", 4);

        writeIn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuItems.put(writeIn1.getText(), Double.parseDouble(writeInPrice1.getText()));
                    myBill.setText(billSummary());
                } catch (NumberFormatException e1) {
                    writeInPrice1.setText("");
                }
            }
        });

        writeInPrice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addMenuItemToOrder(writeIn1.getText());
                    menuItems.put(writeIn1.getText(), Double.parseDouble(writeInPrice1.getText()));
                    myBill.setText(billSummary());
                    writeIn1.setEditable(false);
                    writeInPrice1.setEditable(false);
                } catch (NumberFormatException e1) {
                    writeInPrice1.setText("");
                }
            }
        });

        panel.add(new JLabel("Custom item: "));
        panel.add(writeIn1);
        panel.add(new JLabel("Price (Press Enter when done with item): "));
        panel.add(writeInPrice1);

        JTextField writeIn2 = new JTextField("",20);
        JTextField writeInPrice2 = new JTextField("", 4);

        writeIn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    menuItems.put(writeIn2.getText(), Double.parseDouble(writeInPrice2.getText()));
                    myBill.setText(billSummary());
                } catch (NumberFormatException e1) {
                    writeInPrice2.setText("");
                }
            }
        });

        writeInPrice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addMenuItemToOrder(writeIn2.getText());
                    menuItems.put(writeIn2.getText(), Double.parseDouble(writeInPrice2.getText()));
                    myBill.setText(billSummary());
                    writeIn2.setEditable(false);
                    writeInPrice2.setEditable(false);
                } catch (NumberFormatException e1) {
                    writeInPrice2.setText("");
                }
            }
        });

        panel.add(new JLabel("Custom item: "));
        panel.add(writeIn2);
        panel.add(new JLabel("Price in $ (Press Enter when done with item): "));
        panel.add(writeInPrice2);


        panel.add(myBill);


        add(panel);

    }


}
