package yatzy;

import static java.util.stream.Collectors.counting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Party {

	protected final List<Dice> dices;

	/**
	 * Return dice value recurrence of the party
	 * 
	 * @return
	 */
	protected Map<Integer, Long> getCountsMap() {
		return dices.stream().collect(Collectors.groupingByConcurrent(Dice::getValue, counting()));
	}

	public abstract int calculateScore();

}