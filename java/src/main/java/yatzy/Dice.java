package yatzy;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Dice {

	int value;

	public Dice(int value) {
		if (value < 1 || value > 6) {
			throw new IllegalArgumentException("Invalid dice value! Value should between 1 and 6!");
		}
		this.value = value;
	}

}
