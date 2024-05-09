package edu.hitsz.prop;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shoot.ScatterShootStrategy;
import edu.hitsz.shoot.StraightShootStrategy;

public class BulletProp extends AbstractProp{
    private Thread nowThread;
    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void func(HeroAircraft heroAircraft) {
        super.func(heroAircraft);
        heroAircraft.setShootNum(3);
        heroAircraft.setShootStrategy(new ScatterShootStrategy());
        Runnable r = () -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ignore) {}
            heroAircraft.setShootNum(1);
            heroAircraft.setShootStrategy(new StraightShootStrategy());
        };
        if(nowThread != null) {
            nowThread.interrupt();
        }
        nowThread = new Thread(r);
        nowThread.start();
    }
}
