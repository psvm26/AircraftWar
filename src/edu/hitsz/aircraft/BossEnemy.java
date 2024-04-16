package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.*;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BossEnemy extends AbstractAircraft{

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 20;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = -1;
    private int propNum = 3;

    public BossEnemy(int locationX, int locationY, int speedX, int speedY, int hp, int score, int shootFreq) {
        super(locationX, locationY, speedX, speedY, hp, score, shootFreq);
    }

    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() - direction*40;
        int speedX = 0;
        int speedY = this.getSpeedY() - direction*5;
        double l = Main.WINDOW_WIDTH * 0.3;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            double theta = (i-10) * Math.PI / 10;
            bullet = new EnemyBullet((int) (x + l*Math.sin(theta)), (int)(y + l*Math.cos(theta)), speedX, speedY, power);
            res.add(bullet);
        }
        return res;
    }

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
            int n = rand.nextInt(10);
            if (n % 3 == 0) {
                propFactory  =new BloodPropFactory();
            } else if (n % 3 == 1) {
                propFactory  =new BulletPropFactory();
            } else {
                propFactory  =new BombPropFactory();
            }
            int loc_x = this.propNum == 1?x : x + 40 * (i - 1);
            abstractProp = propFactory.creatProp(loc_x, y, speedX, speedY);
            Props.add(abstractProp);
        }
        return Props;
    }
}
