package yatzy;

import java.util.Objects;

public class Dice implements Comparable<Dice> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return Objects.equals(value, dice.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Dice dice) {
        return this.getValue().compareTo(dice.getValue());
    }
}
