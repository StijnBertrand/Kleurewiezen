package CardGame;

public class Card {

	private CardColor colour;
	private int number;
	
	public Card(int colour, int number){
		this.colour = CardColor.fromInt(colour);
		this.number = number;
	}
	public CardColor getColour(){
		return colour;
	}
	public int getNumber(){
		return number;
	}
	public int getID(){
		return (13* colour.getValue() + number);
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
		case 0: return  "Ace" + str;
		case 10: return  "Jack" + str;
		case 11: return  "Queen" + str;
		case 12: return "King" + str;
		default: return (number+2) + str;
		}
	}
}
