package HartenJagen.objects;

import CardGame.state.factories.DeckFactory;
import CardGame.state.objects.Player;
import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.tables.SlagTable;
import CardGame.state.objects.tables.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class HJTable extends SlagTable {

    private boolean broken = false;
    //0 to the left,1 to the right,2 to the front and 3 to yourself
    private int passCardsTo =0;

    public HJTable(Player... players){
        super(DeckFactory.getInstance().getDeck52(), players);
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

    //override this method to see when hearts are broken
    @Override
    public void letPlayerPlay(int player){
        super.letPlayerPlay(player);
        if(!broken && getCurrSlag().getCard(player).getColour() == CardColor.HEARTS){
            setBroken(true);
        }
    }
}
