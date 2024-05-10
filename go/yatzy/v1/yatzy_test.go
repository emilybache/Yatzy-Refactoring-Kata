package v1_test

import (
	"github.com/emilybache/yatzy-refactoring-kata/yatzy/v1"
	"testing"

	"github.com/stretchr/testify/assert"
)

func Test_chance_scores_sum_of_all_dice(t *testing.T) {
	expected := 15
	actual := v1.Chance(2, 3, 4, 5, 1)
	assert.Equal(t, expected, actual)
	assert.Equal(t, 16, v1.Chance(3, 3, 4, 5, 1))
}

func Test_yatzy_scores_50(t *testing.T) {
	expected := 50
	actual := v1.Yatzy([]int{4, 4, 4, 4, 4})
	assert.Equal(t, expected, actual)
	assert.Equal(t, 50, v1.Yatzy([]int{6, 6, 6, 6, 6}))
	assert.Equal(t, 0, v1.Yatzy([]int{6, 6, 6, 6, 3}))
}

func Test_1s(t *testing.T) {
	assert.Equal(t, v1.Ones(1, 2, 3, 4, 5), 1)
	assert.Equal(t, 2, v1.Ones(1, 2, 1, 4, 5))
	assert.Equal(t, 0, v1.Ones(6, 2, 2, 4, 5))
	assert.Equal(t, 4, v1.Ones(1, 2, 1, 1, 1))

}

func Test_2s(t *testing.T) {
	assert.Equal(t, 4, v1.Twos(1, 2, 3, 2, 6))
	assert.Equal(t, 10, v1.Twos(2, 2, 2, 2, 2))
}

func Test_threes(t *testing.T) {
	assert.Equal(t, 6, v1.Threes(1, 2, 3, 2, 3))
	assert.Equal(t, 12, v1.Threes(2, 3, 3, 3, 3))
}

func Test_fours_test(t *testing.T) {
	assert.Equal(t, 12, v1.NewYatzy(4, 4, 4, 5, 5).Fours())
	assert.Equal(t, 8, v1.NewYatzy(4, 4, 5, 5, 5).Fours())
	assert.Equal(t, 4, v1.NewYatzy(4, 5, 5, 5, 5).Fours())
}
func Test_fives(t *testing.T) {
	assert.Equal(t, 10, v1.NewYatzy(4, 4, 4, 5, 5).Fives())
	assert.Equal(t, 15, v1.NewYatzy(4, 4, 5, 5, 5).Fives())
	assert.Equal(t, 20, v1.NewYatzy(4, 5, 5, 5, 5).Fives())
}

func Test_sixes_test(t *testing.T) {
	assert.Equal(t, 0, v1.NewYatzy(4, 4, 4, 5, 5).Sixes())
	assert.Equal(t, 6, v1.NewYatzy(4, 4, 6, 5, 5).Sixes())
	assert.Equal(t, 18, v1.NewYatzy(6, 5, 6, 6, 5).Sixes())
}

func Test_one_pair(t *testing.T) {
	assert.Equal(t, 6, v1.Score_pair(3, 4, 3, 5, 6))
	assert.Equal(t, 10, v1.Score_pair(5, 3, 3, 3, 5))
	assert.Equal(t, 12, v1.Score_pair(5, 3, 6, 6, 5))
}

func Test_two_Pair(t *testing.T) {
	assert.Equal(t, 16, v1.Two_pair(3, 3, 5, 4, 5))
	assert.Equal(t, 18, v1.Two_pair(3, 3, 6, 6, 6))
	assert.Equal(t, 0, v1.Two_pair(3, 3, 6, 5, 4))
}

func Test_three_of_a_kind(t *testing.T) {
	assert.Equal(t, 9, v1.Three_of_a_kind(3, 3, 3, 4, 5))
	assert.Equal(t, 15, v1.Three_of_a_kind(5, 3, 5, 4, 5))
	assert.Equal(t, 9, v1.Three_of_a_kind(3, 3, 3, 3, 5))
}

func Test_four_of_a_knd(t *testing.T) {
	assert.Equal(t, 12, v1.Four_of_a_kind(3, 3, 3, 3, 5))
	assert.Equal(t, 20, v1.Four_of_a_kind(5, 5, 5, 4, 5))
	assert.Equal(t, 12, v1.Four_of_a_kind(3, 3, 3, 3, 3))
	assert.Equal(t, 0, v1.Four_of_a_kind(3, 3, 3, 2, 1))
}

func Test_smallStraight(t *testing.T) {
	assert.Equal(t, 15, v1.SmallStraight(1, 2, 3, 4, 5))
	assert.Equal(t, 15, v1.SmallStraight(2, 3, 4, 5, 1))
	assert.Equal(t, 0, v1.SmallStraight(1, 2, 2, 4, 5))
}

func Test_largeStraight(t *testing.T) {
	assert.Equal(t, 20, v1.LargeStraight(6, 2, 3, 4, 5))
	assert.Equal(t, 20, v1.LargeStraight(2, 3, 4, 5, 6))
	assert.Equal(t, 0, v1.LargeStraight(1, 2, 2, 4, 5))
}

func Test_fullHouse(t *testing.T) {
	assert.Equal(t, 18, v1.FullHouse(6, 2, 2, 2, 6))
	assert.Equal(t, 0, v1.FullHouse(2, 3, 4, 5, 6))
}
