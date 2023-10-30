import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Yatzy {

    private final int[] dice;

    public Yatzy(int[] dice) {
        this.dice = Arrays.stream(dice).toArray();
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        return Arrays.stream(dice).distinct().count() == 1 ? 50 : 0;
    }

    public int ones() {
        return countScoreOf(1);
    }

    public int twos() {
        return countScoreOf(2);
    }

    public int threes() {
        return countScoreOf(3);
    }

    public int fours() {
        return countScoreOf(4);
    }

    public int fives() {
        return countScoreOf(5);
    }

    public int sixes() {
        return countScoreOf(6);
    }

    public int pair() {
        return getScoreByOccurrences(2);
    }

    public int twoPair() {
        return Arrays.stream(dice)
            .distinct()
            .filter(die -> this.countDieOccurrences(die) >= 2)
            .sum() * 2;
    }

    public int threeOfAKind() {
        return getScoreByOccurrences(3);
    }

    public int fourOfAKind() {
        return getScoreByOccurrences(4);
    }

    public int smallStraight() {
        return isSmallStraight() ? 15 : 0;
    }

    public int largeStraight() {
        return isLargeStraight() ? 20 : 0;
    }

    public int fullHouse() {
        return pair() != 0 && threeOfAKind() != 0 ? chance() : 0;
    }

    public int countScoreOf(int value) {
        return (int) (Arrays.stream(dice).filter(currentDie -> currentDie == value).count() * value);
    }

    private Integer getScoreByOccurrences(int occurrences) {
        return Arrays.stream(dice)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .filter(die -> countDieOccurrences(die) >= occurrences)
            .findFirst()
            .map(die -> die * occurrences)
            .orElse(0);
    }

    private int countDieOccurrences(int die) {
        return (int) Arrays.stream(dice).filter(currentDie -> currentDie == die).count();
    }

    private List<Integer> getSortedList() {
        return Arrays.stream(dice)
            .boxed()
            .sorted()
            .collect(toList());
    }

    private boolean isSmallStraight() {
        return getSortedList()
            .equals(asList(1, 2, 3, 4, 5));
    }

    private boolean isLargeStraight() {
        return getSortedList()
            .equals(asList(2, 3, 4, 5, 6));
    }
}