package edu.hitsz.dao;

public class Player {
    private String playerName;
    private int playId;
    private int playScore;
    private String playTime;

    public Player(String playerName, int playId, int playScore, String playTime) {
        this.playerName = playerName;
        this.playId = playId;
        this.playScore = playScore;
        this.playTime = playTime;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayId() {
        return playId;
    }

    public void setPlayId(int playId) {
        this.playId = playId;
    }

    public int getPlayScore() {
        return playScore;
    }

    public void setPlayScore(int playScore) {
        this.playScore = playScore;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    //public static void main(String[] args) {
//    Calendar calendar = Calendar.getInstance();
//    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
//    String time = formatter.format(calendar.getTime());
//    System.out.println(time);
//}

}
