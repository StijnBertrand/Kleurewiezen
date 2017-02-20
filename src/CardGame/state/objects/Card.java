package CardGame.state.objects;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.enums.CardNumber;

public class Card {

	private CardColor colour;
	private CardNumber number;
	
	public Card(CardColor colour, CardNumber number){
		this.colour = colour;
		this.number = number;
	}
	public CardColor getColour(){
		return colour;
	}
	public CardNumber getNumber(){
		return number;
	}
	public int getID(){
		return (13* colour.getValue() + number.getValue());
	}
	public String toString(){
		String str = "";
		
		switch (colour){
			case HEARTS: str = " of Hearts";break;
			case DIMONDS: str = " of Diomants";break;
			case CLUBS: str = " of Clubs";break;
			case SPADES: str = " of Spades";break;
			case JOKER: return "Joker";
		default:return "unknown card";
		}
		switch (number){
			case ACE: return  "Ace" + str;
			case JACK: return  "Jack" + str;
			case QUEEN: return  "Queen" + str;
			case KING: return "King" + str;
		default: return (number.getValue()+2) + str;
		}
	}
}
