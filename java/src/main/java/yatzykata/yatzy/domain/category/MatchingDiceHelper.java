package yatzykata.yatzy.domain.category;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.utils.IntComparisonOperator;

public class MatchingDiceHelper {
  public static Stream<Integer> getDiceByExactlyANumberOfTimesADieIsFound(
      List<Integer> dice, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        dice, numberOfTimesDieIsFound, IntComparisonOperator.EQUAL);
  }

  public static Stream<Integer> getDiceByAtLeastANumberOfTimesADieIsFound(
      List<Integer> dice, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        dice, numberOfTimesDieIsFound, IntComparisonOperator.GREATER_THAN_OR_EQUAL);
  }

  private static Stream<Integer> getDiceByNumberOfTimesDieIsFound(
      List<Integer> dice,
      Integer numberOfTimesDieIsFound,
      IntComparisonOperator intComparisonOperator) {
    return getDiceAndNumberOfTimesEachDieIsFound(dice).entrySet().stream()
        .filter(
            dieAndNumberOfTimesFound ->
                intComparisonOperator.compare(
                    dieAndNumberOfTimesFound.getValue(), numberOfTimesDieIsFound))
        .map(Map.Entry::getKey);
  }

  private static Map<Integer, Integer> getDiceAndNumberOfTimesEachDieIsFound(List<Integer> dice) {
    return dice.stream()
        .collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
  }

  public static Integer getScoreForDiceThatMatchMultipleTimes(
      Stream<Integer> diceFoundMultipleTimes, Integer numberOfTimesDieIsFound) {
    return diceFoundMultipleTimes.reduce(
        0, (score, die) -> score + (die * numberOfTimesDieIsFound));
  }
}
