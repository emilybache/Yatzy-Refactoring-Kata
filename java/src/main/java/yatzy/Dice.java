package yatzy;

public class Dice {

    private final Integer value;

    private Dice(Integer value) {
        if (value < 1 || value > 6)
            throw new IllegalArgumentException("dice value must be between 1 and 6");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Dice of(Integer value){
        return new Dice(value);
    }
}
