package HartenJagen.helpers;

import CardGame.state.objects.tables.Table;
import HartenJagen.objects.HJTable;

/**
 * Created by stijn on 2/19/17.
 */
public class NextRoundPreparer {

    public void prepareNextRound(Table table) {
        table.setDealer((table.getDealer()+1)%table.getAmountOfPlayers());
        table.reset();
        ((HJTable)table).setBroken(false);
    }
}
