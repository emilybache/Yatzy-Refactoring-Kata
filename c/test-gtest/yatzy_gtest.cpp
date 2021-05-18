#include <gtest/gtest.h>
#include "ApprovalTests.hpp"

extern "C"
{
#include "yatzy.h"
}

using namespace std;

ostream& operator<<(ostream& ss, const Yatzy& roll)
{
    ss << "Roll [";

    bool first = true;
    for (int i = 0; i < 5; ++i) {
        if (first)
            first = false;
        else
            ss << ", ";
        ss << roll.dice[i];
    }

    ss << "]";
    return ss;
}


string printCategory(int category) {
    switch (category) {
        case CHANCE:
            return "Chance";
        case YATZY:
            return "Yatzy";
        case ONES:
            return "Ones";
        case TWOS:
            return "Twos";
        case THREES:
            return "Threes";
        case FOURS:
            return "Fours";
        case FIVES:
            return "Fives";
        case SIXES:
            return "Sixes";
        case PAIR:
            return "Pair";
        case TWO_PAIRS:
            return "Two Pairs";
        case THREE_OF_A_KIND:
            return "Three of a kind";
        case FOUR_OF_A_KIND:
            return "Four of a kind";
        case SMALL_STRAIGHT:
            return "Small Straight";
        case LARGE_STRAIGHT:
            return "Large Straight";
        case FULL_HOUSE:
            return "Full House";
        default:
            return "";
    }
}

ostream& operator<<(ostream& ss, const category& category)
{
    ss << printCategory(category);
    return ss;
}

Yatzy *roll_factory(int d1, int d2, int d3, int d4, int _5) {
    Yatzy *yatzy = static_cast<Yatzy *>(malloc(sizeof(Yatzy)));
    int *dice = static_cast<int *>(malloc(5 * sizeof(int)));
    dice[0] = d1;
    dice[1] = d2;
    dice[2] = d3;
    dice[3] = d4;
    dice[4] = _5;
    yatzy->dice = dice;
    return yatzy;
}

TEST(Yatzy, YatzyCategoriesCombinations)
{
    vector<Yatzy> rolls = {
            *roll_factory(2, 3, 4, 5, 1),
            *roll_factory(4, 3, 4, 5, 1),
            *roll_factory(3, 3, 3, 3, 3),
            *roll_factory(2, 2, 1, 1, 1),
            *roll_factory(2, 6, 5, 6, 5),
            *roll_factory(2, 6, 5, 3, 4),

    };
    vector<category> categories = {CHANCE, YATZY,
                                   ONES, TWOS, THREES, FOURS, FIVES, SIXES,
                                   PAIR, TWO_PAIRS, THREE_OF_A_KIND, FOUR_OF_A_KIND,
                                   SMALL_STRAIGHT, LARGE_STRAIGHT, FULL_HOUSE};

    auto f = [](Yatzy roll, category category) {
        return score(&roll, category);
    };

    ApprovalTests::CombinationApprovals::verifyAllCombinations(f, rolls, categories);
}
