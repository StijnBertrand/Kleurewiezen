package HartenJagen.graphics;

import CardGame.state.objects.HumanPlayer;
import CardGameGraphics.PlayerController;
import Graphics.Screen;
import HartenJagen.objects.HJPlayer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by stijn on 2/19/17.
 */
public class HJController extends PlayerController implements KeyListener {


    public HJController(Screen s, HumanPlayer p) {
        super(s, p);
        s.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            ((HJPlayer)player).PassOnCards();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
