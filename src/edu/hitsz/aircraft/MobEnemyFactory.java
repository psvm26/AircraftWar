package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.shoot.ScatterShootStrategy;
import edu.hitsz.shoot.ShootStrategy;
import edu.hitsz.shoot.StraightShootStrategy;

import java.util.LinkedList;

public class MobEnemyFactory implements EnemyFactory{
    @Override
    public AbstractAircraft creatEnemy() {
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05);
        int speedX = 0;
        int speedY = 10;
        int hp = 30;
        int score = 10;
        int shootFreq = 600;
        int shootNum = 0;
        int power = 0;
        int direction = -1;
        ShootStrategy shootStrategy = new StraightShootStrategy();
        return new MobEnemy(locationX, locationY, speedX, speedY, hp, score,
                shootFreq, shootNum, power, direction, shootStrategy);
    }
}
