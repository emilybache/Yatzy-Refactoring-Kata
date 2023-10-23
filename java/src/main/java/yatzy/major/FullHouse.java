package yatzy.major;

import java.util.List;

import yatzy.Dice;
import yatzy.Party;

public class FullHouse extends Party implements CanBeNumberOfAKind, CanBeYatzi, CanHavePairs {

	public FullHouse(List<Dice> dices) {
		super(dices);
	}

	/**
	 * Any set of three combined with a different pair
	 * 
	 * @return
	 */
	private boolean isAfullHouse() {
		return isNumberOfKind(this, 3) != 0 && !findPairs(this).isEmpty() && !isYatzi(this);
	}

	@Override
	public int calculateScore() {
		if (isAfullHouse()) {
			return this.dices.stream().mapToInt(Dice::getValue).sum();
		}
		return 0;
	}

}
