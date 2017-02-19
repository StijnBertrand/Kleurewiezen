package HartenJagen;

import CardGame.Card;
import CardGame.CardColor;
import CardGame.HumanPlayer;
import CardGameGraphics.PlayerController;
import Graphics.Screen;

/**
 * Created by stijn on 2/18/17.
 */
public class HJPlayer extends HumanPlayer implements HJPlayerInterface {


    protected final Object lock = new Object();

    private int amount=0;
    //TODO: make this logic more generic
    public void PassOnCards(){
        synchronized(lock){
            setCanSelect(false);
            if(getSelected().size()==amount){
                lock.notify();
            }else{
                setCanSelect(true);            }
        }
    }

    @Override
    public Card[] letPassOnCards(int amount) {
        try {
            synchronized(lock){
                this.amount=amount;
                setCanSelect(true);
                lock.wait();

                Card[] cards = new Card[amount];
                for(int i = 0;i< amount;i++){
                    cards[i] = hand.play(getSelected().get(i));
                }
                return cards;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean has2OfClubs(){
        return hasCard(CardColor.CLUBS,1);
    }

    @Override
    protected boolean canPlay(int card){
        if(table.getCurrSlag().getStarter() ==-1){
            //this player opens the slag
            if(((HJTable)table).isBroken()){
                return true;
            }else{
                if(hand.getCard(card).getColour()== CardColor.HEARTS){//tries to play hearts when not broken
                    return !this.hasCards(CardColor.CLUBS)&&!this.hasCards(CardColor.SPADES)&&!this.hasCards(CardColor.DIMONDS);
                }
            }
            //if he has the 2 of clubs he must play it
            return (hand.getCard(card).getColour()==CardColor.CLUBS && hand.getCard(card).getNumber()==1)|| !hasCard(CardColor.CLUBS,1);

        }else{
            Card openCard = table.getCurrSlag().getCard(table.getCurrSlag().getStarter());
            if(hasCards(openCard.getColour())){
                //the player has cards of the same colour
                return hand.getCard(card).getColour() == openCard.getColour();
            }else{
                if(openCard.getColour()==CardColor.CLUBS && openCard.getNumber()==1){
                    //if the opencard is the 2 of clubs no points may fall
                    //TODO: case where the player only has points
                    return hand.getCard(card).getColour()!= CardColor.HEARTS
                            && !(hand.getCard(card).getColour()== CardColor.SPADES && hand.getCard(card).getNumber()==11) ;
                }else{
                    return true;
                }
            }
        }
    }

    @Override
    public void giveScreen(Screen s){
        new HJController(s, this);
    }
}
