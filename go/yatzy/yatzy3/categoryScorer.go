package yatzy3

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
