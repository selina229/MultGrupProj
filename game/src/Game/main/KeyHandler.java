package Game.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Game.entity.*;

public class KeyHandler implements KeyListener {

    public static boolean leftPressed, rightPressed, spacePressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A) {
            leftPressed = true;
        } else if(code == KeyEvent.VK_D) {
            rightPressed = true;
        } else if(code == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A) {
            leftPressed = false;
        } else if(code == KeyEvent.VK_D) {
            rightPressed = false;
        } else if(code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
}
