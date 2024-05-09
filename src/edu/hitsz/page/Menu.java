package edu.hitsz.page;

import edu.hitsz.application.Game;
import edu.hitsz.application.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JPanel menuMainPanel;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JComboBox musicChoice;
    private JPanel difficulty;
    private JPanel sound;
    private boolean soundChoice = false;

    public Menu() {
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundChoice = musicChoice.getSelectedIndex() == 0;
//                System.out.println(soundChoice);
                Game game = new Game(1, soundChoice);
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                game.action();
            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundChoice = musicChoice.getSelectedIndex() == 0;
                Game game = new Game(2, soundChoice);
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
                game.action();
            }
        });
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                soundChoice = musicChoice.getSelectedIndex() == 0;
                Game game = new Game(3, soundChoice);
                Main.cardPanel.add(game);
                Main.cardLayout.last(Main.cardPanel);
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
