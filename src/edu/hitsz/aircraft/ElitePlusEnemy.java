package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ElitePlusEnemy extends AbstractAircraft{

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 3;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = -1;
    private int propNum = 1;

    public ElitePlusEnemy(int locationX, int locationY, int speedX, int speedY, int hp, int score, int shootFreq) {
        super(locationX, locationY, speedX, speedY, hp, score, shootFreq);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() - direction*5;
        BaseBullet bullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedX + 5*(i-1), speedY, power);
            res.add(bullet);
        }
        return res;
    }

    public List<AbstractProp> produceprop() {
        int x = this.locationX;
        int y = this.locationY;
        int speedX = 0;
        int speedY = this.speedY / 2;
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
            abstractProp = propFactory.creatProp(x, y, speedX, speedY);
            Props.add(abstractProp);
        }
        return Props;
    }
}
