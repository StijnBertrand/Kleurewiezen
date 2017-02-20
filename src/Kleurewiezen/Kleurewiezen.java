package Kleurewiezen;

import CardGame.flow.Game;
import CardGame.flow.modules.DistributeCards;
import CardGame.flow.modules.PlayRounds;
import CardGame.state.objects.Player;
import CardGame.state.objects.Table;
import Kleurewiezen.modules.PrepareNextRound;


/**
 * Created by stijn on 2/20/17.
 */
public class Kleurewiezen extends Game{


    public Kleurewiezen(Player player1, Player player2, Player player3, Player player4){
        super(new Table());
        getTable().setPlayer(player1,0);
        getTable().setPlayer(player2,1);
        getTable().setPlayer(player3,2);
        getTable().setPlayer(player4,3);

        //distribute the cards
        addModule(new DistributeCards());

        //decide what will be played

        //decide starter

        //play Rounds
        addModule(new PlayRounds());
        //calculate score
        //TODO:
        //prepare for next round
        addModule(new PrepareNextRound());
    }

}
