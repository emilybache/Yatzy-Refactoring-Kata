package yatzykata.yatzy.domain.category;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.roll.model.Roll;
import yatzykata.yatzy.utils.IntComparisonOperator;

public class MatchingDiceHelper {
  public static Stream<Integer> getDiceByExactlyANumberOfTimesADieIsFound(
      Roll roll, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        roll, numberOfTimesDieIsFound, IntComparisonOperator.EQUAL);
  }

  public static Stream<Integer> getDiceByAtLeastANumberOfTimesADieIsFound(
      Roll roll, Integer numberOfTimesDieIsFound) {
    return getDiceByNumberOfTimesDieIsFound(
        roll, numberOfTimesDieIsFound, IntComparisonOperator.GREATER_THAN_OR_EQUAL);
  }

  private static Stream<Integer> getDiceByNumberOfTimesDieIsFound(
      Roll roll, Integer numberOfTimesDieIsFound, IntComparisonOperator intComparisonOperator) {
    return getDiceAndNumberOfTimesEachDieIsFound(roll).entrySet().stream()
        .filter(
            dieAndNumberOfTimesFound ->
                intComparisonOperator.compare(
                    dieAndNumberOfTimesFound.getValue(), numberOfTimesDieIsFound))
        .map(Map.Entry::getKey);
  }

  private static Map<Integer, Integer> getDiceAndNumberOfTimesEachDieIsFound(Roll roll) {
    return roll.diceAsIntegers().stream()
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
