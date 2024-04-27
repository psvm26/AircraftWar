package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shoot.ScatterShootStrategy;

public class BulletProp extends AbstractProp{
    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void func(HeroAircraft heroAircraft) {
        super.func(heroAircraft);
        heroAircraft.setShootNum(3);
        heroAircraft.setShootStrategy(new ScatterShootStrategy());
    }
}
