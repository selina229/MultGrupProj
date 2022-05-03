package Game.entity;

import java.awt.image.BufferedImage;

public class Entity {
    public static int x;
    public static int y;
    public static int speed;

    public BufferedImage left1, left2, right1, right2, leftStand, rightStand;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}
