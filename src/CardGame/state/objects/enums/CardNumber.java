package CardGame.state.objects.enums;

/**
 * Created by stijn on 2/20/17.
 */
public enum CardNumber {

    ACE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12),
    NONE(13);

    private int value;

    CardNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static CardNumber fromInt(int i){
        switch(i){
            case 0: return CardNumber.ACE;
            case 1: return CardNumber.TWO;
            case 2: return CardNumber.THREE;
            case 3: return CardNumber.FOUR;
            case 4: return CardNumber.FIVE;
            case 5: return CardNumber.SIX;
            case 6: return CardNumber.SEVEN;
            case 7: return CardNumber.EIGHT;
            case 8: return CardNumber.NINE;
            case 9: return CardNumber.TEN;
            case 10: return CardNumber.JACK;
            case 11: return CardNumber.QUEEN;
            case 12: return CardNumber.KING;

            default: return CardNumber.NONE;
        }
    }


}
