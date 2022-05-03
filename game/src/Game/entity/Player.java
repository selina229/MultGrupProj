package Game.entity;

import Game.main.GamePanel;
import Game.main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyHandler;

    boolean isJump = false;
    int jumpCounter = 0;
    int negative = 0;
    int yCurr = 0;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        Entity.x = 100;
        Entity.y = 100;
        Entity.speed = 4;
        direction = "right";
    }

    public void getPlayerImage() {
        try {
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/Ninja_Left_Move1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/Ninja_Left_Move2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/Ninja_Right_Move1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/Ninja_Right_Move2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(KeyHandler.leftPressed || KeyHandler.rightPressed) {
            if (KeyHandler.leftPressed == true) {
                direction = "left";
                Entity.x -= Entity.speed;
            } else if (KeyHandler.rightPressed == true) {
                direction = "right";
                Entity.x += Entity.speed;
            } /* else if (KeyHandler.spacePressed == true) {
                if (isJump == false) {
                    yCurr = Entity.y;
                    isJump = true;
                }
            }
            if (isJump && yCurr >= Entity.y) {
                if (jumpCounter >= -8) {
                    negative = 1;
                } else {
                    jumpCounter = 10;
                }
                if (jumpCounter < 0) {
                    negative = -1;
                }
                Entity.y -= (Math.pow(jumpCounter, 2)) * 0.5 * negative;
                jumpCounter -= 1;
            } else if(isJump && yCurr >= Entity.y) {
                isJump = false;
                Entity.y = yCurr;
            }
            */

            spriteCounter++;
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                } else if(spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch(direction) {
            case "left":
                if(spriteNum == 1) {
                    image = left1;
                } else if(spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image = right1;
                } else if(spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
