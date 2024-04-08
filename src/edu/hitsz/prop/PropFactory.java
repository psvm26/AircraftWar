package edu.hitsz.prop;

public interface PropFactory {
    public abstract AbstractProp creatProp(int locationX, int locationY, int speedX, int speedY);
}
