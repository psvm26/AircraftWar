package edu.hitsz.aircraft;

import edu.hitsz.prop.AbstractProp;
import edu.hitsz.prop.BloodProp;
import edu.hitsz.prop.BulletProp;
import edu.hitsz.prop.BombProp;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EliteEnemy extends AbstractAircraft{

    /**攻击方式 */

    /**
     * 子弹一次发射数量
     */
    private int shootNum = 1;

    /**
     * 子弹伤害
     */
    private int power = 30;

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    private int direction = -1;

    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public void forward(){
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
            bullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y, speedX, speedY, power);
            res.add(bullet);
        }
        return res;
    }

    @Override
    public void vanish() {
        super.vanish();
        System.out.println("Hit");
    }

    public AbstractProp produceprop() {
        int x = this.locationX;
        int y = this.locationY;
        int speedX = 0;
        int speedY = this.speedY / 2;
        Random rand = new Random();
        int n = rand.nextInt(10);
        if (n % 3 == 0) {
            return new BloodProp(x, y, speedX, speedY);
        } else if (n % 3 == 1) {
            return new BulletProp(x, y, speedX, speedY);
        } else {
            return new BombProp(x, y, speedX, speedY);
        }
    }
}
