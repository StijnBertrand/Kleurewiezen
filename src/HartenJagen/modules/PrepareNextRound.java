package HartenJagen.modules;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.Table;
import CardGame.flow.core.Module;
import HartenJagen.objects.HJTable;

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
