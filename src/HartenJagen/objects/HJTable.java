package HartenJagen.objects;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class HJTable extends Table {

    private boolean broken = false;
    //0 to the left,1 to the right,2 to the front and 3 to yourself
    private int passCardsTo =0;

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

    //override this method to see when hearts are broken
    @Override
    public void letPlayerPlay(int player){
        super.letPlayerPlay(player);
        if(getCurrSlag().getCard(player).getColour() == CardColor.HEARTS){
            setBroken(true);
        }
    }
}
