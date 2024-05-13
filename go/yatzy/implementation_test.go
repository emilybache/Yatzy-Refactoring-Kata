package yatzy_test

import (
	"github.com/emilybache/yatzy-refactoring-kata/yatzy"
	"github.com/emilybache/yatzy-refactoring-kata/yatzy/v2"
	"github.com/emilybache/yatzy-refactoring-kata/yatzy/v3"
	"github.com/stretchr/testify/suite"
	"testing"
)

func TestImplementationOf(t *testing.T) {
	tests := []struct {
		name string
		calc yatzy.Calculator
	}{
		{
			name: "Yatzy2",
			calc: &v2.Yatzy{},
		},
		{
			name: "Yatzy3",
			calc: &v3.Yatzy{},
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			suite.Run(t, &yatzySuite{calc: tt.calc})
		})
	}
}

type yatzySuite struct {
	suite.Suite
	calc yatzy.Calculator
}

func (t *yatzySuite) Test_chance_scores_sum_of_all_dice() {
	t.Require().Equal(15, t.calc.Score([]int{2, 3, 4, 5, 1}, "chance"))
	t.Require().Equal(16, t.calc.Score([]int{3, 3, 4, 5, 1}, "chance"))
}

func (t *yatzySuite) Test_yatzy_scores_50() {
	t.Require().Equal(50, t.calc.Score([]int{4, 4, 4, 4, 4}, "yatzy"))
	t.Require().Equal(50, t.calc.Score([]int{6, 6, 6, 6, 6}, "yatzy"))
	t.Require().Equal(0, t.calc.Score([]int{6, 6, 6, 6, 3}, "yatzy"))
}

func (t *yatzySuite) Test_1s() {
	t.Require().Equal(1, t.calc.Score([]int{1, 2, 3, 4, 5}, "ones"))
	t.Require().Equal(2, t.calc.Score([]int{1, 2, 1, 4, 5}, "ones"))
	t.Require().Equal(0, t.calc.Score([]int{6, 2, 2, 4, 5}, "ones"))
	t.Require().Equal(4, t.calc.Score([]int{1, 2, 1, 1, 1}, "ones"))
}

func (t *yatzySuite) Test_twos() {
	t.Require().Equal(4, t.calc.Score([]int{1, 2, 3, 2, 6}, "twos"))
	t.Require().Equal(10, t.calc.Score([]int{2, 2, 2, 2, 2}, "twos"))
}

func (t *yatzySuite) Test_threes() {
	t.Require().Equal(6, t.calc.Score([]int{1, 2, 3, 2, 3}, "threes"))
	t.Require().Equal(12, t.calc.Score([]int{2, 3, 3, 3, 3}, "threes"))
}

func (t *yatzySuite) Test_fours() {
	t.Require().Equal(12, t.calc.Score([]int{4, 4, 4, 5, 5}, "fours"))
	t.Require().Equal(8, t.calc.Score([]int{4, 4, 5, 5, 5}, "fours"))
	t.Require().Equal(4, t.calc.Score([]int{4, 5, 5, 5, 5}, "fours"))
}

func (t *yatzySuite) Test_fives() {
	t.Require().Equal(10, t.calc.Score([]int{4, 4, 4, 5, 5}, "fives"))
	t.Require().Equal(15, t.calc.Score([]int{4, 4, 5, 5, 5}, "fives"))
	t.Require().Equal(20, t.calc.Score([]int{4, 5, 5, 5, 5}, "fives"))
}

func (t *yatzySuite) Test_sixes() {
	t.Require().Equal(0, t.calc.Score([]int{4, 4, 4, 5, 5}, "sixes"))
	t.Require().Equal(6, t.calc.Score([]int{4, 4, 6, 5, 5}, "sixes"))
	t.Require().Equal(18, t.calc.Score([]int{6, 5, 6, 6, 5}, "sixes"))
}

func (t *yatzySuite) Test_pair() {
	t.Require().Equal(6, t.calc.Score([]int{3, 4, 3, 5, 6}, "pair"))
	t.Require().Equal(10, t.calc.Score([]int{5, 3, 3, 3, 5}, "pair"))
	t.Require().Equal(12, t.calc.Score([]int{5, 3, 6, 6, 5}, "pair"))
}

func (t *yatzySuite) Test_two_pair() {
	t.Require().Equal(16, t.calc.Score([]int{3, 3, 5, 4, 5}, "two_pairs"))
	t.Require().Equal(16, t.calc.Score([]int{3, 3, 5, 5, 5}, "two_pairs"))
}

func (t *yatzySuite) Test_three_of_a_kind() {
	t.Require().Equal(9, t.calc.Score([]int{3, 3, 3, 4, 5}, "three_of_a_kind"))
	t.Require().Equal(15, t.calc.Score([]int{5, 3, 5, 4, 5}, "three_of_a_kind"))
	t.Require().Equal(9, t.calc.Score([]int{3, 3, 3, 3, 5}, "three_of_a_kind"))
}

func (t *yatzySuite) Test_four_of_a_knd() {
	t.Require().Equal(12, t.calc.Score([]int{3, 3, 3, 3, 5}, "four_of_a_kind"))
	t.Require().Equal(20, t.calc.Score([]int{5, 5, 5, 4, 5}, "four_of_a_kind"))
	t.Require().Equal(12, t.calc.Score([]int{3, 3, 3, 3, 3}, "four_of_a_kind"))
	t.Require().Equal(0, t.calc.Score([]int{3, 3, 3, 1, 2}, "four_of_a_kind"))
}

func (t *yatzySuite) Test_smallStraight() {
	t.Require().Equal(15, t.calc.Score([]int{1, 2, 3, 4, 5}, "small_straight"))
	t.Require().Equal(15, t.calc.Score([]int{2, 3, 4, 5, 1}, "small_straight"))
	t.Require().Equal(0, t.calc.Score([]int{1, 2, 2, 4, 5}, "small_straight"))
}

func (t *yatzySuite) Test_largeStraight() {
	t.Require().Equal(20, t.calc.Score([]int{6, 2, 3, 4, 5}, "large_straight"))
	t.Require().Equal(20, t.calc.Score([]int{2, 3, 4, 5, 6}, "large_straight"))
	t.Require().Equal(0, t.calc.Score([]int{1, 2, 2, 4, 5}, "large_straight"))
}

func (t *yatzySuite) Test_fullHouse() {
	t.Require().Equal(18, t.calc.Score([]int{6, 2, 2, 2, 6}, "full_house"))
	t.Require().Equal(0, t.calc.Score([]int{2, 3, 4, 5, 6}, "full_house"))
}
