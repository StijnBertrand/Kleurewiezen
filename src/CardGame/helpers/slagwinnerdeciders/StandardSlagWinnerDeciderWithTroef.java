package CardGame.helpers.slagwinnerdeciders;

import CardGame.state.objects.Card;
import CardGame.state.objects.Slag;
import CardGame.state.objects.enums.CardNumber;
import CardGame.state.objects.tables.TroefTable;

/**
 * Created by stijn on 4/16/17.
 */

public class StandardSlagWinnerDeciderWithTroef implements SlagWinnerDecider<TroefTable>{
    public int decideWinner(TroefTable table){
        Slag s = table.getCurrSlag();
        int winner = s.getStarter();

        Card highest = s.getCard(s.getStarter());

        for(int i = 1; i<table.getAmountOfPlayers();i++){
            int currPlayer = (s.getStarter() + i)%table.getAmountOfPlayers();
            Card curr = s.getCard(currPlayer);
            if(curr.getColour() == highest.getColour()){
                if(highest.getNumber()== CardNumber.ACE)continue;
                if(curr.getNumber().getValue()>highest.getNumber().getValue()| curr.getNumber() == CardNumber.ACE){
                    highest = curr;
                    winner = currPlayer;
                }
            }else if(curr.getColour().equals(table.getTroef())){
                winner = currPlayer;
                highest = curr;
            }
        }
        return winner;
    }
}


