package yatzy.major;

import java.util.List;

import yatzy.Dice;
import yatzy.Party;

public class Chance extends Party {

	public Chance(List<Dice> dices) {
		super(dices);
	}

	@Override
	public int calculateScore() {
		return this.dices.stream().mapToInt(Dice::getValue).sum();
	}

}
