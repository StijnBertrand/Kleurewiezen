package CardGame.state.objects.tables;

import CardGame.state.objects.Deck;
import CardGame.state.objects.Player;
import CardGame.state.objects.Slag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stijn on 4/17/17.
 */
public class SlagTable extends Table {

    //keeps track of the players their slagen
    private List<Slag>[] slagen;
    private Slag currSlag;
    private Slag prevSlag;

    public SlagTable(Deck deck, Player... players){
        super(deck, players);

        //let the player know what table they are at
        for(int i=0;i<players.length;i++){
            players[i].setTable(this,i);
        }

        //initrialize the Slagen Array
        slagen = new List[players.length];
        for(int i= 0;i< slagen.length;i++)slagen[i]= new ArrayList<Slag>();
        currSlag = new Slag(players.length);
    }

    //geters and setters
    public Slag getCurrSlag(){
        return currSlag;
    }

    public Slag getPrevSlag(){
        return prevSlag;
    }

    //methods to handle the flow of the game
    public void letPlayerPlay(int player){
        currSlag.playCard(players[player].letPlay(),player);
    }

    public void appointSlag(int winner) {
        slagen[winner].add(currSlag);
        newSlag();
    }


    //private methods
    private void collectCards(){
        for(List<Slag> a :slagen ){
            while(!a.isEmpty()){
                Slag s = a.get(0);
                for(int i = 0;i<getAmountOfPlayers();i++){
                    getDeck().addCard(s.getCard((s.getStarter()+i)%getAmountOfPlayers()));
                }
                a.remove(0);
            }
        }
        //todo: collect cards still in the players hands
    }

    //resets the board for a new round
    public void reset(){
        collectCards();
        this.prevSlag = null;
    }

    private void newSlag(){
        prevSlag = currSlag;
        currSlag = new Slag(getAmountOfPlayers());
    }


}
