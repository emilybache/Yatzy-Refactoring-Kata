package v1

type YatzyStruct struct {
	dice []int
}

func NewYatzy(d1, d2, d3, d4, _5 int) YatzyStruct {
	return YatzyStruct{[]int{d1, d2, d3, d4, _5}}
}

func Chance(d1, d2, d3, d4, d5 int) int {
	total := 0
	total += d1
	total += d2
	total += d3
	total += d4
	total += d5
	return total
}

func Yatzy(dice []int) int {
	counts := make([]int, 6)
	for _, die := range dice {
		counts[die-1] += 1
	}

	for i := 0; i != 6; i++ {
		if counts[i] == 5 {
			return 50
		}
	}
	return 0
}

func Ones(d1, d2, d3, d4, d5 int) int {
	sum := 0
	if d1 == 1 {
		sum += 1
	}
	if d2 == 1 {
		sum += 1
	}
	if d3 == 1 {
		sum += 1
	}
	if d4 == 1 {
		sum += 1
	}
	if d5 == 1 {
		sum += 1
	}
	return sum
}

func Twos(d1, d2, d3, d4, d5 int) int {
	sum := 0
	if d1 == 2 {
		sum += 2
	}
	if d2 == 2 {
		sum += 2
	}
	if d3 == 2 {
		sum += 2
	}
	if d4 == 2 {
		sum += 2
	}
	if d5 == 2 {
		sum += 2
	}
	return sum
}

func Threes(d1, d2, d3, d4, d5 int) int {
	s := 0
	if d1 == 3 {
		s += 3
	}
	if d2 == 3 {
		s += 3
	}
	if d3 == 3 {
		s += 3
	}
	if d4 == 3 {
		s += 3
	}
	if d5 == 3 {
		s += 3
	}
	return s
}

func (y YatzyStruct) Fours() int {
	sum := 0
	for at := 0; at < 5; at++ {
		if y.dice[at] == 4 {
			sum += 4
		}
	}

	return sum
}

func (y YatzyStruct) Fives() int {
	s := 0
	i := 0
	for i = 0; i < len(y.dice); i++ {
		if y.dice[i] == 5 {
			s = s + 5
		}
	}

	return s
}

func (y YatzyStruct) Sixes() int {
	sum := 0
	for at := 0; at < len(y.dice); at++ {
		if y.dice[at] == 6 {
			sum = sum + 6
		}
	}

	return sum
}
func Score_pair(d1, d2, d3, d4, d5 int) int {
	counts := make([]int, 6)
	counts[d1-1] += 1
	counts[d2-1] += 1
	counts[d3-1] += 1
	counts[d4-1] += 1
	counts[d5-1] += 1
	at := 0
	for at = 0; at < 6; at++ {
		if counts[6-at-1] == 2 {
			return (6 - at) * 2
		}
	}
	return 0
}

func Two_pair(d1, d2, d3, d4, d5 int) int {
	counts := make([]int, 6)
	counts[d1-1] += 1
	counts[d2-1] += 1
	counts[d3-1] += 1
	counts[d4-1] += 1
	counts[d5-1] += 1
	n := 0
	score := 0
	for i := 0; i < 6; i++ {
		if counts[6-i-1] >= 2 {
			n = n + 1
			score += (6 - i)
		}
	}
	if n == 2 {
		return score * 2
	} else {
		return 0
	}
}

func Four_of_a_kind(_1, _2, d3, d4, d5 int) int {
	tallies := make([]int, 6)
	tallies[_1-1] += 1
	tallies[_2-1] += 1
	tallies[d3-1] += 1
	tallies[d4-1] += 1
	tallies[d5-1] += 1
	for i := 0; i < 6; i++ {
		if tallies[i] >= 4 {
			return (i + 1) * 4
		}
	}
	return 0
}

func Three_of_a_kind(d1, d2, d3, d4, d5 int) int {
	t := make([]int, 6)
	t[d1-1] += 1
	t[d2-1] += 1
	t[d3-1] += 1
	t[d4-1] += 1
	t[d5-1] += 1
	for i := 0; i < 6; i++ {
		if t[i] >= 3 {
			return (i + 1) * 3
		}
	}
	return 0
}

func SmallStraight(d1, d2, d3, d4, d5 int) int {
	tallies := make([]int, 6)
	tallies[d1-1] += 1
	tallies[d2-1] += 1
	tallies[d3-1] += 1
	tallies[d4-1] += 1
	tallies[d5-1] += 1
	if tallies[0] == 1 &&
		tallies[1] == 1 &&
		tallies[2] == 1 &&
		tallies[3] == 1 &&
		tallies[4] == 1 {
		return 15
	}
	return 0
}

func LargeStraight(d1, d2, d3, d4, d5 int) int {
	tallies := make([]int, 6)
	tallies[d1-1] += 1
	tallies[d2-1] += 1
	tallies[d3-1] += 1
	tallies[d4-1] += 1
	tallies[d5-1] += 1
	if tallies[1] == 1 &&
		tallies[2] == 1 &&
		tallies[3] == 1 &&
		tallies[4] == 1 &&
		tallies[5] == 1 {
		return 20
	}
	return 0

}

func FullHouse(d1, d2, d3, d4, d5 int) int {
	var tallies []int
	_2 := false
	i := 0
	_2_at := 0
	_3 := false
	_3_at := 0
	tallies = make([]int, 6)
	tallies[d1-1] += 1
	tallies[d2-1] += 1
	tallies[d3-1] += 1
	tallies[d4-1] += 1
	tallies[d5-1] += 1
	for i = 0; i < 6; i++ {
		if tallies[i] == 2 {
			_2 = true
			_2_at = i + 1
		}
	}
	for i = 0; i < 6; i++ {
		if tallies[i] == 3 {
			_3 = true
			_3_at = i + 1
		}
	}
	if _2 && _3 {
		return _2_at*2 + _3_at*3
	} else {
		return 0
	}
}
