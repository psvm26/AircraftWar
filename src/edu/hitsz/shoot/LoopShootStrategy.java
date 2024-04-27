package edu.hitsz.shoot;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class LoopShootStrategy implements ShootStrategy {
    @Override
    public List<BaseBullet> shoot(int locationX, int locationY, int speedX, int speedY, int direction, int power, int shootNum) {
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY - direction*40;
        double l = Main.WINDOW_WIDTH * 0.3;
        double speed_l = 10;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            double theta = (i-shootNum / 2) * Math.PI / 10;
            if(direction == 1) {
                bullet = new HeroBullet((int)(x + l*Math.sin(theta)), (int)(y + l*Math.cos(theta)),
                        (int)(speed_l*Math.sin(theta)) + speedX, (int)(speed_l*Math.cos(theta)) + speedY, power);
                res.add(bullet);
            } else {
                bullet = new EnemyBullet((int)(x + l*Math.sin(theta)), (int)(y + l*Math.cos(theta)),
                        (int)(speed_l*Math.sin(theta)) + speedX, (int)(speed_l*Math.cos(theta)) + speedY, power);
                res.add(bullet);
            }

        }
        return res;
    }
}
