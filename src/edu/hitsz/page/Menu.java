package edu.hitsz.page;

import edu.hitsz.application.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel menuMainPanel;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JComboBox comboBox1;
    private JPanel difficulty;
    private JPanel sound;

    public Menu() {
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(1);
                mainPage.cardPanel.add(game);
                mainPage.cardLayout.last(mainPage.cardPanel);
                game.action();
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(2);
                mainPage.cardPanel.add(game);
                mainPage.cardLayout.last(mainPage.cardPanel);
                game.action();
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(3);
                mainPage.cardPanel.add(game);
                mainPage.cardLayout.last(mainPage.cardPanel);
                game.action();
            }
        });
    }

    public JPanel getMenuMainPanel() {
        return menuMainPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu().menuMainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
