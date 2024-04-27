package edu.hitsz.dao;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PlayerDaoImpl implements PlayerDao{

    private List<Player> players;

    public PlayerDaoImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public void findById(int playerId) {
        for(Player item : players) {
            if(item.getPlayId() == playerId) {
                System.out.println("Find Player: ID [" + playerId
                +"],name [" + item.getPlayerName() + "],score ["
                + item.getPlayScore() + "],time [" + item.getPlayTime() + "].");
                return;
            }
        }
        System.out.println("Can not find this player.");
    }

    @Override
    public List<Player> getAllPlayer() {
        return players;
    }

    @Override
    public void doAdd(Player player) {
        players.add(player);
    }

    @Override
    public int getMaxId() {
        int maxId = 0;
        for(Player item: players) {
            maxId = Math.max(maxId, item.getPlayId());
        }
        return maxId;
    }

    @Override
    public void sortPlayers() {
        //重写compare方法，最好加注解，不加也没事
        Collections.sort(players, (a, b) -> {
            //返回值>0交换
            return b.getPlayScore() - a.getPlayScore();
        });
    }

    @Override
    public void store() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/edu/hitsz/dao/players.txt"));
            //遍历集合，得到每一个字符串数据
            for(Player  p: players) {
                //调用字符缓冲输出流对象的方法写数据
                StringBuilder sb = new StringBuilder();
                sb.append(p.getPlayId()).append(',')
                  .append(p.getPlayerName()).append(',')
                  .append(p.getPlayScore()).append(',')
                  .append(p.getPlayTime());
                bw.write(sb.toString());
                System.out.println(sb);
                bw.newLine();
                bw.flush();
            }
            //释放资源
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/edu/hitsz/dao/players.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int playerId = Integer.parseInt(parts[0]);
                String palyerName = parts[1];
                int playerScore = Integer.parseInt(parts[2]);
                String playTime = parts[3];
                Player player = new Player(palyerName, playerId, playerScore, playTime);
                players.add(player);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printRankList(String playerName, int score) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
        String time = formatter.format(calendar.getTime());
        load();
        Player player = new Player(playerName, getMaxId() + 1, score, time);
        doAdd(player);
        sortPlayers();
        store();
        int i = 1;
        System.out.println("---------------------------");
        System.out.println("           排行榜           ");
        System.out.println("---------------------------");
        for(Player p: players) {
            System.out.println("第" + i + "名" + "\t" + p.getPlayerName() + "\t" + p.getPlayScore() + "\t" + p.getPlayTime());
            i++;
        }
    }

}
