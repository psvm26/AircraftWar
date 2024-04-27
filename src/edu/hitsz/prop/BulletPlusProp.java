package edu.hitsz.prop;


import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shoot.LoopShootStrategy;
import edu.hitsz.shoot.ScatterShootStrategy;

public class BulletPlusProp extends AbstractProp{
    public BulletPlusProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void func(HeroAircraft heroAircraft) {
        super.func(heroAircraft);
        heroAircraft.setShootNum(20);
        heroAircraft.setShootStrategy(new LoopShootStrategy());
    }
}