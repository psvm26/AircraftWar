package edu.hitsz.prop;

public class BulletPropFactory implements PropFactory{
    @Override
    public AbstractProp creatProp(int locationX, int locationY, int speedX, int speedY) {
        return new BulletProp(locationX, locationY, speedX, speedY);
    }
}
