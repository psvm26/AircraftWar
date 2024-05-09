package edu.hitsz.page;

import edu.hitsz.application.Main;
import edu.hitsz.dao.PlayerDaoImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankList {
    private JPanel mainRankList;
    private JTable rankTable;
    private JScrollPane rankScrollPanel;
    private JLabel topLabel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton deleteButton;
    private JButton returnButton;
    private JLabel difficultyLabel;
    private DefaultTableModel model;

    public RankList(PlayerDaoImpl playerDaoImpl) {
        switch (playerDaoImpl.getDifficulty()) {
            case 1:
                difficultyLabel.setText("难度：简单");break;
            case 2:
                difficultyLabel.setText("难度：普通");break;
            case 3:
                difficultyLabel.setText("难度：困难");break;
            default:
                difficultyLabel.setText("难度：未知");
        }

        //表格模型
        model = playerDaoImpl.listToModel();

        //JTable并不存储自己的数据，而是从表格模型那里获取它的数据
        rankTable.setModel(model);
        rankScrollPanel.setViewportView(rankTable);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = rankTable.getSelectedRow();
//                System.out.println(row);
                int result = JOptionPane.showConfirmDialog(deleteButton,
                        "是否确定中删除？");
                if (JOptionPane.YES_OPTION == result && row != -1) {
                    model.removeRow(row);
                    playerDaoImpl.deleteByRank(row);
                    playerDaoImpl.sortPlayers();
                    model = playerDaoImpl.listToModel();
                    rankTable.setModel(model);
                    rankScrollPanel.setViewportView(rankTable);
                    playerDaoImpl.store();
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cardLayout.first(Main.cardPanel);
            }
        });
    }

    public JPanel getMainRankList() {
        return mainRankList;
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("RankList");
//        frame.setContentPane(new RankList().mainRankList);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
