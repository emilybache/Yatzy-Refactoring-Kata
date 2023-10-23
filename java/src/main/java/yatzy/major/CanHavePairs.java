package yatzy.major;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;

import yatzy.Party;

/**
 * Some major party is a combination of others party rule This interface will
 * help you to implement two pairs rule
 */
public interface CanHavePairs {

	/**
	 * Check if two dice showing the same number and return them
	 * 
	 * @param party
	 * @return
	 */
	default List<Integer> findPairs(Party party) {
		return party.getCountsMap().entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey)
				.collect(toList());
	}

}
