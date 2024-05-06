package edu.hitsz.page;

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

    public RankList(PlayerDaoImpl playerDaoImpl) {
        String[] columnName = {"排名","昵称","分数","时间"};
        String[][] tableData = playerDaoImpl.listToStringArray();

        //表格模型
        DefaultTableModel model = new DefaultTableModel(tableData, columnName){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };

        //JTable并不存储自己的数据，而是从表格模型那里获取它的数据
        rankTable.setModel(model);
        rankScrollPanel.setViewportView(rankTable);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = rankTable.getSelectedRow();
                System.out.println(row);
                int result = JOptionPane.showConfirmDialog(deleteButton,
                        "是否确定中删除？");
                if (JOptionPane.YES_OPTION == result && row != -1) {
                    model.removeRow(row);
                    playerDaoImpl.deleteByRank(row);
                    playerDaoImpl.store();
                }
            }
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPage.cardLayout.first(mainPage.cardPanel);
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
