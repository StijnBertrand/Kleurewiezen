package HartenJagen;

import CardGame.Player;

/**
 * Created by stijn on 2/18/17.
 */
public class HartenJagen{

    private HJTable table;
    private CompositeModule module;

    public HartenJagen(Player player1,Player player2,Player player3,Player player4){
        this.table = new HJTable();
        this.table.setPlayer(player1,0);
        this.table.setPlayer(player2,1);
        this.table.setPlayer(player3,2);
        this.table.setPlayer(player4,3);
        this.module = new CompositeModule();

        //distribute the cards
        this.module.addModule(new DistributeCards());
        //pass on cards
        this.module.addModule(new PassOnCards());
        //decide starter
        this.module.addModule(new DecideStarter());
        //play Rounds
        this.module.addModule(new PlayRounds());
        //calculate score

        //prepare for next round
        this.module.addModule(new PrepareNextRound());
    }

    public void start() {
        while(!table.isFinished()){
            module.execute(this.table);
        }
    }
}
