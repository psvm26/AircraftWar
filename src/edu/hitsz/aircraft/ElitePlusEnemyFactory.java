package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

import java.util.Random;

public class ElitePlusEnemyFactory implements EnemyFactory{
    @Override
    public AbstractAircraft creatEnemy() {
        Random rand = new Random();
        int r = rand.nextInt(10);
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05);
        int speedX = 5 * (r < 5? 1 : -1);
        int speedY = 10;
        int hp = 90;
        int score = 50;
        int shootFreq = 1200;
        return new ElitePlusEnemy(locationX, locationY, speedX, speedY, hp, score, shootFreq);
    }
}