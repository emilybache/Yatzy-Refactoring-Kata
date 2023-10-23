package yatzy.major;

import java.util.List;

import yatzy.Dice;
import yatzy.Party;

public class TwoPairs extends Party implements CanHavePairs {

	public TwoPairs(List<Dice> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		List<Integer> pairs = findPairs(this);
		if (hasAtLeastTwoPairs(pairs)) {
			return pairs.stream().mapToInt(pair -> pair * 2).sum();
		}
		return 0;
	}

	private static boolean hasAtLeastTwoPairs(List<Integer> pairs) {
		return pairs.size() >= 2;
	}

}
