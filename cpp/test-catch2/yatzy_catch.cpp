#include <iostream>
#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"
#include "yatzy1.hpp"
#include "yatzy2.h"

static int *ints(int a, int b, int c, int d, int e) {
    int *r = new int[5];
    r[0] = a;
    r[1] = b;
    r[2] = c;
    r[3] = d;
    r[4] = e;
    return r;
}

TEST_CASE ("Yatzy") {
    SECTION("Chance scores sum of all dice")
    {
        int expected = 15;
        int actual = Yatzy1().Chance(2, 3, 4, 5, 1);
        CHECK(expected == actual);
        CHECK(16 == Yatzy1().Chance(3, 3, 4, 5, 1));
    }
    SECTION("Yatzy scores 50") {
        int expected = 50;
        int actual = Yatzy1().yatzy(ints(4, 4, 4, 4, 4));
        CHECK(expected == actual);
        CHECK(50 == Yatzy1().yatzy(ints(6, 6, 6, 6, 6)));
        CHECK(0 == Yatzy1().yatzy(ints(6, 6, 6, 6, 3)));
    }
    SECTION("Test 1s")
    {
        CHECK(Yatzy1().Ones(1, 2, 3, 4, 5) == 1);
        CHECK(2 == Yatzy1().Ones(1, 2, 1, 4, 5));
        CHECK(0 == Yatzy1().Ones(6, 2, 2, 4, 5));
        CHECK(4 == Yatzy1().Ones(1, 2, 1, 1, 1));
    }
    SECTION("test 2s")
    {
        CHECK(4 == Yatzy1().Twos(1, 2, 3, 2, 6));
        CHECK(10 == Yatzy1().Twos(2, 2, 2, 2, 2));
    }
    SECTION("test threes")
    {
        CHECK(6 == Yatzy1().Threes(1, 2, 3, 2, 3));
        CHECK(12 == Yatzy1().Threes(2, 3, 3, 3, 3));
    }
    SECTION("fours test")
    {
        CHECK(12 == (new Yatzy1(4, 4, 4, 5, 5))->Fours());
        CHECK(8 == (new Yatzy1(4, 4, 5, 5, 5))->Fours());
        CHECK(4 == (*new Yatzy1(4, 5, 5, 5, 5)).Fours());
    }
    SECTION("fives")
    {
        CHECK(10 == (new Yatzy1(4, 4, 4, 5, 5))->Fives());
        CHECK(15 == Yatzy1(4, 4, 5, 5, 5).Fives());
        CHECK(20 == Yatzy1(4, 5, 5, 5, 5).Fives());
    }
    SECTION("sixes test")
    {
        CHECK(0 == Yatzy1(4, 4, 4, 5, 5).sixes());
        CHECK(6 == Yatzy1(4, 4, 6, 5, 5).sixes());
        CHECK(18 == Yatzy1(6, 5, 6, 6, 5).sixes());
    }
    SECTION("one pair")
    {
        CHECK(6 == Yatzy1().ScorePair(3, 4, 3, 5, 6));
        CHECK(10 == Yatzy1().ScorePair(5, 3, 3, 3, 5));
        CHECK(12 == Yatzy1().ScorePair(5, 3, 6, 6, 5));
    }
    SECTION("two Pair")
    {
        CHECK(16 == Yatzy1().TwoPair(3, 3, 5, 4, 5));
        CHECK(16 == Yatzy1().TwoPair(3, 3, 5, 5, 5));
    }
    SECTION("three of a kind")
    {
        CHECK(9 == Yatzy1().ThreeOfAKind(3, 3, 3, 4, 5));
        CHECK(15 == Yatzy1().ThreeOfAKind(5, 3, 5, 4, 5));
        CHECK(9 == Yatzy1::ThreeOfAKind(3, 3, 3, 3, 5));
    }
    SECTION("four of a kind")
    {
        CHECK(12 == Yatzy1::FourOfAKind(3, 3, 3, 3, 5));
        CHECK(20 == Yatzy1::FourOfAKind(5, 5, 5, 4, 5));
        CHECK(12 == Yatzy1::FourOfAKind(3, 3, 3, 3, 3));
    }
    SECTION("smallStraight")
    {
        CHECK(15 == Yatzy1::SmallStraight(1, 2, 3, 4, 5));
        CHECK(15 == Yatzy1::SmallStraight(2, 3, 4, 5, 1));
        CHECK(0 == Yatzy1().SmallStraight(1, 2, 2, 4, 5));
    }
    SECTION("largeStraight")
    {
        CHECK(20 == Yatzy1::LargeStraight(6, 2, 3, 4, 5));
        CHECK(20 == Yatzy1().LargeStraight(2, 3, 4, 5, 6));
        CHECK(0 == Yatzy1::LargeStraight(1, 2, 2, 4, 5));
    }
    SECTION("fullHouse")
    {
        CHECK(18 == Yatzy1().FullHouse(6, 2, 2, 2, 6));
        CHECK(0 == Yatzy1().FullHouse(2, 3, 4, 5, 6));
    }
}

// implemet function doYatzy2
static int doYatzy2(YatzyCategory category, int d1, int d2, int d3, int d4, int d5) {
    std::vector<int> dice{d1, d2, d3, d4, d5};
    std::cout << "Category: " << static_cast<int>(category) << " Dice: ";
    // flush the output
    std::cout.flush();
    return Yatzy2().score(dice, category);
}



TEST_CASE ("Yatzy2") {
    std::vector<int> dice{1, 2, 3, 4, 5, 6};
    std::vector<YatzyCategory> categories{YatzyCategory::CHANCE,
                                          YatzyCategory::YATZY, YatzyCategory::ONES,
                                             YatzyCategory::TWOS, YatzyCategory::THREES, YatzyCategory::FOURS,
                                             YatzyCategory::FIVES, YatzyCategory::SIXES, YatzyCategory::PAIR,
                                             YatzyCategory::TWO_PAIRS,
                                             YatzyCategory::THREE_OF_A_KIND,
                                             YatzyCategory::FOUR_OF_A_KIND, YatzyCategory::SMALL_STRAIGHT,
                                             YatzyCategory::LARGE_STRAIGHT, YatzyCategory::FULL_HOUSE};
    ApprovalTests::CombinationApprovals::verifyAllCombinations("Yatzy2",
                                                               [](YatzyCategory c, int d1, int d2, int d3, int d4, int d5) { return doYatzy2(c,d1,d2,d3,d4,d5); },
                                                               categories,dice, dice, dice, dice, dice);
}
