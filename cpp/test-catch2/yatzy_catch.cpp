#include "ApprovalTests.hpp"
#include "catch2/catch.hpp"
#include "yatzy.hpp"

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
    SECTION("Chance scores sum of all dice") {
        int expected = 15;
        int actual = Yatzy().Chance(2, 3, 4, 5, 1);
        CHECK(expected == actual);
        CHECK(16 == Yatzy().Chance(3, 3, 4, 5, 1));
    }SECTION("Yatzy scores 50") {
        int expected = 50;
        int actual = Yatzy().yatzy(ints(4, 4, 4, 4, 4));
        CHECK(expected == actual);
        CHECK(50 == Yatzy().yatzy(ints(6, 6, 6, 6, 6)));
        CHECK(0 == Yatzy().yatzy(ints(6, 6, 6, 6, 3)));
    }SECTION("Test 1s") {
        CHECK(Yatzy().Ones(1, 2, 3, 4, 5) == 1);
        CHECK(2 == Yatzy().Ones(1, 2, 1, 4, 5));
        CHECK(0 == Yatzy().Ones(6, 2, 2, 4, 5));
        CHECK(4 == Yatzy().Ones(1, 2, 1, 1, 1));
    }SECTION("test 2s") {
        CHECK(4 == Yatzy().Twos(1, 2, 3, 2, 6));
        CHECK(10 == Yatzy().Twos(2, 2, 2, 2, 2));
    }SECTION("test threes") {
        CHECK(6 == Yatzy().Threes(1, 2, 3, 2, 3));
        CHECK(12 == Yatzy().Threes(2, 3, 3, 3, 3));
    }SECTION("fours test") {
        CHECK(12 == (new Yatzy(4, 4, 4, 5, 5))->Fours());
        CHECK(8 == (new Yatzy(4, 4, 5, 5, 5))->Fours());
        CHECK(4 == (*new Yatzy(4, 5, 5, 5, 5)).Fours());
    } SECTION("fives") {
        CHECK(10 == (new Yatzy(4, 4, 4, 5, 5))->Fives());
        CHECK(15 == Yatzy(4, 4, 5, 5, 5).Fives());
        CHECK(20 == Yatzy(4, 5, 5, 5, 5).Fives());
    }SECTION("sixes test") {
        CHECK(0 == Yatzy(4, 4, 4, 5, 5).sixes());
        CHECK(6 == Yatzy(4, 4, 6, 5, 5).sixes());
        CHECK(18 == Yatzy(6, 5, 6, 6, 5).sixes());
    }SECTION("one pair") {
        CHECK(6 == Yatzy().ScorePair(3, 4, 3, 5, 6));
        CHECK(10 == Yatzy().ScorePair(5, 3, 3, 3, 5));
        CHECK(12 == Yatzy().ScorePair(5, 3, 6, 6, 5));
    } SECTION("two Pair") {
        CHECK(16 == Yatzy().TwoPair(3, 3, 5, 4, 5));
        CHECK(16 == Yatzy().TwoPair(3, 3, 5, 5, 5));
    }SECTION("three of a kind") {
        CHECK(9 == Yatzy().ThreeOfAKind(3, 3, 3, 4, 5));
        CHECK(15 == Yatzy().ThreeOfAKind(5, 3, 5, 4, 5));
        CHECK(9 == Yatzy::ThreeOfAKind(3, 3, 3, 3, 5));
    }SECTION("four of a kind") {
        CHECK(12 == Yatzy::FourOfAKind(3, 3, 3, 3, 5));
        CHECK(20 == Yatzy::FourOfAKind(5, 5, 5, 4, 5));
        CHECK(12 == Yatzy::FourOfAKind(3, 3, 3, 3, 3));
    } SECTION("smallStraight") {
        CHECK(15 == Yatzy::SmallStraight(1, 2, 3, 4, 5));
        CHECK(15 == Yatzy::SmallStraight(2, 3, 4, 5, 1));
        CHECK(0 == Yatzy().SmallStraight(1, 2, 2, 4, 5));
    }SECTION("largeStraight") {
        CHECK(20 == Yatzy::LargeStraight(6, 2, 3, 4, 5));
        CHECK(20 == Yatzy().LargeStraight(2, 3, 4, 5, 6));
        CHECK(0 == Yatzy::LargeStraight(1, 2, 2, 4, 5));
    } SECTION("fullHouse") {
        CHECK(18 == Yatzy().FullHouse(6, 2, 2, 2, 6));
        CHECK(0 == Yatzy().FullHouse(2, 3, 4, 5, 6));
    }
}

