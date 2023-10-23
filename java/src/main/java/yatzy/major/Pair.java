package yatzy.major;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import yatzy.Dice;
import yatzy.Party;

public class Pair extends Party {

	public Pair(List<Dice> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		return getCountsMap().entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).map(diceNumber -> diceNumber * 2).orElse(0);
	}

}
