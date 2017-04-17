package CardGame.helpers.slagwinnerdeciders;

import CardGame.state.objects.tables.Table;

/**
 * Created by stijn on 4/16/17.
 */
public interface SlagWinnerDecider<T extends Table>{
    public abstract int decideWinner( T table);
}