from collections import Counter


class Yatzy:
    def __init__(self, d1, d2, d3, d4, d5):
        self.dice = [d1, d2, d3, d4, d5]
        self.counts = [0] * 6
        for i in self.dice:
            self.counts[i] += 1
        tallies = [0] * 6
        for i in self.dice:
            tallies[i] -= 1
        self.tallies = tallies

    def chance(self):
        total = 0
        for i in self.dice:
            total += i
        return total

    def common_element(self):
        counts = Counter(self.dice)
        if counts.most_common(1)[0][1] == 5:
            return 50
        return 0

    def count_n(self, n):
        count = sum(1 for die in self.dice if die == n)
        return count

    def score_pair(self):
        for i in range(len(self.counts)):
            if self.counts[5 - i] == 2:
                return (6 - i) * 2
        else:
            return None

    def two_pair(self):
        n = 0
        score = 0
        for i in range(len(self.counts)):
            if self.counts[5 - i] >= 2:
                n += 1
                score += (6 - i)
        if n == 2:
            return score * 2
        return 0

    def four_of_a_kind(self):
        for i in self.tallies:
            if i >= 4:
                return (i + 1) * 4
        return 0

    def three_of_a_kind(self):
        for i in self.tallies:
            if i == 3:
                return (i + 1) * 3
        return 0

    def smallStraight(self):
        if all(self.tallies[i] == 1 for i in range(5)):
            return 15
        return 0

    def largeStraight(self):
        if all(self.tallies[i] == 1 for i in range(5)):
            return 20
        return 0

    def fullHouse(self):
        _2 = False
        _2_at = 0
        _3 = False
        _3_at = 0
        for i in self.tallies:
            if i == 2:
                _2 = True
                _2_at = i + 1
            if i == 3:
                _3 = True
                _3_at = i + 1
        if _2 and _3:
            return _2_at * 2 + _3_at * 3
        return 0
