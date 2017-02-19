package HartenJagen;

import CardGame.CardColor;
import CardGame.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class DecideStarter extends Module {
    @Override
    public void execute(Table table) {
        for(int i = 0;i<table.getAmountOfPlayers();i++){
            if((table.getPlayer(i)).hasCard(CardColor.CLUBS,1)){
                table.setStarter(i);
                return;
            }
        }
    }
}
