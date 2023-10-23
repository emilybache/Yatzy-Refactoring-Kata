package yatzy.major;

import yatzy.Party;

/**
 * Some major party is a combination of others party rule This interface will
 * help you to implement Yatzy rule
 */
public interface CanBeYatzi {

	/**
	 * Check if all five dice have the same number
	 * 
	 * @param party
	 * @return
	 */
	default boolean isYatzi(Party party) {
		return party.getCountsMap().entrySet().stream().anyMatch(e -> e.getValue() == 5);
	}

}
