package com.wejden.kata.yatzy.game;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.wejden.kata.yatzy.constants.YatzyConstants;
import com.wejden.kata.yatzy.model.DiceRoll;

public class Yatzy {
	
	protected DiceRoll diceRoll;

	public static int chance(DiceRoll diceRoll)
    {
	    if (diceRoll == null || diceRoll.getAllDice().length != 5) {
	        throw new IllegalArgumentException("Le lancer de dés est invalide");
	    }
	    return Arrays.stream(diceRoll.getAllDice()).sum();
    }
	
	private static int sumOfSpecificNumber(DiceRoll diceRoll, int number) {
	    return Arrays.stream(diceRoll.getAllDice())
	                 .filter(die -> die == number)
	                 .sum();
	}

    public static int yatzy(DiceRoll diceRoll)
    {
        long count = Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(v -> v == 5)
                .count();
        	return count > 0 ?  YatzyConstants.YATZY_SCORE.getValue() : 0;
    }

    public static int ones(DiceRoll diceRoll) {
        return sumOfSpecificNumber(diceRoll, 1);
    }

    public static int twos(DiceRoll diceRoll) {
    	return sumOfSpecificNumber(diceRoll, 2);
    }

    public static int threes(DiceRoll diceRoll) {
    	return sumOfSpecificNumber(diceRoll, 3);
    }

    public static int fours(DiceRoll diceRoll) {
    	return sumOfSpecificNumber(diceRoll, 4);
    }

    public static int fives(DiceRoll diceRoll) {
    	return sumOfSpecificNumber(diceRoll, 5);
    }

    public static int sixes(DiceRoll diceRoll){
    	return sumOfSpecificNumber(diceRoll, 6);
    }

    public static int score_pair(DiceRoll diceRoll)
    {
        return Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .mapToInt(Map.Entry::getKey)
                .max()
                .orElse(0) * 2;
    }

    public static int two_pair(DiceRoll diceRoll)
    {
        return Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 2)
                .sorted(Map.Entry.<Integer, Long>comparingByKey().reversed())
                .limit(2)
                .mapToInt(e -> e.getKey() * 2)
                .sum();
    }

    public static int four_of_a_kind(DiceRoll diceRoll)
    {
        return Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 4)
                .mapToInt(e -> e.getKey() * 4)
                .findFirst()
                .orElse(0);
    }

    public static int three_of_a_kind(DiceRoll diceRoll)
    {
        return Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() >= 3)
                .mapToInt(e -> e.getKey() * 3)
                .findFirst()
                .orElse(0);
    }

    public static int smallStraight(DiceRoll diceRoll)
    {
        boolean hasSmallStraight = Arrays.stream(diceRoll.getAllDice())
                .sorted()
                .distinct()
                .limit(5)
                .sequential()
                .reduce(0, (a, b) -> (a == b - 1) ? b : -1) == 5;
        return hasSmallStraight ? YatzyConstants.SMALL_STRAIGHT_SCORE.getValue() : 0;
    }

    public static int largeStraight(DiceRoll diceRoll)
    {
        boolean hasLargeStraight = Arrays.stream(diceRoll.getAllDice())
                .sorted()
                .distinct()
                .limit(5)
                .sequential()
                .reduce(1, (a, b) -> (a == b - 1) ? b : -1) == 6;
        return hasLargeStraight ? YatzyConstants.LARGE_STRAIGHT_SCORE.getValue() : 0;
    }

    public static int fullHouse(DiceRoll diceRoll)
    {
        Map<Integer, Long> counts = Arrays.stream(diceRoll.getAllDice())
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		boolean hasThreeOfAKind = counts.containsValue(3L);
		boolean hasPair = counts.values().stream().anyMatch(count -> count == 2);
		
		if (hasThreeOfAKind && hasPair) {
		int threeOfAKindValue = counts.entrySet().stream()
		                .filter(entry -> entry.getValue() == 3)
		                .mapToInt(Map.Entry::getKey)
		                .findFirst()
		                .orElse(0);
		
		int pairValue = counts.entrySet().stream()
		        .filter(entry -> entry.getValue() == 2)
		        .mapToInt(Map.Entry::getKey)
		        .findFirst()
		        .orElse(0);
		
		return threeOfAKindValue * 3 + pairValue * 2;
		}
		
		return 0;
    }
}



