package v3

import (
	"github.com/emilybache/yatzy-refactoring-kata/yatzy"
)

type categoryScorer interface {
	calculateScore(dice []int) int
}

func newCategoryScorer(categoryName string) categoryScorer {
	category, _ := yatzy.ParseCategory(categoryName)
	switch category {
	case yatzy.Categories.CHANCE:
		return chanceScorer{}
	case yatzy.Categories.YATZY:
		return yatzyScorer{}
	case yatzy.Categories.ONES:
		return numberScorer{number: 1}
	case yatzy.Categories.TWOS:
		return numberScorer{number: 2}
	case yatzy.Categories.THREES:
		return numberScorer{number: 3}
	case yatzy.Categories.FOURS:
		return numberScorer{number: 4}
	case yatzy.Categories.FIVES:
		return numberScorer{number: 5}
	case yatzy.Categories.SIXES:
		return numberScorer{number: 6}
	case yatzy.Categories.PAIR:
		return repeatedCountScorer{count: 2}
	case yatzy.Categories.THREE_OF_A_KIND:
		return repeatedCountScorer{count: 3}
	case yatzy.Categories.FOUR_OF_A_KIND:
		return repeatedCountScorer{count: 4}
	case yatzy.Categories.SMALL_STRAIGHT:
		return straightScorer{includes: 1}
	case yatzy.Categories.LARGE_STRAIGHT:
		return straightScorer{includes: 6}
	case yatzy.Categories.TWO_PAIRS:
		return twoPairScorer{}
	case yatzy.Categories.FULL_HOUSE:
		return fullHouseScorer{}
	default:
		return nilScorer{}
	}
}

type chanceScorer struct{}

func (chanceScorer) calculateScore(dice []int) int {
	return sum(dice)
}

type yatzyScorer struct{}

func (yatzyScorer) calculateScore(dice []int) int {
	for _, v := range frequencies(dice) {
		if v == 5 {
			return 50
		}
	}
	return 0
}

type numberScorer struct {
	number int
}

func (n numberScorer) calculateScore(dice []int) int {
	return frequencies(dice)[n.number] * n.number
}

type repeatedCountScorer struct {
	count int
}

func (r repeatedCountScorer) calculateScore(dice []int) int {
	frequencies := frequencies(dice)
	for _, i := range []int{6, 5, 4, 3, 2, 1} {
		if v := frequencies[i]; v >= r.count {
			return i * r.count
		}
	}
	return 0
}

type straightScorer struct {
	includes int
}

func (s straightScorer) calculateScore(dice []int) int {
	if s.isStraight(dice) && frequencies(dice)[s.includes] != 0 {
		return sum(dice)
	}
	return 0
}

func (s straightScorer) isStraight(dice []int) bool {
	count := 0
	for _, v := range frequencies(dice) {
		if v == 1 {
			count += 1
		}
	}
	return count == 5
}

type twoPairScorer struct{}

func (ts twoPairScorer) calculateScore(dice []int) int {
	freqs := frequencies(dice)
	var score int
	var numPairs int
	for _, v := range freqs {
		if v >= 2 {
			numPairs += 1
		}
	}
	if numPairs == 2 {
		for _, i := range []int{6, 5, 4, 3, 2, 1} {
			if freqs[i] >= 2 {
				score += i * 2
			}
		}
	}
	return score
}

type fullHouseScorer struct{}

func (fullHouseScorer) calculateScore(dice []int) int {
	frequencies := frequencies(dice)
	var foundTwo bool
	var foundThree bool
	for _, v := range frequencies {
		if v == 2 {
			foundTwo = true
		}
		if v == 3 {
			foundThree = true
		}
	}
	if foundTwo && foundThree {
		return sum(dice)
	}
	return 0
}

type nilScorer struct{}

func (nilScorer) calculateScore([]int) int { return 0 }

func sum(d []int) int {
	var s int
	for _, d2 := range d {
		s += d2
	}
	return s
}

func frequencies(dice []int) map[int]int {
	diceFrequencies := map[int]int{}
	for _, i := range dice {
		diceFrequencies[i] = 0
	}
	for i := range dice {
		diceFrequencies[dice[i]] += 1
	}
	return diceFrequencies
}
