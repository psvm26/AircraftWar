package edu.hitsz.shoot;

import edu.hitsz.bullet.BaseBullet;

import java.util.List;

public interface ShootStrategy {
    List<BaseBullet> shoot(int locationX, int locationY, int speedX, int speedY,
                           int direction,int power,int shootNum);
}
