package yatzy_test

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/emilybache/yatzy-refactoring-kata/yatzy"
)

func Test_chance_scores_sum_of_all_dice(t *testing.T) {
	expected := 15
	actual := yatzy.Chance(2, 3, 4, 5, 1)
	assert.Equal(t, expected, actual)
	assert.Equal(t, 16, yatzy.Chance(3, 3, 4, 5, 1))
}

func Test_yatzy_scores_50(t *testing.T) {
	expected := 50
	actual := yatzy.Yatzy([]int{4, 4, 4, 4, 4})
	assert.Equal(t, expected, actual)
	assert.Equal(t, 50, yatzy.Yatzy([]int{6, 6, 6, 6, 6}))
	assert.Equal(t, 0, yatzy.Yatzy([]int{6, 6, 6, 6, 3}))
}

func Test_1s(t *testing.T) {
	assert.Equal(t, yatzy.Ones(1, 2, 3, 4, 5), 1)
	assert.Equal(t, 2, yatzy.Ones(1, 2, 1, 4, 5))
	assert.Equal(t, 0, yatzy.Ones(6, 2, 2, 4, 5))
	assert.Equal(t, 4, yatzy.Ones(1, 2, 1, 1, 1))

}

func Test_2s(t *testing.T) {
	assert.Equal(t, 4, yatzy.Twos(1, 2, 3, 2, 6))
	assert.Equal(t, 10, yatzy.Twos(2, 2, 2, 2, 2))
}

func Test_threes(t *testing.T) {
	assert.Equal(t, 6, yatzy.Threes(1, 2, 3, 2, 3))
	assert.Equal(t, 12, yatzy.Threes(2, 3, 3, 3, 3))
}

func Test_fours_test(t *testing.T) {
	assert.Equal(t, 12, yatzy.NewYatzy(4, 4, 4, 5, 5).Fours())
	assert.Equal(t, 8, yatzy.NewYatzy(4, 4, 5, 5, 5).Fours())
	assert.Equal(t, 4, yatzy.NewYatzy(4, 5, 5, 5, 5).Fours())
}
func Test_fives(t *testing.T) {
	assert.Equal(t, 10, yatzy.NewYatzy(4, 4, 4, 5, 5).Fives())
	assert.Equal(t, 15, yatzy.NewYatzy(4, 4, 5, 5, 5).Fives())
	assert.Equal(t, 20, yatzy.NewYatzy(4, 5, 5, 5, 5).Fives())
}

func Test_sixes_test(t *testing.T) {
	assert.Equal(t, 0, yatzy.NewYatzy(4, 4, 4, 5, 5).Sixes())
	assert.Equal(t, 6, yatzy.NewYatzy(4, 4, 6, 5, 5).Sixes())
	assert.Equal(t, 18, yatzy.NewYatzy(6, 5, 6, 6, 5).Sixes())
}

func Test_one_pair(t *testing.T) {
	assert.Equal(t, 6, yatzy.Score_pair(3, 4, 3, 5, 6))
	assert.Equal(t, 10, yatzy.Score_pair(5, 3, 3, 3, 5))
	assert.Equal(t, 12, yatzy.Score_pair(5, 3, 6, 6, 5))
}

func Test_two_Pair(t *testing.T) {
	assert.Equal(t, 16, yatzy.Two_pair(3, 3, 5, 4, 5))
	assert.Equal(t, 18, yatzy.Two_pair(3, 3, 6, 6, 6))
	assert.Equal(t, 0, yatzy.Two_pair(3, 3, 6, 5, 4))
}

func Test_three_of_a_kind(t *testing.T) {
	assert.Equal(t, 9, yatzy.Three_of_a_kind(3, 3, 3, 4, 5))
	assert.Equal(t, 15, yatzy.Three_of_a_kind(5, 3, 5, 4, 5))
	assert.Equal(t, 9, yatzy.Three_of_a_kind(3, 3, 3, 3, 5))
}

func Test_four_of_a_knd(t *testing.T) {
	assert.Equal(t, 12, yatzy.Four_of_a_kind(3, 3, 3, 3, 5))
	assert.Equal(t, 20, yatzy.Four_of_a_kind(5, 5, 5, 4, 5))
	assert.Equal(t, 12, yatzy.Four_of_a_kind(3, 3, 3, 3, 3))
	assert.Equal(t, 0, yatzy.Four_of_a_kind(3, 3, 3, 2, 1))
}

func Test_smallStraight(t *testing.T) {
	assert.Equal(t, 15, yatzy.SmallStraight(1, 2, 3, 4, 5))
	assert.Equal(t, 15, yatzy.SmallStraight(2, 3, 4, 5, 1))
	assert.Equal(t, 0, yatzy.SmallStraight(1, 2, 2, 4, 5))
}

func Test_largeStraight(t *testing.T) {
	assert.Equal(t, 20, yatzy.LargeStraight(6, 2, 3, 4, 5))
	assert.Equal(t, 20, yatzy.LargeStraight(2, 3, 4, 5, 6))
	assert.Equal(t, 0, yatzy.LargeStraight(1, 2, 2, 4, 5))
}

func Test_fullHouse(t *testing.T) {
	assert.Equal(t, 18, yatzy.FullHouse(6, 2, 2, 2, 6))
	assert.Equal(t, 0, yatzy.FullHouse(2, 3, 4, 5, 6))
}
