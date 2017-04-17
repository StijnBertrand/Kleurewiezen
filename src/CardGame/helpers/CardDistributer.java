package CardGame.helpers;

import CardGame.state.objects.tables.Table;

/**
 * Created by stijn on 4/16/17.
 */
public class CardDistributer {

    public final void distributeCards(Table table, int... patrn){
        for(int amount:patrn){
            giveCards(table, amount);
        }
    }


    public final void giveCards(Table table, int amount){
        for(int i = 0;i<table.getAmountOfPlayers();i++){
            int player = (table.getDealer() + i) % table.getAmountOfPlayers();
            for(int j = 0; j != amount; j++) {
                table.getPlayer(player).giveCard(table.getDeck().takeCard());
            }
        }
    }
}
