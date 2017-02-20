package CardGame.flow.modules;

import CardGame.state.objects.Table;
import CardGame.flow.core.Module;

/**
 * Created by stijn on 2/18/17.
 */
public class DistributeCards extends Module {


    @Override
    public void execute(Table table) {
        giveCards(table,4);
        giveCards(table,4);
        giveCards(table,5);
    }

    protected void giveCards(Table table, int amount){
        for(int i = 0;i<table.getAmountOfPlayers();i++){
            int player = (table.getDealer() + i) % table.getAmountOfPlayers();
            for(int j = 0; j != amount; j++) {
                table.getPlayer(player).giveCard(table.getDeck().takeCard());
            }
        }
    }
}
