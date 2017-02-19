package HartenJagen;

import CardGame.Card;
import CardGame.Slag;
import CardGame.Table;

/**
 * Created by stijn on 2/18/17.
 */
public class PlayRounds extends  Module {

    /**
     * This module allows players to play their cards.
     * standard behavior:
     *      - each player plays one card (starting with player table.getStarter())
     *      - the Slag is appointed to the player decided by getWinnerCurrentSlag(Table table)
     *      - the next starter is decided by getNextStarter(Table table)
     *      - repeat until finished(Table table) returns true
     *
     * This behavior can be altered by overring following methods:
     *      - getWinnerCurrentSlag(Table table)
     *      - getNextStarter(Table table)
     *      - finished(Table table)
     */

    @Override
    public void execute(Table table) {
        setStarter(table.getStarter());
        while(!finished(table)){
            //play one slag
            for(int i = 0;i<table.getAmountOfPlayers();i++  ){
                table.letPlayerPlay((getStarter()+i)%table.getAmountOfPlayers());
            }
            setWinner(getWinnerCurrentSlag(table));
            table.appointSlag(getWinner());
            setStarter(getNextStarter(table));
        }
    }

    protected int getNextStarter(Table table){
        return getWinner();
    }

    protected int getWinnerCurrentSlag(Table table){
        int winner = getStarter();
        Slag s = table.getCurrSlag();

        Card highest = s.getCard(s.getStarter());

        for(int i = 1; i<table.getAmountOfPlayers();i++){
            int currPlayer = (s.getStarter() + i)%table.getAmountOfPlayers();
            Card curr = s.getCard(currPlayer);
            //remember that number 0 corresponds with the Ace
            if(curr.getColour() == highest.getColour()){
                if(highest.getNumber()==0)continue;
                if(curr.getNumber()>highest.getNumber() | curr.getNumber() == 0){
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

    protected boolean finished(Table table){
        return table.getPlayer(0).getAmountOfCards()==0;
    }

    //geters and setters
    private int starter;
    private int winner;
    protected int getStarter() {
        return starter;
    }

    private void setStarter(int starter) {
        this.starter = starter;
    }

    protected  int getWinner() {
        return winner;
    }

    private void setWinner(int winner) {
        this.winner = winner;
    }
}
