package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionsClass implements MainGUI {

    static void buttonActions() throws InterruptedException {

        /*cokeButton's color changes when the mouse on it*/
        cokeButton.addMouseListener(new MouseAdapter() {
            Color colorB = cokeButton.getBackground();
            Color colorF = cokeButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
            public void mouseEntered(MouseEvent e) {
                cokeButton.setBackground(Color.red);
                cokeButton.setForeground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                cokeButton.setBackground(colorB);
                cokeButton.setForeground(colorF);
            }
        });

        /*fantaButton's color changes when the mouse on it*/
        fantaButton.addMouseListener(new MouseAdapter() {
            Color colorB = fantaButton.getBackground();
            Color colorF = fantaButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
            public void mouseEntered(MouseEvent e) {
                fantaButton.setBackground(Color.ORANGE);
                fantaButton.setForeground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                fantaButton.setBackground(colorB);
                fantaButton.setForeground(colorF);
            }
        });

        /*sodaButton's color changes when the mouse on it*/
        sodaButton.addMouseListener(new MouseAdapter() {
            Color colorB = sodaButton.getBackground();
            Color colorF = sodaButton.getForeground();
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
            public void mouseEntered(MouseEvent e) {
                sodaButton.setBackground(Color.green);
                sodaButton.setForeground(Color.DARK_GRAY);
            }
            public void mouseExited(MouseEvent e) {
                sodaButton.setBackground(colorB);
                sodaButton.setForeground(colorF);
            }
        });

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageField.setText("");
                deliveryField.setBackground(Color.BLACK);
                deliveryField.setText("");

                String moneyInput = MainGUI.moneyField.getText();
                moneyField.setText("");
                try {
                    double moneyCheck = Double.parseDouble(moneyInput);
                    if (moneyCheck != 0.5 && moneyCheck != 1.0 && moneyCheck != 5.0 && moneyCheck != 10.0) {
                        messageField.setText("Sadece 50Kurus(0.5TL), 1TL, 5TL ve 10TL girişi yapabilirsiniz !");
                    }
                    else {
                        double balance = MainGUI.getBalance(moneyCheck);
                        balanceField.setText("" + balance);
                    }
                } catch (Exception e1) {
                    messageField.setText("Sadece 50Kurus(0.5TL), 1TL, 5TL ve 10TL girişi yapabilirsiniz !");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryField.setBackground(Color.BLACK);
                deliveryField.setText("");

                double balance = MainGUI.getBalance(0);
                if (balance > 0) {
                    int answer = JOptionPane.showConfirmDialog(mainFrame, "İşleminizi bitirmek istiyor musnuz?",
                            "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                    if (answer == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(mainFrame, "Para üstünüzü alın ! " + balance + " TL",
                                "Uyarı", JOptionPane.INFORMATION_MESSAGE);
                        //messageField.setText("Para üstünüzü alın ! " + balance + " TL");
                        balanceField.setText("0");
                    }
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "İşleminiz sonlandırıldı.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    //messageField.setText("İşleminiz sonlandırıldı.");
                }
            }
        });

        cokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = MainGUI.getBalance(0);
                if (balance >= 15) {
                    messageField.setText("");
                    deliveryField.setBackground(Color.DARK_GRAY);
                    deliveryField.setText("Kola'nızı alın !");
                    balanceField.setText("" + MainGUI.getBalance(-15));
                    JOptionPane.showMessageDialog(mainFrame, "Kola'nızı alın !", "Ürün Teslim", JOptionPane.INFORMATION_MESSAGE);
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                } else {
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                    messageField.setText("Yeterli bakiyeniz yok. Yeni giriş yapınız.");
                }
            }
        });

        fantaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = MainGUI.getBalance(0);
                if (balance >= 20) {
                    messageField.setText("");
                    deliveryField.setBackground(Color.DARK_GRAY);
                    deliveryField.setText("Fanta'nızı alın !");
                    balanceField.setText("" + MainGUI.getBalance(-20));
                    JOptionPane.showMessageDialog(mainFrame, "Fanta'nızı alın !", "Ürün Teslim", JOptionPane.INFORMATION_MESSAGE);
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                } else {
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                    messageField.setText("Yeterli bakiyeniz yok. Yeni giriş yapınız.");
                }
            }
        });

        sodaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = MainGUI.getBalance(0);
                if (balance >= 30) {
                    messageField.setText("");
                    deliveryField.setBackground(Color.DARK_GRAY);
                    deliveryField.setText("Gazoz'unuz alın !");
                    balanceField.setText("" + MainGUI.getBalance(-30));
                    JOptionPane.showMessageDialog(mainFrame, "Gazoz'unuzu alın !", "Ürün Teslim", JOptionPane.INFORMATION_MESSAGE);
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                } else {
                    deliveryField.setBackground(Color.BLACK);
                    deliveryField.setText("");
                    messageField.setText("Yeterli bakiyeniz yok. Yeni giriş yapınız.");
                }
            }
        });
    }
}
