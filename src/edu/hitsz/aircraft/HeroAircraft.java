package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.shoot.ShootStrategy;
import edu.hitsz.shoot.StraightShootStrategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {
    private static HeroAircraft heroAircraft = null;

    /**
     * @param locationX 英雄机位置x坐标
     * @param locationY 英雄机位置y坐标
     * @param speedX 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param speedY 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param hp    初始生命值
     */
    public HeroAircraft(int locationX, int locationY, int speedX, int speedY, int hp, int score, int shootFreq,
                     int shootNum, int power, int direction, ShootStrategy shootStrage) {
        super(locationX, locationY, speedX, speedY, hp, score, shootFreq, shootNum, power, direction, shootStrage);
    }

    public static HeroAircraft getInstance() {
        int locationX = Main.WINDOW_WIDTH / 2;
        int locationY = Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight();
        int speedX = 0;
        int speedY = 0;
        int hp = 1000;
        int score = 0;
        int shootFreq = 600;
        int shootNum = 1;
        int power = 30;
        int direction = 1;
        ShootStrategy shootStrategy = new StraightShootStrategy();
        if (heroAircraft == null) {
            heroAircraft = new HeroAircraft(locationX, locationY, speedX, speedY, hp, score, shootFreq, shootNum, power, direction, shootStrategy);
        }
        return heroAircraft;
    }

    public void increaseHp(int increase_hp) {
        int minus = super.maxHp - this.hp;
        int increase = Math.min(minus, increase_hp);
        System.out.println("Add "+ increase + " Hp.");
        this.hp += increase;
    }

    public int getHp(){return this.hp;}

    @Override
    public List<AbstractProp> produceprop() {
        return null;
    }

    @Override
    public void forward() {
        // 英雄机由鼠标控制，不通过forward函数移动
    }

    /**
     * 通过射击产生子弹
     * @return 射击出的子弹List
     */
//    public List<BaseBullet> shoot() {
//        int x = this.getLocationX();
//        int y = this.getLocationY() + direction*2;
//        int speedX = 0;
//        int speedY = this.getSpeedY() + direction*5;
//        BaseBullet bullet;
//        for(int i=0; i<shootNum; i++){
//            // 子弹发射位置相对飞机位置向前偏移
//            // 多个子弹横向分散
//            bullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y, speedX, speedY, power);
//            res.add(bullet);
//        }
//        return res;
//    }

}
