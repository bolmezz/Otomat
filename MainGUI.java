package com.company;

import javax.swing.*;
import java.awt.*;

public interface MainGUI {

    //mainframe
    JFrame mainFrame = new JFrame("OTOMAT");
    //buttons
    JButton cokeButton = new JButton("Kola ----- 15 TL");
    JButton fantaButton = new JButton("Fanta ----- 20 TL");
    JButton sodaButton = new JButton("Gazoz ----- 30 TL");
    JButton enterButton = new JButton("GİRİŞ");
    JButton cancelButton = new JButton("VAZGEÇ");
    //fields
    JTextField moneyField = new JTextField(4);
    JTextField balanceField = new JTextField(4);
    JTextArea deliveryField = new JTextArea(" ");
    JTextField messageField = new JTextField(" ");

    static double getBalance(double money) {
        double balance = Double.parseDouble(balanceField.getText());
        balance += money;
        return balance;
    }

    static void createFrame() {

        mainFrame.setLocation(300, 100);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(3, 1);
        layout.setHgap(10);
        layout.setVgap(10);

        /*pricePanel includes fields that provides users to add money and cancel the process*/
        JPanel pricePanel = new JPanel(new BorderLayout());
        pricePanel.setBackground(Color.LIGHT_GRAY);
        mainFrame.add(pricePanel, BorderLayout.CENTER);

        /*priceEnter panel includes the text area that user can enter the amount of money they want to add*/
        /*buttonsPanel includes the buttons which are enterButton and cancelButton*/
        JPanel priceEnter = new JPanel(new FlowLayout());
        priceEnter.setBackground(Color.LIGHT_GRAY);
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JPanel infoPanel = new JPanel();
        pricePanel.add(priceEnter, BorderLayout.NORTH);
        pricePanel.add(buttonsPanel, BorderLayout.CENTER);
        pricePanel.add(infoPanel, BorderLayout.SOUTH);

        JLabel priceLabel = new JLabel("Para Girişi");
        priceLabel.setBackground(Color.DARK_GRAY);
        priceLabel.setForeground(Color.WHITE);
        JLabel unit1 = new JLabel("TL");
        unit1.setBackground(Color.DARK_GRAY);
        unit1.setForeground(Color.WHITE);
        enterButton.setBackground(Color.GREEN);
        cancelButton.setBackground(Color.RED);
        JTextArea infoField = new JTextArea(" Sadece\n-> 50 Kurus (0.5 TL),\n-> 1 TL,\n-> 5 TL,\n-> 10 TL\ngirişi yapabilirsiniz",7,20);
        infoField.setEditable(false);
        infoField.setBackground(Color.DARK_GRAY);
        infoField.setForeground(Color.WHITE);
        priceEnter.add(priceLabel);
        priceEnter.add(moneyField);
        priceEnter.add(unit1);
        buttonsPanel.add(enterButton);
        buttonsPanel.add(cancelButton);
        infoPanel.add(infoField);

        /*balancePanel includes field that shows the balance of the user*/
        JPanel balancePanel = new JPanel(new FlowLayout());
        balancePanel.setBackground(Color.GRAY);
        mainFrame.add(balancePanel, BorderLayout.EAST);

        JLabel balanceLabel = new JLabel("Bakiyeniz");
        balanceLabel.setBackground(Color.GRAY);
        balanceLabel.setForeground(Color.WHITE);
        balanceField.setText("0");
        balanceField.setBackground(Color.WHITE);
        balanceField.setForeground(Color.BLACK);
        balanceField.setEditable(false);
        JLabel unit2 = new JLabel("TL");
        unit2.setBackground(Color.gray);
        unit2.setForeground(Color.white);
        balancePanel.add(balanceLabel);
        balancePanel.add(balanceField);
        balancePanel.add(unit2);

        /*goodsPanel includes the items of the vending machine*/
        JPanel goodsPanel = new JPanel(layout);
        goodsPanel.setBackground(Color.GRAY);
        mainFrame.add(goodsPanel, BorderLayout.WEST);

        goodsPanel.add(cokeButton);
        goodsPanel.add(fantaButton);
        goodsPanel.add(sodaButton);

        /*deliveryPanel includes two fields these are
        information text area (messageField) and
        a text area that shows the user which item did they buy (deliveryField)*/
        JPanel deliveryPanel = new JPanel(new GridLayout(3, 1));
        deliveryPanel.setBackground(Color.BLACK);
        mainFrame.add(deliveryPanel, BorderLayout.SOUTH);

        deliveryField.setBackground(Color.BLACK);
        deliveryField.setForeground(Color.WHITE);
        deliveryField.setEditable(false);
        messageField.setBackground(Color.DARK_GRAY);
        messageField.setForeground(Color.WHITE);
        messageField.setEditable(false);
        JTextField delEmptyField1 = new JTextField();
        delEmptyField1.setEditable(false);
        delEmptyField1.setBackground(Color.BLACK);
        deliveryPanel.add(messageField);
        deliveryPanel.add(deliveryField);
        deliveryPanel.add(delEmptyField1);

        mainFrame.setVisible(true);
    }
}
