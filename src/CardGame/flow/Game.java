package CardGame.flow;

import CardGame.state.objects.tables.Table;

/**
 * Created by stijn on 2/20/17.
 */
public abstract class Game <T extends Table> {

    protected T table;

    public Game(T table){
        this.table = table;
    }

    public void start(){
        while(!table.isFinished()){
            playRound();
        }
    }

    protected abstract void playRound();

    public T getTable(){
        return table;
    }

}
