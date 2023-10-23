package yatzy.major;

import java.util.Comparator;
import java.util.Map;

import yatzy.Party;

/**
 * Some major party is a combination of others party rule This interface will
 * help you to implement N of a kind rule
 */
public interface CanBeNumberOfAKind {

	/**
	 * Check if N dice showing the same number and return the number
	 * 
	 * @param party
	 * @param kindNumber can be 3 or 4
	 * @return
	 */
	default Integer isNumberOfKind(Party party, int kindNumber) {
		return party.getCountsMap().entrySet().stream().filter(e -> e.getValue() >= kindNumber).map(Map.Entry::getKey)
				.max(Comparator.naturalOrder()).orElse(0);
	}

}
