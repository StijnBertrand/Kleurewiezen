package HartenJagen.modules;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.Table;
import CardGame.flow.core.Module;
import CardGame.state.objects.enums.CardNumber;

/**
 * Created by stijn on 2/19/17.
 */
public class DecideStarter extends Module {
    @Override
    public void execute(Table table) {
        for(int i = 0;i<table.getAmountOfPlayers();i++){
            if((table.getPlayer(i)).hasCard(CardColor.CLUBS, CardNumber.TWO)){
                table.setStarter(i);
                return;
            }
        }
    }
}
