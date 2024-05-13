package v2

import "github.com/emilybache/yatzy-refactoring-kata/yatzy"

type Yatzy struct{}

func (y *Yatzy) ValidCategories() []string {
	var cs []string
	for _, c := range yatzy.Categories.All() {
		cs = append(cs, c.String())
	}
	return cs
}

func (y *Yatzy) Score(dice []int, category string) int {
	c, _ := yatzy.ParseCategory(category)

	// calculate dice frequencies
	diceFrequencies := map[int]int{}
	for _, i := range y.dice_values() {
		diceFrequencies[i] = 0
	}
	for i := range dice {
		diceFrequencies[dice[i]] = diceFrequencies[dice[i]] + 1
	}

	// calculate the score
	var result int
	switch c {
	case yatzy.Categories.CHANCE:

		// chance sums the dice
		for _, d := range dice {
			result += d
		}

	case yatzy.Categories.YATZY:

		// score for yatzy if all dice are the same
		var yatzyResult = 0
		for _, v := range diceFrequencies {
			if v == 5 {
				yatzyResult = 50
			}
		}
		result = yatzyResult

	case yatzy.Categories.ONES:
		// sum all the ones
		result = diceFrequencies[1]

	case yatzy.Categories.TWOS:
		// sum all the twos
		result = diceFrequencies[2] * 2

	case yatzy.Categories.THREES:
		// sum all the threes
		result = diceFrequencies[3] * 3
		break

	case yatzy.Categories.FOURS:
		// sum all the fours
		result = diceFrequencies[4] * 4
		break

	case yatzy.Categories.FIVES:
		// sum all the fives
		result = diceFrequencies[5] * 5
		break

	case yatzy.Categories.SIXES:
		// sum all the sixes
		result = diceFrequencies[6] * 6
		break

	case yatzy.Categories.PAIR:

		// score pair if two dice are the same
		var pairResult = 0
		// score highest pair if there is more than one
		for _, i := range y.dice_values() {
			if diceFrequencies[i] >= 2 {
				pairResult = i * 2
				break
			}
		}
		result = pairResult
		break

	case yatzy.Categories.THREE_OF_A_KIND:

		// score if three dice are the same
		var threeKindResult = 0
		for i := range y.dice_values() {
			if diceFrequencies[i] >= 3 {
				threeKindResult = i * 3
				break
			}
		}
		result = threeKindResult
		break

	case yatzy.Categories.FOUR_OF_A_KIND:

		// score if four dice are the same
		var fourKindResult = 0
		for i := range y.dice_values() {
			if diceFrequencies[i] >= 4 {
				fourKindResult = i * 4
				break
			}
		}
		result = fourKindResult
		break

	case yatzy.Categories.SMALL_STRAIGHT:

		// score if dice contains 1,2,3,4,5
		var smallStraightResult = 0
		var count int64
		for _, frequency := range diceFrequencies {
			if frequency == 1 {
				count++
			}
		}
		if count == 5 && diceFrequencies[6] == 0 {
			for _, die := range dice {
				smallStraightResult += die
			}
		}
		result = smallStraightResult
		break

	case yatzy.Categories.LARGE_STRAIGHT:

		// score if dice contains 2,3,4,5,6
		var largeStraightResult int
		var straightCount int64
		for _, frequency := range diceFrequencies {
			if frequency == 1 {
				straightCount++
			}
		}
		if straightCount == 5 && diceFrequencies[1] == 0 {
			for _, die := range dice {
				largeStraightResult += die
			}
		}
		result = largeStraightResult
		break

	case yatzy.Categories.TWO_PAIRS:

		// score if there are two pairs
		var twoPairResult = 0
		var pairCount int64
		for _, frequency := range diceFrequencies {
			if frequency >= 2 {
				pairCount++
			}
		}
		if pairCount == 2 {
			for _, i := range y.dice_values() {
				if diceFrequencies[i] >= 2 {
					twoPairResult += i * 2
				}
			}
		}
		result = twoPairResult
		break

	case yatzy.Categories.FULL_HOUSE:

		// score if there is a pair as well as three of a kind
		var fullHouseResult = 0
		var twoOk bool
		var threeOkay bool
		for _, v := range diceFrequencies {
			if v == 2 {
				twoOk = true
			}
			if v == 3 {
				threeOkay = true
			}
		}
		if twoOk && threeOkay {
			for _, die := range dice {
				fullHouseResult += die
			}
		}
		result = fullHouseResult
		break

	default:
		result = 0
	}
	return result
}

func (y *Yatzy) dice_values() []int {
	return append(make([]int, 0, 6), 6, 5, 4, 3, 2, 1)
}
