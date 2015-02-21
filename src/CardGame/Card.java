package CardGame;

public class Card {

	private int colour;
	private int number;
	
	public Card(int colour, int number){
		this.colour = colour;
		this.number = number;
	}
	public int getColour(){
		return colour;
	}
	public int getNumber(){
		return number;
	}
	public int getID(){
		return (13* colour + number);
	}
	public String toString(){
		String str = "";
		
		switch (colour){
		case 0: str = " of Hearts";break;
		case 1: str = " of Diomants";break;
		case 2: str = " of Clubs";break;
		case 3: str = " of Spades";break;		
		case 4: return "Joker";
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
