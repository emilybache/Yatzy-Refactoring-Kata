package yatzy.factory;

import java.util.List;

import yatzy.Category;
import yatzy.Dice;
import yatzy.Party;
import yatzy.minor.Minor;

public class PartyFactory {

	private List<Dice> dices;

	public PartyFactory(Dice d1, Dice d2, Dice d3, Dice d4, Dice d5) {
		this.dices = List.of(d1, d2, d3, d4, d5);
	}

	public Party createParty(Category category) {
		if (category.equals(Category.ONES)) {
			return new Minor(this.dices, 1);
		}
		if (category.equals(Category.TWOS)) {
			return new Minor(this.dices, 2);
		}
		if (category.equals(Category.THREES)) {
			return new Minor(this.dices, 3);
		}
		if (category.equals(Category.FOURS)) {
			return new Minor(this.dices, 4);
		}
		if (category.equals(Category.FIVES)) {
			return new Minor(this.dices, 5);
		}
		if (category.equals(Category.SIXES)) {
			return new Minor(this.dices, 6);
		}
		return null;
	}

}