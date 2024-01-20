package yatzykata.yatzy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.utils.IntComparisonOperator;

public class Yatzy {

  private static final int SCORE_ALL_DICE_ARE_EQUAL = 50;
  private static final int SCORE_OF_ZERO = 0;
  private static final int ROLL_PLACED_ON_ONES = 1;
  private static final int ROLL_PLACED_ON_TWOS = 2;
  private static final int ROLL_PLACED_ON_THREES = 3;
  private static final int ROLL_PLACED_ON_FOURS = 4;
  private static final int ROLL_PLACED_ON_FIVES = 5;
  private static final int ROLL_PLACED_ON_SIXES = 6;
  private static final int DIE_MATCH_TWO_TIMES = 2;
  private static final int DIE_MATCH_THREE_TIMES = 3;
  private static final int DIE_MATCH_FOUR_TIMES = 4;
  private static final int LIMIT_TO_ONE_PAIR = 1;
  private static final int LIMIT_TO_TWO_PAIRS = 2;

  public static Integer chance(Integer... dice) {
    return Stream.of(dice).reduce(0, Integer::sum);
  }

  public static Integer yatzy(Integer... dice) {
    return areAllDiceEqual(dice) ? SCORE_ALL_DICE_ARE_EQUAL : SCORE_OF_ZERO;
  }

  private static boolean areAllDiceEqual(Integer... dice) {
    return Stream.of(dice).distinct().count() <= 1;
  }

  public static Integer ones(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_ONES);
  }

  public static Integer twos(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_TWOS);
  }

  public static Integer threes(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_THREES);
  }

  public static Integer fours(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_FOURS);
  }

  public static Integer fives(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_FIVES);
  }

  public static Integer sixes(Integer... dice) {
    return getScoreDicePlacedOn(dice, ROLL_PLACED_ON_SIXES);
  }

  public static Integer getScoreDicePlacedOn(Integer[] dice, Integer placedOn) {
    return Stream.of(dice).filter(die -> die.equals(placedOn)).reduce(0, Integer::sum);
  }

  public static Integer pair(Integer... dice) {
    Stream<Integer> diceFoundMultipleTimes =
        getDiceByExactlyANumberOfTimesADieIsFound(dice, DIE_MATCH_TWO_TIMES)
            .sorted(Comparator.reverseOrder())
            .limit(LIMIT_TO_ONE_PAIR);

    return getScoreForDiceThatMatchMultipleTimes(diceFoundMultipleTimes, DIE_MATCH_TWO_TIMES);
  }

  public static Integer twoPairs(Integer... dice) {
    Stream<Integer> diceFoundMultipleTimes =
        getDiceByAtLeastANumberOfTimesADieIsFound(dice, DIE_MATCH_TWO_TIMES)
            .limit(LIMIT_TO_TWO_PAIRS);

    return getScoreForDiceThatMatchMultipleTimes(diceFoundMultipleTimes, DIE_MATCH_TWO_TIMES);
  }

  public static Integer threeOfAKind(Integer... dice) {
    Stream<Integer> diceFoundMultipleTimes =
        getDiceByAtLeastANumberOfTimesADieIsFound(dice, DIE_MATCH_THREE_TIMES);

    return getScoreForDiceThatMatchMultipleTimes(diceFoundMultipleTimes, DIE_MATCH_THREE_TIMES);
  }

  public static Integer fourOfAKind(Integer... dice) {
    Stream<Integer> diceFoundMultipleTimes =
        getDiceByAtLeastANumberOfTimesADieIsFound(dice, DIE_MATCH_FOUR_TIMES);

    return getScoreForDiceThatMatchMultipleTimes(diceFoundMultipleTimes, DIE_MATCH_FOUR_TIMES);
  }

  private static Stream<Integer> getDiceByExactlyANumberOfTimesADieIsFound(
      Integer[] dice, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        dice, numberOfTimesDieIsFound, IntComparisonOperator.EQUAL);
  }

  private static Stream<Integer> getDiceByAtLeastANumberOfTimesADieIsFound(
      Integer[] dice, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        dice, numberOfTimesDieIsFound, IntComparisonOperator.GREATER_THAN_OR_EQUAL);
  }

  private static Stream<Integer> getDiceByNumberOfTimesDieIsFound(
      Integer[] dice,
      Integer numberOfTimesDieIsFound,
      IntComparisonOperator intComparisonOperator) {
    return getDiceAndNumberOfTimesEachDieIsFound(dice).entrySet().stream()
        .filter(
            dieAndNumberOfTimesFound ->
                intComparisonOperator.compare(
                    dieAndNumberOfTimesFound.getValue(), numberOfTimesDieIsFound))
        .map(Map.Entry::getKey);
  }

  private static Map<Integer, Integer> getDiceAndNumberOfTimesEachDieIsFound(Integer[] dice) {
    return Arrays.stream(dice)
        .collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
  }

  private static Integer getScoreForDiceThatMatchMultipleTimes(
      Stream<Integer> diceFoundMultipleTimes, Integer numberOfTimesDieIsFound) {
    return diceFoundMultipleTimes.reduce(
        0, (score, die) -> score + (die * numberOfTimesDieIsFound));
  }

  public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
    int[] tallies;
    tallies = new int[6];
    tallies[d1 - 1] += 1;
    tallies[d2 - 1] += 1;
    tallies[d3 - 1] += 1;
    tallies[d4 - 1] += 1;
    tallies[d5 - 1] += 1;
    if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1)
      return 15;
    return 0;
  }

  public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
    int[] tallies;
    tallies = new int[6];
    tallies[d1 - 1] += 1;
    tallies[d2 - 1] += 1;
    tallies[d3 - 1] += 1;
    tallies[d4 - 1] += 1;
    tallies[d5 - 1] += 1;
    if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1)
      return 20;
    return 0;
  }

  public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
    int[] tallies;
    boolean _2 = false;
    int i;
    int _2_at = 0;
    boolean _3 = false;
    int _3_at = 0;

    tallies = new int[6];
    tallies[d1 - 1] += 1;
    tallies[d2 - 1] += 1;
    tallies[d3 - 1] += 1;
    tallies[d4 - 1] += 1;
    tallies[d5 - 1] += 1;

    for (i = 0; i != 6; i += 1)
      if (tallies[i] == 2) {
        _2 = true;
        _2_at = i + 1;
      }

    for (i = 0; i != 6; i += 1)
      if (tallies[i] == 3) {
        _3 = true;
        _3_at = i + 1;
      }

    if (_2 && _3) return _2_at * 2 + _3_at * 3;
    else return 0;
  }
}
