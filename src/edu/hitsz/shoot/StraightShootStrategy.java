package edu.hitsz.shoot;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

public class StraightShootStrategy implements ShootStrategy {
    @Override
    public List<BaseBullet> shoot(int locationX, int locationY, int speedX, int speedY,int direction, int power, int shootNum) {
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction*2;
        int bSpeedX = 0;
        int bSpeedY = speedY - direction*5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(direction == 1) {
                bullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y, bSpeedX, bSpeedY, power);
            }else {
                bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, bSpeedX, bSpeedY, power);
            }

            res.add(bullet);
        }
        return res;
    }
}
