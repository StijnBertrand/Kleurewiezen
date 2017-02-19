package HartenJagen;

import CardGame.Card;
import CardGame.Table;

/**
 * Created by stijn on 2/19/17.
 */
public class PassOnCards extends Module {


    @Override
    public void execute(Table table) {
        int passOnTo = ((HJTable)table).getPassCardsTo();
        if(passOnTo == 3)return;

        Card[][] cards= new Card[4][3];

        Thread thread1 = new Thread(() -> cards[0] = ((HJPlayerInterface)table.getPlayer(0)).letPassOnCards(3));
        Thread thread2 = new Thread(() -> cards[1] = ((HJPlayerInterface)table.getPlayer(1)).letPassOnCards(3));
        Thread thread3 = new Thread(() -> cards[2] = ((HJPlayerInterface)table.getPlayer(2)).letPassOnCards(3));
        Thread thread4 = new Thread(() -> cards[3] = ((HJPlayerInterface)table.getPlayer(3)).letPassOnCards(3));

        try {
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(passOnTo == 0){
            //to the left
            for(int i = 0;i<4;i++ ){
                for(Card card: cards[receiveCardsFromPlayer(i,passOnTo)]){
                    table.getPlayer(i).giveCard(card);
                }
            }
        }
    }

    private int receiveCardsFromPlayer(int receivingPlayer, int passOnTo){
        switch(passOnTo){
            case 0:{
                return (receivingPlayer + 3)%4;
            }
            case 1:{
                return (receivingPlayer + 1)%4;
            }
            case 2:{
                return (receivingPlayer + 2)%4;
            }
            default:{
                return receivingPlayer;
            }
        }
    }



}
