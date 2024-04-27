package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.basic.AbstractFlyingObject;
import edu.hitsz.prop.AbstractProp;
import edu.hitsz.shoot.ShootStrategy;

import java.util.List;

/**
 * 所有种类飞机的抽象父类：
 * 敌机（BOSS, ELITE, MOB），英雄飞机
 *
 * @author hitsz
 */
public abstract class AbstractAircraft extends AbstractFlyingObject {
    /**
     * 生命值
     */
    protected int maxHp;
    protected int hp;
    private int score;
    private int shootFreq;
    private ShootStrategy shootStrategy;
    private int shootNum;

    public int getShootNum() {
        return shootNum;
    }

    public int getPower() {
        return power;
    }

    public int getDirection() {
        return direction;
    }

    private int power;
    private int direction;

    public AbstractAircraft(int locationX, int locationY, int speedX, int speedY, int hp, int score,
                            int shootFreq,int shootNum,int power, int direction,ShootStrategy shootStrategy) {
        super(locationX, locationY, speedX, speedY);
        this.hp = hp;
        this.maxHp = hp;
        this.score = score;
        this.shootFreq = shootFreq;
        this.shootStrategy = shootStrategy;
        this.shootNum = shootNum;
        this.power = power;
        this.direction = direction;
    }

    public void decreaseHp(int decrease){
        hp -= decrease;
        if(hp <= 0){
            hp=0;
            vanish();
        }
    }

    public int getHp() {
        return hp;
    }
    public int getScore() {
        return score;
    }
    public int getShootFreq(){
        return shootFreq;
    }

    public void setShootNum(int shootNum) {
        this.shootNum = shootNum;
    }

    public void setShootStrategy(ShootStrategy shootStrategy) {
        this.shootStrategy = shootStrategy;
    }


    /**
     * 飞机射击方法，可射击对象必须实现
     *
     * @return 可射击对象需实现，返回子弹
     * 非可射击对象空实现，返回null
     */
    public List<BaseBullet> shoot() {
        return shootStrategy.shoot(locationX, locationY, speedX, speedY,
                direction, power, shootNum);
    }

    public abstract List<AbstractProp> produceprop();

}


