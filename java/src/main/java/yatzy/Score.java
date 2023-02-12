package yatzy;

import java.util.Objects;

public class Score {

    private final Integer score;

    private Score(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public static Score of(Integer score){
        return new Score(score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Score{" +
            "score=" + score +
            '}';
    }
}
