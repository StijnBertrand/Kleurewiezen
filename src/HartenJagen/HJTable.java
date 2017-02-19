package HartenJagen;

import CardGame.CardColor;
import CardGame.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class HJTable extends Table {

    private boolean broken = false;
    private boolean finished = false;
    //0 to the left,
    //1 to the right,
    //2 to the front
    //3 to yourself
    private int passCardsTo =0;

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getPassCardsTo() {
        return passCardsTo;
    }

    public void setPassCardsTo(int passCardsTo) {
        this.passCardsTo = passCardsTo;
    }

    public boolean isBroken() {
        return broken;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    @Override
    public void letPlayerPlay(int player){
        super.letPlayerPlay(player);
        if(getCurrSlag().getCard(player).getColour() == CardColor.HEARTS){
            setBroken(true);
        }
    }
}
