package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.*;
import edu.hitsz.shoot.ShootStrategy;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BossEnemy extends AbstractAircraft{
    private int propNum = 3;

    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp, int score, int shootFreq,
                     int shootNum, int power, int direction, ShootStrategy shootStrategy) {
        super(locationX, locationY, speedX, speedY, hp, score, shootFreq, shootNum, power, direction, shootStrategy);
    }

//    public List<BaseBullet> shoot() {
//        List<BaseBullet> res = new LinkedList<>();
//        int x = this.getLocationX();
//        int y = this.getLocationY() - direction*40;
//        double l = Main.WINDOW_WIDTH * 0.3;
//        double speed_l = 10;
//        BaseBullet bullet;
//        for(int i=0; i<shootNum; i++){
//            // 子弹发射位置相对飞机位置向前偏移
//            // 多个子弹横向分散
//            double theta = (i-10) * Math.PI / 10;
//            bullet = new EnemyBullet((int)(x + l*Math.sin(theta)), (int)(y + l*Math.cos(theta)),
//                    (int)(speed_l*Math.sin(theta)) + this.speedX, (int)(speed_l*Math.cos(theta)) + this.speedY, power);
//            res.add(bullet);
//        }
//        return res;
//    }

    @Override
    public List<AbstractProp> produceprop() {
        int x = this.locationX;
        int y = this.locationY;
        int speedX = 0;
        int speedY = 5;
        AbstractProp abstractProp;
        List<AbstractProp> Props = new LinkedList<>();
        PropFactory propFactory;
        Random rand = new Random();
        for(int i = 0;i < this.propNum; i++) {
            int n = rand.nextInt(12);
            if (n % 4 == 0) {
                propFactory  =new BloodPropFactory();
            } else if (n % 4 == 1) {
                propFactory  =new BulletPlusPropFactory();
            } else if (n % 4 == 2){
                propFactory  =new BulletPropFactory();
            }else {
                propFactory = new BombPropFactory();
            }
            int loc_x = this.propNum == 1?x : x + 40 * (i - 1);
            abstractProp = propFactory.creatProp(loc_x, y, speedX, speedY);
            Props.add(abstractProp);
        }
        return Props;
    }
}
