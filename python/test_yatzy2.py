import pytest

from yatzy2 import Yatzy, YatzyCategory


@pytest.fixture
def calculator():
    return Yatzy()


def test_chance_scores_sum_of_all_dice(calculator):
    assert (15 == calculator.score([2, 3, 4, 5, 1], YatzyCategory.CHANCE))
    assert (16 == calculator.score([3, 3, 4, 5, 1], YatzyCategory.CHANCE))


def test_yatzy_scores_50(calculator):
    assert (50 == calculator.score([4, 4, 4, 4, 4], YatzyCategory.YATZY))
    assert (50 == calculator.score([6, 6, 6, 6, 6], YatzyCategory.YATZY))
    assert (0 == calculator.score([6, 6, 6, 6, 3], YatzyCategory.YATZY))


def test_test_1s(calculator):
    assert (1 == calculator.score([1, 2, 3, 4, 5], YatzyCategory.ONES))
    assert (2 == calculator.score([1, 2, 1, 4, 5], YatzyCategory.ONES))
    assert (0 == calculator.score([6, 2, 2, 4, 5], YatzyCategory.ONES))
    assert (4 == calculator.score([1, 2, 1, 1, 1], YatzyCategory.ONES))


def test_twos(calculator):
    assert (4 == calculator.score([1, 2, 3, 2, 6], YatzyCategory.TWOS))
    assert (10 == calculator.score([2, 2, 2, 2, 2], YatzyCategory.TWOS))


def test_threes(calculator):
    assert (6 == calculator.score([1, 2, 3, 2, 3], YatzyCategory.THREES))
    assert (12 == calculator.score([2, 3, 3, 3, 3], YatzyCategory.THREES))


def test_fours(calculator):
    assert (12 == calculator.score([4, 4, 4, 5, 5], YatzyCategory.FOURS))
    assert (8 == calculator.score([4, 4, 5, 5, 5], YatzyCategory.FOURS))
    assert (4 == calculator.score([4, 5, 5, 5, 5], YatzyCategory.FOURS))


def test_fives(calculator):
    assert (10 == calculator.score([4, 4, 4, 5, 5], YatzyCategory.FIVES))
    assert (15 == calculator.score([4, 4, 5, 5, 5], YatzyCategory.FIVES))
    assert (20 == calculator.score([4, 5, 5, 5, 5], YatzyCategory.FIVES))


def test_sixes(calculator):
    assert (0 == calculator.score([4, 4, 4, 5, 5], YatzyCategory.SIXES))
    assert (6 == calculator.score([4, 4, 6, 5, 5], YatzyCategory.SIXES))
    assert (18 == calculator.score([6, 5, 6, 6, 5], YatzyCategory.SIXES))


def test_pair(calculator):
    assert (6 == calculator.score([3, 4, 3, 5, 6], YatzyCategory.PAIR))
    assert (10 == calculator.score([5, 3, 3, 3, 5], YatzyCategory.PAIR))
    assert (12 == calculator.score([5, 3, 6, 6, 5], YatzyCategory.PAIR))


def test_two_pair(calculator):
    assert (16 == calculator.score([3, 3, 5, 4, 5], YatzyCategory.TWO_PAIRS))
    assert (16 == calculator.score([3, 3, 5, 5, 5], YatzyCategory.TWO_PAIRS))


def test_three_of_a_kind(calculator):
    assert (9 == calculator.score([3, 3, 3, 4, 5], YatzyCategory.THREE_OF_A_KIND))
    assert (15 == calculator.score([5, 3, 5, 4, 5], YatzyCategory.THREE_OF_A_KIND))
    assert (9 == calculator.score([3, 3, 3, 3, 5], YatzyCategory.THREE_OF_A_KIND))


def test_four_of_a_knd(calculator):
    assert (12 == calculator.score([3, 3, 3, 3, 5], YatzyCategory.FOUR_OF_A_KIND))
    assert (20 == calculator.score([5, 5, 5, 4, 5], YatzyCategory.FOUR_OF_A_KIND))
    assert (12 == calculator.score([3, 3, 3, 3, 3], YatzyCategory.FOUR_OF_A_KIND))


def test_smallStraight(calculator):
    assert (15 == calculator.score([1, 2, 3, 4, 5], YatzyCategory.SMALL_STRAIGHT))
    assert (15 == calculator.score([2, 3, 4, 5, 1], YatzyCategory.SMALL_STRAIGHT))
    assert (0 == calculator.score([1, 2, 2, 4, 5], YatzyCategory.SMALL_STRAIGHT))


def test_largeStraight(calculator):
    assert (20 == calculator.score([6, 2, 3, 4, 5], YatzyCategory.LARGE_STRAIGHT))
    assert (20 == calculator.score([2, 3, 4, 5, 6], YatzyCategory.LARGE_STRAIGHT))
    assert (0 == calculator.score([1, 2, 2, 4, 5], YatzyCategory.LARGE_STRAIGHT))


def test_fullHouse(calculator):
    assert (18 == calculator.score([6, 2, 2, 2, 6], YatzyCategory.FULL_HOUSE))
    assert (0 == calculator.score([2, 3, 4, 5, 6], YatzyCategory.FULL_HOUSE))
