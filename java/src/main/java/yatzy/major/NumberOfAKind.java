package yatzy.major;

import java.util.List;

import yatzy.Dice;
import yatzy.Party;

public class NumberOfAKind extends Party implements CanBeNumberOfAKind {

	protected int number;

	public NumberOfAKind(List<Dice> dices, int number) {
		super(dices);
		this.number = number;
	}

	@Override
	public int calculateScore() {
		return isNumberOfKind(this, number) * number;
	}

}
