package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;

public class BloodProp extends AbstractProp {
    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void func(HeroAircraft heroAircraft) {
        super.func(heroAircraft);
        System.out.println("Add hp!");
        heroAircraft.increaseHp();
    }
}
