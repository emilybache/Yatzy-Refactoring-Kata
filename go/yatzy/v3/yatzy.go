package v3

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
	return newCategoryScorer(category).calculateScore(dice)
}
