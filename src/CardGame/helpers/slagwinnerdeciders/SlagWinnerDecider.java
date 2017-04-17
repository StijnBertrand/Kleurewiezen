package CardGame.helpers.slagwinnerdeciders;

import CardGame.state.objects.tables.SlagTable;

/**
 * Created by stijn on 4/16/17.
 */
public interface SlagWinnerDecider<T extends SlagTable>{
    public abstract int decideWinner( T table);
}