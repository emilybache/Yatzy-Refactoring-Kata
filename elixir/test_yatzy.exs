ExUnit.start

defmodule YatzyTest do
  use ExUnit.Case

  test "chance scores sum of all dice" do
    expected = 15
    actual = Yatzy.chance(2,3,4,5,1)
    assert expected == actual
    assert 16 == Yatzy.chance(3,3,4,5,1)
  end

  test "yatzy scores 50" do
    expected = 50
    actual = Yatzy.yatzy([4,4,4,4,4])
    assert expected == actual
    assert 50 = Yatzy.yatzy([6,6,6,6,6])
    assert 0 == Yatzy.yatzy([6,6,6,6,3])
  end

  test "1s" do
    assert 1 == Yatzy.ones(1,2,3,4,5)
    assert 2 == Yatzy.ones(1,2,1,4,5)
    assert 0 == Yatzy.ones(6,2,2,4,5)
    assert 4 == Yatzy.ones(1,2,1,1,1)
  end

  test "2s" do
    assert Yatzy.twos(1,2,3,2,6) == 4
    assert Yatzy.twos(2,2,2,2,2) == 10
  end

  test "threes" do
    assert 6 == Yatzy.threes(1,2,3,2,3)
    assert 12 == Yatzy.threes(2,3,3,3,3)
  end

  test "fours test" do
    assert 12 == Yatzy.fours([4,4,4,5,5])
    assert 8 == Yatzy.fours([4,4,5,5,5])
    assert 4 == Yatzy.fours([4,5,5,5,5])
  end

  test "fives()" do
    assert 10 == Yatzy.fives([4,4,4,5,5])
    assert 15 == Yatzy.fives([4,4,5,5,5])
    assert 20 == Yatzy.fives([4,5,5,5,5])
  end

  test "sixes test" do
    assert 0 == Yatzy.sixes(4,4,4,5,5)
    assert 6 == Yatzy.sixes(4,4,6,5,5)
    assert 18 == Yatzy.sixes(6,5,6,6,5)
  end

  test "it scores one pair" do
    assert 6 == Yatzy.score_pair(3,4,3,5,6)
    assert 10 == Yatzy.score_pair(5,3,3,3,5)
    assert 12 == Yatzy.score_pair(5,3,6,6,5)
  end

  test "it scores 2 pair" do
    assert Yatzy.two_pair(1,2,4,2,1) == 6
    assert Yatzy.two_pair(3,3,5,4,5) == 16
    assert Yatzy.two_pair(3,3,5,5,5) == 16
  end

  test "three of a kind" do
    assert 9 == Yatzy.three_of_a_kind(3,3,3,4,5)
    assert 15 == Yatzy.three_of_a_kind(5,3,5,4,5)
    assert 9 == Yatzy.three_of_a_kind(3,3,3,3,5)
  end

  test "for of a kind" do
    assert 12 == Yatzy.four_of_a_kind(3,3,3,3,5)
    assert 20 == Yatzy.four_of_a_kind(5,5,5,4,5)
    assert 9 == Yatzy.three_of_a_kind(3,3,3,3,3)
    assert 12 == Yatzy.four_of_a_kind(3,3,3,3,3)
  end

  test "it should score a small straight" do
    assert 15 == Yatzy.smallStraight(1,2,3,4,5)
    assert 15 == Yatzy.smallStraight(2,3,4,5,1)
    assert 0 == Yatzy.smallStraight(1,2,2,4,5)
  end

  test "it should score a large straight" do
    assert 20 == Yatzy.largeStraight(6,2,3,4,5)
    assert 20 == Yatzy.largeStraight(2,3,4,5,6)
    assert 0 == Yatzy.largeStraight(1,2,2,4,5)
  end

  test "it scores a full house" do
    assert 18 == Yatzy.fullHouse(6,2,2,2,6)
    assert 0 == Yatzy.fullHouse(2,3,4,5,6)
  end
end
