package CardGame.state.factories;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.enums.CardNumber;
import CardGame.state.objects.Card;
import CardGame.state.objects.Deck;

public class DeckFactory {
	private static DeckFactory factory = new DeckFactory();
	
	
	public static DeckFactory getInstance(){
		return factory;
	}
	
	private DeckFactory(){
			
	}
	public Deck troelTest(){
		Deck d = new Deck();
			
		d.addCard(new Card(CardColor.HEARTS, CardNumber.ACE));
		d.addCard(new Card(CardColor.SPADES,CardNumber.ACE));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.ACE));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.ACE));
		
		d.addCard(new Card(CardColor.HEARTS,CardNumber.TWO));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.THREE));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.FOUR));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.FIVE));
		
		d.addCard(new Card(CardColor.HEARTS,CardNumber.SIX));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.SEVEN));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.EIGHT));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.NINE));
		
		d.addCard(new Card(CardColor.HEARTS,CardNumber.TEN));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.JACK));
		d.addCard(new Card(CardColor.HEARTS,CardNumber.QUEEN));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.TWO));
		
		
		d.addCard(new Card(CardColor.HEARTS,CardNumber.KING));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.THREE));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.FOUR));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.FIVE));
		
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.SIX));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.SEVEN));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.EIGHT));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.NINE));
		
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.TEN));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.JACK));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.QUEEN));
		d.addCard(new Card(CardColor.DIMONDS,CardNumber.KING));

		d.addCard(new Card(CardColor.CLUBS,CardNumber.TWO));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.THREE));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.FOUR));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.FIVE));
		
		
		d.addCard(new Card(CardColor.CLUBS,CardNumber.SIX));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.SEVEN));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.EIGHT));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.NINE));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.TEN));
		
		d.addCard(new Card(CardColor.CLUBS,CardNumber.JACK));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.QUEEN));
		d.addCard(new Card(CardColor.CLUBS,CardNumber.KING));
		d.addCard(new Card(CardColor.SPADES,CardNumber.TWO));
		d.addCard(new Card(CardColor.SPADES,CardNumber.THREE));
		
		d.addCard(new Card(CardColor.SPADES,CardNumber.FOUR));
		d.addCard(new Card(CardColor.SPADES,CardNumber.FIVE));
		d.addCard(new Card(CardColor.SPADES,CardNumber.SIX));
		d.addCard(new Card(CardColor.SPADES,CardNumber.SEVEN));
		d.addCard(new Card(CardColor.SPADES,CardNumber.EIGHT));
		
		d.addCard(new Card(CardColor.SPADES,CardNumber.NINE));
		d.addCard(new Card(CardColor.SPADES,CardNumber.TEN));
		d.addCard(new Card(CardColor.SPADES,CardNumber.JACK));
		d.addCard(new Card(CardColor.SPADES,CardNumber.QUEEN));
		d.addCard(new Card(CardColor.SPADES,CardNumber.KING));
		return d;
		
		
		
	}
	
	
	
	
	public Deck getDeck52(){
		Deck d = new Deck();
		for(int colour = 0; colour != 4;colour++){
			for(int number = 0; number != 13;number++){
				d.addCard(new Card(CardColor.fromInt(colour),CardNumber.fromInt(number)));
			}
		}		
		return d;	
	}
	
	public Deck getDeck55(){
		Deck d = getDeck52();
		d.addCard(new Card(CardColor.JOKER,CardNumber.NONE));
		d.addCard(new Card(CardColor.JOKER,CardNumber.NONE));
		d.addCard(new Card(CardColor.JOKER,CardNumber.NONE));
		return d;
	}
}