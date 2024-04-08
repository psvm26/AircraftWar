package edu.hitsz.prop;

public class BloodPropFactory implements PropFactory{
    @Override
    public AbstractProp creatProp(int locationX, int locationY, int speedX, int speedY) {
        return new BloodProp(locationX, locationY, speedX, speedY);
    }
}
