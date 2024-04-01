package edu.hitsz.Equip;

public class BulletProp extends AbstractProp{
    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void func() {
        super.func();
        System.out.println("“FireSupply active!");
    }
}
