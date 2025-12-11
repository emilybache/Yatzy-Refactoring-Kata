from yatzy1 import Yatzy


def test_1():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)

def test_chance():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)

def test_chance_sums_the_dice():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)

def test_score_chance_sums_dice():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)

def test_given_all_ones_score_chance_returns_5():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)

def test_score__any_dice_on_chance__gives_sum():
    assert 5 == Yatzy.chance(1, 1, 1, 1, 1)
