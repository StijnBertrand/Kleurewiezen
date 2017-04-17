package HartenJagen;

import CardGame.flow.Game;
import CardGame.helpers.CardDistributer;
import CardGame.helpers.CardsPlayer;
import CardGame.helpers.slagwinnerdeciders.HighestCardSameColour;
import CardGame.state.objects.Player;
import CardGame.state.objects.tables.Table;
import HartenJagen.helpers.NextRoundPreparer;
import HartenJagen.helpers.StarterDecider;
import HartenJagen.objects.HJTable;
import HartenJagen.helpers.CardPasser;

/**
 * Created by stijn on 2/18/17.
 */
public class HartenJagen extends Game {

    private CardDistributer cardDistributer = new CardDistributer();
    private CardPasser cardPasser = new CardPasser();
    private StarterDecider starterDecider = new StarterDecider();
    private CardsPlayer<Table> cardsPlayer = new CardsPlayer<>();
    private NextRoundPreparer nextRoundPreparer = new NextRoundPreparer();

    public HartenJagen(Player player1, Player player2, Player player3, Player player4){
        super(new HJTable(player1,player2,player3,player4));
    }

    @Override
    public void playRound() {
        //distribute the cards
        cardDistributer.distributeCards(table,4,4,5);
        //Let the players pass on their cards
        cardPasser.passOnCards(table);
        //decide who wil start the game
        starterDecider.decideStarter(table);
        //let the players play their cards
        cardsPlayer.playAllCards(table, new HighestCardSameColour());
        //calculate the score

        //TODO:
        //prepare for the next round
        nextRoundPreparer.prepareNextRound(table);
    }



}
