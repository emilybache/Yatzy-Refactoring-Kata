#include <gtest/gtest.h>

extern "C"
{
#include "yatzy.h"
}

using namespace std;

static int* ints(int a, int b, int c, int d, int e)
{
    int * r = new int[5];
    r[0] = a;
    r[1] = b;
    r[2] = c;
    r[3] = d;
    r[4] = e;
    return r;
}

TEST(Yatzy, Chance_scores_sum_of_all_dice)
{
    ASSERT_EQ(15, Chance(2,3,4,5,1));
    ASSERT_EQ(16, Chance(3,3,4,5,1));
}

TEST(Yatzy, Yatzy_scores_50)
{
    int expected = 50;
    int actual = yatzy(ints(4,4,4,4,4));
    ASSERT_EQ(expected, actual);
    ASSERT_EQ(50, yatzy(ints(6,6,6,6,6)));
    ASSERT_EQ(0, yatzy(ints(6,6,6,6,3)));
}

TEST(Yatzy, Test_1s)
{
    ASSERT_EQ(Ones(1,2,3,4,5), 1);
    ASSERT_EQ(2, Ones(1,2,1,4,5));
    ASSERT_EQ(0, Ones(6,2,2,4,5));
    ASSERT_EQ(4, Ones(1,2,1,1,1));
}

TEST(Yatzy, test_2s)
{
    ASSERT_EQ(4, Twos(1,2,3,2,6));
    ASSERT_EQ(10, Twos(2,2,2,2,2));
}

TEST(Yatzy, test_threes)
{
    ASSERT_EQ(6, Threes(1,2,3,2,3));
    ASSERT_EQ(12, Threes(2,3,3,3,3));
}

TEST(Yatzy, fours_test)
{
    ASSERT_EQ(12, Fours(yatzy_factory(4,4,4,5,5)));
    ASSERT_EQ(8, Fours(yatzy_factory(4,4,5,5,5)));
    ASSERT_EQ(4, Fours(yatzy_factory(4,5,5,5,5)));
}

TEST(Yatzy, fives)
{
    ASSERT_EQ(10, Fives(yatzy_factory(4,4,4,5,5)));
    ASSERT_EQ(15, Fives(yatzy_factory(4,4,5,5,5)));
    ASSERT_EQ(20, Fives(yatzy_factory(4,5,5,5,5)));
}

TEST(Yatzy, sixes_test)
{
    ASSERT_EQ(0, sixes(yatzy_factory(4,4,4,5,5)));
    ASSERT_EQ(6, sixes(yatzy_factory(4,4,6,5,5)));
    ASSERT_EQ(18, sixes(yatzy_factory(6,5,6,6,5)));
}

TEST(Yatzy, one_pair)
{
    ASSERT_EQ(6, ScorePair(nullptr, 3,4,3,5,6));
    ASSERT_EQ(10, ScorePair(nullptr, 5,3,3,3,5));
    ASSERT_EQ(12, ScorePair(nullptr, 5,3,6,6,5));
}

TEST(Yatzy, two_Pair)
{
    ASSERT_EQ(16, TwoPair(nullptr, 3,3,5,4,5));
    ASSERT_EQ(16, TwoPair(nullptr, 3,3,5,5,5));
}

TEST(Yatzy, three_of_a_kind)
{
    ASSERT_EQ(9, ThreeOfAKind(nullptr, 3,3,3,4,5));
    ASSERT_EQ(15, ThreeOfAKind(nullptr, 5,3,5,4,5));
    ASSERT_EQ(9, ThreeOfAKind(yatzy_factory(3,3,3,3,5), 3,3,3,3,5));
}

TEST(Yatzy, four_of_a_knd)
{
    ASSERT_EQ(12, FourOfAKind(nullptr, 3,3,3,3,5));
    ASSERT_EQ(20, FourOfAKind(yatzy_factory(5,5,5,4,5), 5,5,5,4,5));
    ASSERT_EQ(12 , FourOfAKind(nullptr, 3,3,3,3,3));
}

TEST(Yatzy, smallStraight)
{
    ASSERT_EQ(15, SmallStraight(nullptr, 1,2,3,4,5));
    ASSERT_EQ(15, SmallStraight(nullptr, 2,3,4,5,1));
    ASSERT_EQ(0, SmallStraight(nullptr, 1,2,2,4,5));
}

TEST(Yatzy, largeStraight)
{
    ASSERT_EQ(20, LargeStraight(nullptr, 6,2,3,4,5));
    ASSERT_EQ(20, LargeStraight(nullptr, 2,3,4,5,6));
    ASSERT_EQ(0,  LargeStraight(nullptr, 1,2,2,4,5));
}


TEST(Yatzy, fullHouse)
{
    ASSERT_EQ(18, FullHouse(yatzy_factory(5,5,5,4,5), 6,2,2,2,6));
    ASSERT_EQ(0, FullHouse(nullptr, 2,3,4,5,6));
}
