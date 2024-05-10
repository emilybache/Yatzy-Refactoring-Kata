package yatzy

type category uint

//go:generate goenums yatzy.go
const (
	unknown category = iota
	chance
	yatzy
	ones
	twos
	threes
	fours
	fives
	sixes
	pair
	three_of_a_kind
	four_of_a_kind
	small_straight
	large_straight
	two_pairs
	full_house
)

type Calculator interface {
	ValidCategories() []string
	Score(dice []int, category string) int
}
