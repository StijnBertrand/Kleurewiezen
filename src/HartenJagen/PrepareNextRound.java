package HartenJagen;

import CardGame.CardColor;
import CardGame.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class PrepareNextRound extends Module {
    @Override
    public void execute(Table table) {
        table.setDealer((table.getDealer()+1)%table.getAmountOfPlayers());
        table.reset();
        table.setTroef(CardColor.NONE);
        ((HJTable)table).setBroken(false);
    }
}
