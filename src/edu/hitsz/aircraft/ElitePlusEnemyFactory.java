package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.shoot.ScatterShootStrategy;
import edu.hitsz.shoot.ShootStrategy;

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
        int shootNum = 3;
        int power = 30;
        int direction = -1;
        ShootStrategy shootStrategy = new ScatterShootStrategy();
        return new ElitePlusEnemy(locationX, locationY, speedX, speedY, hp, score,
                shootFreq, shootNum, power, direction, shootStrategy);
    }
}
