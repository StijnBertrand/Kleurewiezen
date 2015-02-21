package CardGame;

public class DeckFactory {
	private static DeckFactory factory = new DeckFactory();
	
	
	public static DeckFactory getInstance(){
		return factory;
	}
	
	private DeckFactory(){
			
	}
	public Deck troelTest(){
		Deck d = new Deck();
			
		d.addCard(new Card(0,0));	
		d.addCard(new Card(3,0));
		d.addCard(new Card(2,0));
		d.addCard(new Card(1,0));
		
		d.addCard(new Card(0,1));	
		d.addCard(new Card(0,2));	
		d.addCard(new Card(0,3));	
		d.addCard(new Card(0,4));
		
		d.addCard(new Card(0,5));	
		d.addCard(new Card(0,6));	
		d.addCard(new Card(0,7));	
		d.addCard(new Card(0,8));
		
		d.addCard(new Card(0,9));	
		d.addCard(new Card(0,10));	
		d.addCard(new Card(0,11));
		d.addCard(new Card(1,1));
		
		
		d.addCard(new Card(0,12));	
		d.addCard(new Card(1,2));	
		d.addCard(new Card(1,3));	
		d.addCard(new Card(1,4));
		
		d.addCard(new Card(1,5));	
		d.addCard(new Card(1,6));	
		d.addCard(new Card(1,7));	
		d.addCard(new Card(1,8));	
		
		d.addCard(new Card(1,9));	
		d.addCard(new Card(1,10));	
		d.addCard(new Card(1,11));	
		d.addCard(new Card(1,12));	

		d.addCard(new Card(2,1));	
		d.addCard(new Card(2,2));	
		d.addCard(new Card(2,3));	
		d.addCard(new Card(2,4));
		
		
		d.addCard(new Card(2,5));	
		d.addCard(new Card(2,6));	
		d.addCard(new Card(2,7));	
		d.addCard(new Card(2,8));	
		d.addCard(new Card(2,9));	
		
		d.addCard(new Card(2,10));	
		d.addCard(new Card(2,11));	
		d.addCard(new Card(2,12));	
		d.addCard(new Card(3,1));	
		d.addCard(new Card(3,2));	
		
		d.addCard(new Card(3,3));	
		d.addCard(new Card(3,4));	
		d.addCard(new Card(3,5));	
		d.addCard(new Card(3,6));	
		d.addCard(new Card(3,7));	
		
		d.addCard(new Card(3,8));	
		d.addCard(new Card(3,9));	
		d.addCard(new Card(3,10));	
		d.addCard(new Card(3,11));	
		d.addCard(new Card(3,12));	
		return d;
		
		
		
	}
	
	
	
	
	public Deck getDeck52(){
		Deck d = new Deck();
		for(int colour = 0; colour != 4;colour++){
			for(int number = 0; number != 13;number++){
				d.addCard(new Card(colour,number));
			}
		}		
		return d;	
	}
	
	public Deck getDeck55(){
		Deck d = getDeck52();
		d.addCard(new Card(4,0));
		d.addCard(new Card(4,1));
		d.addCard(new Card(4,2));
		return d;
	}
}