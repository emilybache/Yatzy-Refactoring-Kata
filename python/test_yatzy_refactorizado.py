from .yatzy_refactorizado import Yatzy
import pytest

# These unit tests can be run using the py.test framework
# available from http://pytest.org/

def test_chance(): # refactor name
        assert 12 == Yatzy.chance(4,4,2,1,1) # added assert
        assert 16 == Yatzy.chance(3,3,4,5,1)
        assert 20 == Yatzy.chance(4,4,5,6,1) # added assert


def test_yatzy(): # refactor name
        assert 50 == Yatzy.yatzy(6,6,6,6,6)
        assert 0 == Yatzy.yatzy(6,6,6,6,3)


def test_ones(): # refactor name
        assert 1 == Yatzy.ones(1,2,3,4,5) # added assert
        assert 2 == Yatzy.ones(1,2,1,4,5)
        assert 0 == Yatzy.ones(6,2,2,4,5)
        assert 4 == Yatzy.ones(1,2,1,1,1)


def test_twos(): # refactor name
        assert 4 == Yatzy.twos(1,2,3,2,6)
        assert 8 == Yatzy.twos(1,2,2,2,2) # added assert
        assert 10 == Yatzy.twos(2,2,2,2,2)


def test_threes():
        assert 3 == Yatzy.threes(1,2,3,4,5) # added assert
        assert 6 == Yatzy.threes(1,2,3,2,3)
        assert 12 == Yatzy.threes(2,3,3,3,3)


def test_fours(): # refactor name
        assert 12 == Yatzy.fours(4,4,4,5,5) # refactor code
        assert 8 == Yatzy.fours(4,4,5,5,5) # refactor code
        assert 4 == Yatzy.fours(4,5,5,5,5) # refactor code


def test_fives():
        assert 10 == Yatzy.fives(4,4,4,5,5) # refactor code
        assert 15 == Yatzy.fives(4,4,5,5,5) # refactor code
        assert 20 == Yatzy.fives(4,5,5,5,5) # refactor code


def test_sixes(): # refactor name
        assert 0 == Yatzy.sixes(4,4,4,5,5) # refactor code
        assert 6 == Yatzy.sixes(4,4,6,5,5) # refactor code
        assert 18 == Yatzy.sixes(6,5,6,6,5) # refactor code


def test_one_pair():
        assert 6 == Yatzy.one_pair(3,4,3,5,6) # refactor name
        assert 10 == Yatzy.one_pair(5,3,3,3,5) # refactor name
        assert 12 == Yatzy.one_pair(5,3,6,6,5) # refactor name


def test_two_pair(): # refactor name
        assert 16 == Yatzy.two_pair(3,3,5,4,5)
        assert 18 == Yatzy.two_pair(3,3,6,6,6)
        assert 0 == Yatzy.two_pair(3,3,6,5,4)


def test_three_of_a_kind():
        assert 9 == Yatzy.three_of_a_kind(3,3,3,4,5)
        assert 15 == Yatzy.three_of_a_kind(5,3,5,4,5)
        assert 9 == Yatzy.three_of_a_kind(3,3,3,3,5)


def test_four_of_a_kind(): # refactor name
        assert 12 == Yatzy.four_of_a_kind(3,3,3,3,5)
        assert 20 == Yatzy.four_of_a_kind(5,5,5,4,5)
        assert 12 == Yatzy.four_of_a_kind(3,3,3,3,3)
        assert 0  == Yatzy.four_of_a_kind(3,3,3,2,1)


def test_small_straight(): # refactor name
        assert 15 == Yatzy.small_straight(1,2,3,4,5) # refactor name
        assert 15 == Yatzy.small_straight(2,1,4,3,5) # added assert
        assert 15 == Yatzy.small_straight(2,3,4,5,1) # refactor name
        assert 0 == Yatzy.small_straight(1,2,2,4,5) # refactor name


def test_large_straight(): # refactor name
        assert 20 == Yatzy.large_straight(6,2,3,4,5) # refactor name
        assert 20 == Yatzy.large_straight(2,3,4,5,6) # refactor name
        assert 0 == Yatzy.large_straight(1,2,2,4,5) # refactor name


def test_full_house(): # refactor name
        assert 18 == Yatzy.full_house(6,2,2,2,6) # refactor name
        assert 0 == Yatzy.full_house(2,3,4,5,6) # refactor name

