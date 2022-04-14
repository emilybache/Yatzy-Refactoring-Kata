#include <gtest/gtest.h>

#include "yatzy.hpp"

using namespace std;

static int *ints(int a, int b, int c, int d, int e) {
    int *r = new int[5];
    r[0] = a;
    r[1] = b;
    r[2] = c;
    r[3] = d;
    r[4] = e;
    return r;
}

TEST(YatzyTest, ChanceScoresSumOfAllDice) {
    int expected = 15;
    int actual = Yatzy().Chance(2, 3, 4, 5, 1);
    EXPECT_EQ(expected, actual);
    EXPECT_EQ(16, Yatzy().Chance(3, 3, 4, 5, 1));
}

TEST(YatzyTest, YatzyScores50) {
    int expected = 50;
    int actual = Yatzy().yatzy(ints(4, 4, 4, 4, 4));
    EXPECT_EQ(expected, actual);
    EXPECT_EQ(50, Yatzy().yatzy(ints(6, 6, 6, 6, 6)));
    EXPECT_EQ(0, Yatzy().yatzy(ints(6, 6, 6, 6, 3)));
}

TEST(YatzyTest, Test_1s) {
    EXPECT_EQ(Yatzy().Ones(1, 2, 3, 4, 5), 1);
    EXPECT_EQ(2, Yatzy().Ones(1, 2, 1, 4, 5));
    EXPECT_EQ(0, Yatzy().Ones(6, 2, 2, 4, 5));
    EXPECT_EQ(4, Yatzy().Ones(1, 2, 1, 1, 1));
}

TEST(YatzyTest, test_2s) {
    EXPECT_EQ(4, Yatzy().Twos(1, 2, 3, 2, 6));
    EXPECT_EQ(10, Yatzy().Twos(2, 2, 2, 2, 2));
}

TEST(YatzyTest, test_threes) {
    EXPECT_EQ(6, Yatzy().Threes(1, 2, 3, 2, 3));
    EXPECT_EQ(12, Yatzy().Threes(2, 3, 3, 3, 3));
}

TEST(YatzyTest, fours_test) {
    EXPECT_EQ(12, (new Yatzy(4, 4, 4, 5, 5))->Fours());
    EXPECT_EQ(8, (new Yatzy(4, 4, 5, 5, 5))->Fours());
    EXPECT_EQ(4, (*new Yatzy(4, 5, 5, 5, 5)).Fours());
}

TEST(YatzyTest, fives) {
    EXPECT_EQ(10, (new Yatzy(4, 4, 4, 5, 5))->Fives());
    EXPECT_EQ(15, Yatzy(4, 4, 5, 5, 5).Fives());
    EXPECT_EQ(20, Yatzy(4, 5, 5, 5, 5).Fives());
}

TEST(YatzyTest, sixes_test) {
    EXPECT_EQ(0, Yatzy(4, 4, 4, 5, 5).sixes());
    EXPECT_EQ(6, Yatzy(4, 4, 6, 5, 5).sixes());
    EXPECT_EQ(18, Yatzy(6, 5, 6, 6, 5).sixes());
}

TEST(YatzyTest, one_pair) {
    EXPECT_EQ(6, Yatzy().ScorePair(3, 4, 3, 5, 6));
    EXPECT_EQ(10, Yatzy().ScorePair(5, 3, 3, 3, 5));
    EXPECT_EQ(12, Yatzy().ScorePair(5, 3, 6, 6, 5));
}

TEST(YatzyTest, two_Pair) {
    EXPECT_EQ(16, Yatzy().TwoPair(3, 3, 5, 4, 5));
    EXPECT_EQ(16, Yatzy().TwoPair(3, 3, 5, 5, 5));
}

TEST(YatzyTest, three_of_a_kind) {
    EXPECT_EQ(9, Yatzy().ThreeOfAKind(3, 3, 3, 4, 5));
    EXPECT_EQ(15, Yatzy().ThreeOfAKind(5, 3, 5, 4, 5));
    EXPECT_EQ(9, Yatzy::ThreeOfAKind(3, 3, 3, 3, 5));
}

TEST(YatzyTest, four_of_a_kind) {
    EXPECT_EQ(12, Yatzy::FourOfAKind(3, 3, 3, 3, 5));
    EXPECT_EQ(20, Yatzy::FourOfAKind(5, 5, 5, 4, 5));
    EXPECT_EQ(12, Yatzy::FourOfAKind(3, 3, 3, 3, 3));
}

TEST(YatzyTest, smallStraight) {
    EXPECT_EQ(15, Yatzy::SmallStraight(1, 2, 3, 4, 5));
    EXPECT_EQ(15, Yatzy::SmallStraight(2, 3, 4, 5, 1));
    EXPECT_EQ(0, Yatzy().SmallStraight(1, 2, 2, 4, 5));
}

TEST(YatzyTest, largeStraight) {
    EXPECT_EQ(20, Yatzy::LargeStraight(6, 2, 3, 4, 5));
    EXPECT_EQ(20, Yatzy().LargeStraight(2, 3, 4, 5, 6));
    EXPECT_EQ(0, Yatzy::LargeStraight(1, 2, 2, 4, 5));
}

TEST(YatzyTest, fullHouse) {
    EXPECT_EQ(18, Yatzy().FullHouse(6, 2, 2, 2, 6));
    EXPECT_EQ(0, Yatzy().FullHouse(2, 3, 4, 5, 6));
}
