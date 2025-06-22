import pytest

import yatzy3


@pytest.fixture
def calculator():
    return yatzy3.Yatzy()


def test_chance_scores_sum_of_all_dice(calculator):
    assert (15 == calculator.score([2, 3, 4, 5, 1], "CHANCE"))
    assert (16 == calculator.score([3, 3, 4, 5, 1], "CHANCE"))


def test_yatzy_scores_50(calculator):
    assert (50 == calculator.score([4, 4, 4, 4, 4], "YATZY"))
    assert (50 == calculator.score([6, 6, 6, 6, 6], "YATZY"))
    assert (0 == calculator.score([6, 6, 6, 6, 3], "YATZY"))


def test_test_1s(calculator):
    assert (1 == calculator.score([1, 2, 3, 4, 5], "ONES"))
    assert (2 == calculator.score([1, 2, 1, 4, 5], "ONES"))
    assert (0 == calculator.score([6, 2, 2, 4, 5], "ONES"))
    assert (4 == calculator.score([1, 2, 1, 1, 1], "ONES"))


def test_twos(calculator):
    assert (4 == calculator.score([1, 2, 3, 2, 6], "TWOS"))
    assert (10 == calculator.score([2, 2, 2, 2, 2], "TWOS"))


def test_threes(calculator):
    assert (6 == calculator.score([1, 2, 3, 2, 3], "THREES"))
    assert (12 == calculator.score([2, 3, 3, 3, 3], "THREES"))


def test_fours(calculator):
    assert (12 == calculator.score([4, 4, 4, 5, 5], "FOURS"))
    assert (8 == calculator.score([4, 4, 5, 5, 5], "FOURS"))
    assert (4 == calculator.score([4, 5, 5, 5, 5], "FOURS"))


def test_fives(calculator):
    assert (10 == calculator.score([4, 4, 4, 5, 5], "FIVES"))
    assert (15 == calculator.score([4, 4, 5, 5, 5], "FIVES"))
    assert (20 == calculator.score([4, 5, 5, 5, 5], "FIVES"))


def test_sixes(calculator):
    assert (0 == calculator.score([4, 4, 4, 5, 5], "SIXES"))
    assert (6 == calculator.score([4, 4, 6, 5, 5], "SIXES"))
    assert (18 == calculator.score([6, 5, 6, 6, 5], "SIXES"))


def test_pair(calculator):
    assert (6 == calculator.score([3, 4, 3, 5, 6], "PAIR"))
    assert (10 == calculator.score([5, 3, 3, 3, 5], "PAIR"))
    assert (12 == calculator.score([5, 3, 6, 6, 5], "PAIR"))


def test_two_pair(calculator):
    assert (16 == calculator.score([3, 3, 5, 4, 5], "TWO_PAIRS"))
    assert (16 == calculator.score([3, 3, 5, 5, 5], "TWO_PAIRS"))


def test_three_of_a_kind(calculator):
    assert (9 == calculator.score([3, 3, 3, 4, 5], "THREE_OF_A_KIND"))
    assert (15 == calculator.score([5, 3, 5, 4, 5], "THREE_OF_A_KIND"))
    assert (9 == calculator.score([3, 3, 3, 3, 5], "THREE_OF_A_KIND"))


def test_four_of_a_knd(calculator):
    assert (12 == calculator.score([3, 3, 3, 3, 5], "FOUR_OF_A_KIND"))
    assert (20 == calculator.score([5, 5, 5, 4, 5], "FOUR_OF_A_KIND"))
    assert (12 == calculator.score([3, 3, 3, 3, 3], "FOUR_OF_A_KIND"))


def test_smallStraight(calculator):
    assert (15 == calculator.score([1, 2, 3, 4, 5], "SMALL_STRAIGHT"))
    assert (15 == calculator.score([2, 3, 4, 5, 1], "SMALL_STRAIGHT"))
    assert (0 == calculator.score([1, 2, 2, 4, 5], "SMALL_STRAIGHT"))


def test_largeStraight(calculator):
    assert (20 == calculator.score([6, 2, 3, 4, 5], "LARGE_STRAIGHT"))
    assert (20 == calculator.score([2, 3, 4, 5, 6], "LARGE_STRAIGHT"))
    assert (0 == calculator.score([1, 2, 2, 4, 5], "LARGE_STRAIGHT"))


def test_fullHouse(calculator):
    assert (18 == calculator.score([6, 2, 2, 2, 6], "FULL_HOUSE"))
    assert (0 == calculator.score([2, 3, 4, 5, 6], "FULL_HOUSE"))
