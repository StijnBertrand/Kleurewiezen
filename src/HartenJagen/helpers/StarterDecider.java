package HartenJagen.helpers;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.tables.Table;
import CardGame.state.objects.enums.CardNumber;

/**
 * Created by stijn on 2/19/17.
 */
public class StarterDecider {

    public static void decideStarter(Table table){
        for(int i = 0;i<table.getAmountOfPlayers();i++){
            if((table.getPlayer(i)).hasCard(CardColor.CLUBS, CardNumber.TWO)){
                table.setStarter(i);
                return;
            }
        }
    }
}
