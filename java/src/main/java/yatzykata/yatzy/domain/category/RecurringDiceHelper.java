package yatzykata.yatzy.domain.category;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import yatzykata.yatzy.domain.roll.model.Roll;
import yatzykata.yatzy.utils.IntComparisonOperator;

public final class RecurringDiceHelper {

  public static Stream<Integer> getDiceByExactRecurrence(Roll roll, int expectedDieRecurrence) {
    return getDiceByRecurrence(roll, expectedDieRecurrence, IntComparisonOperator.EQUAL);
  }

  public static Stream<Integer> getDiceByExactRecurrenceOrMore(
      Roll roll, int expectedDieRecurrence) {
    return getDiceByRecurrence(
        roll, expectedDieRecurrence, IntComparisonOperator.GREATER_THAN_OR_EQUAL);
  }

  private static Stream<Integer> getDiceByRecurrence(
      Roll roll, int expectedDieRecurrence, IntComparisonOperator dieComparator) {
    return getDiceAndRecurrence(roll).entrySet().stream()
        .filter(
            dieAndRecurrence ->
                dieComparator.compare(dieAndRecurrence.getValue(), expectedDieRecurrence))
        .map(Map.Entry::getKey);
  }

  private static Map<Integer, Integer> getDiceAndRecurrence(Roll roll) {
    return roll.diceAsIntegers().stream()
        .collect(
            Collectors.groupingBy(
                Function.identity(),
                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
  }

  public static int getScoreForRecurringDice(
      Stream<Integer> recurringDice, int expectedDieRecurrence) {
    return recurringDice.reduce(0, (score, die) -> score + (die * expectedDieRecurrence));
  }
}
