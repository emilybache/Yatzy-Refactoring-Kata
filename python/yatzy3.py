from abc import ABC, abstractmethod
from enum import Enum
from typing import List, Dict


class YatzyCategory(Enum):
    CHANCE = 0
    YATZY = 1
    ONES = 2
    TWOS = 3
    THREES = 4
    FOURS = 5
    FIVES = 6
    SIXES = 7
    PAIR = 8
    THREE_OF_A_KIND = 9
    FOUR_OF_A_KIND = 10
    SMALL_STRAIGHT = 11
    LARGE_STRAIGHT = 12
    TWO_PAIRS = 13
    FULL_HOUSE = 14


class CategoryScorer(ABC):
    @staticmethod
    def create_instance(category_name: str) -> 'CategoryScorer':
        category = YatzyCategory[category_name]

        # Using a dictionary as Python doesn't have switch expressions
        scorers = {
            YatzyCategory.CHANCE: ChanceScorer(),
            YatzyCategory.YATZY: YatzyPointsScorer(),
            YatzyCategory.ONES: NumberScorer(1),
            YatzyCategory.TWOS: NumberScorer(2),
            YatzyCategory.THREES: NumberScorer(3),
            YatzyCategory.FOURS: NumberScorer(4),
            YatzyCategory.FIVES: NumberScorer(5),
            YatzyCategory.SIXES: NumberScorer(6),
            YatzyCategory.PAIR: RepeatedCountScorer(2),
            YatzyCategory.THREE_OF_A_KIND: RepeatedCountScorer(3),
            YatzyCategory.FOUR_OF_A_KIND: RepeatedCountScorer(4),
            YatzyCategory.SMALL_STRAIGHT: StraightScorer(1),
            YatzyCategory.LARGE_STRAIGHT: StraightScorer(6),
            YatzyCategory.TWO_PAIRS: TwoPairsScorer(),
            YatzyCategory.FULL_HOUSE: FullHouseScorer()
        }

        return scorers[category]

    @abstractmethod
    def calculate_score(self, dice: List[int]) -> int:
        pass

    def frequencies(self, dice: List[int]) -> Dict[int, int]:
        frequencies = {i: 0 for i in range(6, 0, -1)}
        for die in dice:
            frequencies[die] += 1
        return frequencies

    def sum(self, dice: List[int]) -> int:
        return sum(dice)


class ChanceScorer(CategoryScorer):
    def calculate_score(self, dice: List[int]) -> int:
        return self.sum(dice)


class FullHouseScorer(CategoryScorer):
    def calculate_score(self, dice: List[int]) -> int:
        frequencies = self.frequencies(dice)
        if 2 in frequencies.values() and 3 in frequencies.values():
            return self.sum(dice)
        return 0


class NumberScorer(CategoryScorer):
    def __init__(self, number: int):
        self.number = number

    def calculate_score(self, dice: List[int]) -> int:
        return self.frequencies(dice)[self.number] * self.number


class RepeatedCountScorer(CategoryScorer):
    def __init__(self, count: int):
        self.count = count

    def calculate_score(self, dice: List[int]) -> int:
        frequencies = self.frequencies(dice)
        for i in range(6, 0, -1):  # Iterate from 6 down to 1
            if frequencies[i] >= self.count:
                return i * self.count
        return 0


class StraightScorer(CategoryScorer):
    def __init__(self, straight_includes: int):
        self.straight_includes = straight_includes

    def is_straight(self, dice: List[int]) -> bool:
        return len([f for f in self.frequencies(dice).values() if f == 1]) == 5

    def calculate_score(self, dice: List[int]) -> int:
        if self.is_straight(dice) and self.frequencies(dice)[self.straight_includes] != 0:
            return self.sum(dice)
        return 0


class TwoPairsScorer(CategoryScorer):
    def calculate_score(self, dice: List[int]) -> int:
        frequencies = self.frequencies(dice)
        score = 0
        if len([f for f in frequencies.values() if f >= 2]) == 2:
            score = sum(i * 2 for i in range(6, 0, -1) if frequencies[i] >= 2)
        return score


class YatzyPointsScorer(CategoryScorer):
    def calculate_score(self, dice: List[int]) -> int:
        if 5 in self.frequencies(dice).values():
            return 50
        return 0


class Yatzy:
    def valid_categories(self) -> List[str]:
        return [category.name for category in YatzyCategory]

    def score(self, dice: List[int], category: str) -> int:
        return CategoryScorer.create_instance(category).calculate_score(dice)
