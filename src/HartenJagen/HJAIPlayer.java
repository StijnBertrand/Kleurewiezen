package HartenJagen;

import CardGame.Card;
import CardGame.CardColor;
import CardGame.Player;

/**
 * Created by stijn on 2/19/17.
 */
public class HJAIPlayer extends Player implements HJPlayerInterface{


    @Override
    public Card letPlay() {
        for( int i = 0; i < getAmountOfCards();i++){
            if(canPlay(i)){
                return hand.play(i);
            }
        }
        return null;
    }



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
    public Card[] letPassOnCards(int amount) {
        Card[] cards = new Card[3];
        cards[0] = hand.play(0);
        cards[1] = hand.play(2);
        cards[2] = hand.play(3);
        return cards;
    }
}
