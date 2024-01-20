package yatzykata.yatzy;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.CategoryFactoryProvider;
import yatzykata.yatzy.domain.category.CategoryType;
import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.roll.model.Roll;
import yatzykata.yatzy.utils.IntComparisonOperator;

public class YatzyGame {
  private static final int SCORE_OF_ZERO = 0;
  private static final int SCORE_SMALL_STRAIGHT = 15;
  private static final int SCORE_LARGE_STRAIGHT = 20;
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
  private static final int DIE_READ_ONE = 1;
  private static final int DIE_READ_TWO = 2;
  private static final int DIE_READ_THREE = 3;
  private static final int DIE_READ_FOUR = 4;
  private static final int DIE_READ_FIVE = 5;
  private static final int DIE_READ_SIX = 6;
  private static final int ONLY_ONE_MATCH_WAS_FOUND = 1;

  private final Category category;

  private static final int[] DICE_SMALL_STRAIGHT = {
    DIE_READ_ONE, DIE_READ_TWO, DIE_READ_THREE, DIE_READ_FOUR, DIE_READ_FIVE
  };
  private static final int[] DICE_LARGE_STRAIGHT = {
    DIE_READ_TWO, DIE_READ_THREE, DIE_READ_FOUR, DIE_READ_FIVE, DIE_READ_SIX
  };

  public YatzyGame(CategoryType categoryType, int... dice) {
    CategoryFactoryProvider categoryFactoryProvider = new CategoryFactoryProvider();
    Roll roll = new Roll(Arrays.stream(dice).boxed().collect(Collectors.toList()));
    this.category = categoryFactoryProvider.getCategoryFactory(categoryType).createCategory(roll);
  }

  public int score() {
    return category.calculateScore();
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

  public static Integer smallStraight(Integer... dice) {
    return getScoreForStraight(dice, DICE_SMALL_STRAIGHT, SCORE_SMALL_STRAIGHT);
  }

  public static Integer largeStraight(Integer... dice) {
    return getScoreForStraight(dice, DICE_LARGE_STRAIGHT, SCORE_LARGE_STRAIGHT);
  }

  private static Integer getScoreForStraight(
      Integer[] dice, int[] diceInStraight, Integer scoreForStraight) {
    List<Integer> allDice = Arrays.asList(dice);
    List<Integer> allDiceInStraight = Arrays.stream(diceInStraight).boxed().toList();
    return new HashSet<>(allDice).containsAll(allDiceInStraight) ? scoreForStraight : SCORE_OF_ZERO;
  }

  public static Integer fullHouse(Integer... dice) {
    return getScoreForDiceMatchingWithASingleResult(dice, DIE_MATCH_TWO_TIMES)
        + getScoreForDiceMatchingWithASingleResult(dice, DIE_MATCH_THREE_TIMES);
  }

  private static Integer getScoreForDiceMatchingWithASingleResult(
      Integer[] dice, Integer numberOfTimesDieIsFound) {
    Supplier<Stream<Integer>> streamSupplierDiceFoundMultipleTimes =
        () -> getDiceByExactlyANumberOfTimesADieIsFound(dice, numberOfTimesDieIsFound);

    if (streamSupplierDiceFoundMultipleTimes.get().count() == ONLY_ONE_MATCH_WAS_FOUND) {
      return getScoreForDiceThatMatchMultipleTimes(
          streamSupplierDiceFoundMultipleTimes.get(), numberOfTimesDieIsFound);
    } else {
      return SCORE_OF_ZERO;
    }
  }
}
