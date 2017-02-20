package CardGame.state.objects.enums;

/**
 * Created by stijn on 2/19/17.
 */
public enum CardColor {

    HEARTS(0),
    DIMONDS(1),
    CLUBS(2),
    SPADES(3),
    JOKER(4),
    NONE(5)
    ;

    private int value;

    CardColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static CardColor fromInt(int i){
        switch(i){
            case 0: return CardColor.HEARTS;
            case 1: return CardColor.DIMONDS;
            case 2: return CardColor.CLUBS;
            case 3: return CardColor.SPADES;
            case 4: return CardColor.JOKER;
            default: return CardColor.NONE;
        }
    }
}
