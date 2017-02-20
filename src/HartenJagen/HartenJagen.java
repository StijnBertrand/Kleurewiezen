package HartenJagen;

import CardGame.flow.Game;
import CardGame.flow.modules.DistributeCards;
import CardGame.flow.modules.PlayRounds;
import CardGame.state.objects.Player;
import HartenJagen.objects.HJPlayer;
import HartenJagen.objects.HJTable;
import HartenJagen.modules.DecideStarter;
import HartenJagen.modules.PassOnCards;
import HartenJagen.modules.PrepareNextRound;

/**
 * Created by stijn on 2/18/17.
 */
public class HartenJagen extends Game {

    public HartenJagen(Player player1, Player player2, Player player3, Player player4){
        super(new HJTable());
        getTable().setPlayer(player1,0);
        getTable().setPlayer(player2,1);
        getTable().setPlayer(player3,2);
        getTable().setPlayer(player4,3);

        //distribute the cards
        addModule(new DistributeCards());
        //pass on cards
        addModule(new PassOnCards());
        //decide starter
        addModule(new DecideStarter());
        //play Rounds
        addModule(new PlayRounds());
        //calculate score
        //TODO:
        //prepare for next round
        addModule(new PrepareNextRound());
    }

}
