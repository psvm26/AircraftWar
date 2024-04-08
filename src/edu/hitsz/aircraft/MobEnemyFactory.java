package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class MobEnemyFactory implements EnemyFactory{
    @Override
    public AbstractAircraft creatEnemy() {
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_HEIGHT * 0.05);
        int speedX = 0;
        int speedY = 10;
        int hp = 30;
        return new MobEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
