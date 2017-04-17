package CardGame.helpers;

import CardGame.helpers.slagwinnerdeciders.SlagWinnerDecider;
import CardGame.state.objects.Card;
import CardGame.state.objects.Slag;
import CardGame.state.objects.enums.CardNumber;
import CardGame.state.objects.tables.SlagTable;
import CardGame.state.objects.tables.Table;
import CardGame.state.objects.tables.TroefTable;

/**
 * Created by stijn on 4/16/17.
 */
public class CardsPlayer<T extends SlagTable> {



    public final void playAllCards(T table,SlagWinnerDecider<T> method) {
        int starter = table.getStarter();
        while(!finished(table)){
            //play one slag
            playOneCardEach(table, starter);
            //decide who won the slag
            starter = method.decideWinner(table);
            table.appointSlag(starter);
        }
    }


    public final void playOneCardEach(Table table, int starter){
        for(int i = 0;i<table.getAmountOfPlayers();i++  ){
            table.letPlayerPlay((starter+i)%table.getAmountOfPlayers());
        }
    }

    protected boolean finished(Table table){
        return table.getPlayer(0).getAmountOfCards()==0;
    }


}
