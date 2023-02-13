package yatzy;

import java.util.Objects;

public class Score {

    private final Integer value;

    private Score(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Score of(Integer value){
        return new Score(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return Objects.equals(value, score1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Score{" +
            "score=" + value +
            '}';
    }
}
