#include <gtest/gtest.h>
#include "ApprovalTests.hpp"

extern "C"
{
#include "yatzy.h"
}

using namespace std;

string printRoll(const Yatzy* roll) {
    stringstream ss = stringstream();
    ss << "Roll [";

    bool first = true;
    for (int i = 0; i < 5; ++i) {
        if (first)
            first = false;
        else
            ss << ", ";
        ss << roll->dice[i];
    }

    ss << "]";
    return ss.str();
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

Yatzy *roll_factory(int *d) {
    Yatzy *yatzy = static_cast<Yatzy *>(malloc(sizeof(Yatzy)));
    int *dice = static_cast<int *>(malloc(5 * sizeof(int)));
    dice[0] = d[0];
    dice[1] = d[1];
    dice[2] = d[2];
    dice[3] = d[3];
    dice[4] = d[4];
    yatzy->dice = dice;
    return yatzy;
}

TEST(Yatzy, YatzyCategories)
{
    int totalRolls = 2;
    int rolls[][5] = {
            {2, 3, 4, 5, 1},
            {4, 3, 4, 5, 1}
    };

    stringstream ss = stringstream();
    for (int i = 0; i < totalRolls; ++i) {
        Yatzy *yatzy = roll_factory(rolls[i]);

        ss << printRoll(yatzy) << "\n";
        ss << "   " << printCategory(CHANCE) << ": " << score(yatzy, CHANCE) << "\n";
        // TODO: the other categories

        ss << "\n";
    }

    ApprovalTests::Approvals::verify(ss.str());
}
