package CardGame.state.objects.tables;

import CardGame.state.objects.Deck;
import CardGame.state.objects.Player;
import CardGame.state.objects.enums.CardColor;

/**
 * Created by stijn on 4/16/17.
 */
public class TroefTable extends SlagTable {


    //in some games there is a troef, can be ignored if this stays CardColor.NONE
    private CardColor troef = CardColor.NONE;

    public TroefTable(Deck deck, Player... players) {
        super(deck, players);
    }

    //resets the board for a new round
    public void reset(){
        super.reset();
        this.troef = CardColor.NONE;
    }


    public CardColor getTroef() {
        return troef;
    }

    public void setTroef(CardColor troef) {
        this.troef = troef;
    }
}
