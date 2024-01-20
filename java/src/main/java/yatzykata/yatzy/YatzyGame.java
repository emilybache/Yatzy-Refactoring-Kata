package yatzykata.yatzy;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.category.CategoryFactoryProvider;
import yatzykata.yatzy.domain.category.model.Category;
import yatzykata.yatzy.domain.category.model.CategoryType;
import yatzykata.yatzy.domain.roll.model.Roll;
import yatzykata.yatzy.utils.IntComparisonOperator;

public class YatzyGame {
  private static final int SCORE_OF_ZERO = 0;
  private static final int DIE_MATCH_TWO_TIMES = 2;
  private static final int DIE_MATCH_THREE_TIMES = 3;
  private static final int DIE_MATCH_FOUR_TIMES = 4;
  private static final int LIMIT_TO_ONE_PAIR = 1;
  private static final int LIMIT_TO_TWO_PAIRS = 2;
  private static final int ONLY_ONE_MATCH_WAS_FOUND = 1;

  private final Category category;

  public YatzyGame(CategoryType categoryType, int... dice) {
    CategoryFactoryProvider categoryFactoryProvider = new CategoryFactoryProvider();
    Roll roll = new Roll(Arrays.stream(dice).boxed().collect(Collectors.toList()));
    this.category = categoryFactoryProvider.getCategoryFactory(categoryType).createCategory(roll);
  }

  public int score() {
    return category.calculateScore();
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
