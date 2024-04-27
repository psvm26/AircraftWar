package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.shoot.LoopShootStrategy;
import edu.hitsz.shoot.ShootStrategy;

import java.util.Random;

public class BossEnemyFactory implements EnemyFactory{
    @Override
    public AbstractAircraft creatEnemy() {
        Random rand = new Random();
        int r = rand.nextInt(10);
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05) + 80;
        int speedX = 5 * (r < 5? 1 : -1);
        int speedY = 0;
        int hp = 120;
        int score = 100;
        int shootFreq = 2400;
        int shootNum = 20;
        int power = 30;
        int direction = -1;
        ShootStrategy shootStrategy = new LoopShootStrategy();
        return new BossEnemy(locationX, locationY, speedX, speedY, hp, score,
                shootFreq, shootNum, power, direction,shootStrategy);
    }
}
