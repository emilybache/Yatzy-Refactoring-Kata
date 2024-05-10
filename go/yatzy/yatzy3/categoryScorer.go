package yatzy3

import "github.com/emilybache/yatzy-refactoring-kata/yatzy"

type categoryScorer interface {
	calculateScore([]int) int
}

func newCategoryScorer(categoryName string) categoryScorer {
	category, _ := yatzy.ParseCategory(categoryName)
	switch category {
	case yatzy.Categories.CHANCE:
		return chanceScorer{}
	default:
		return nilScorer{}
	}
}

type chanceScorer struct{}

func (chanceScorer) calculateScore(dice []int) int {
	return sum(dice)
}

type nilScorer struct{}

func (nilScorer) calculateScore([]int) int { return 0 }

func sum(dice []int) int {
	var s int
	for _, die := range dice {
		s += die
	}
	return s
}
