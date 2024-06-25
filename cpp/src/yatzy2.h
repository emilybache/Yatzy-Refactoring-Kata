#ifndef YATZY_YATZY2_H
#define YATZY_YATZY2_H

#include <unordered_map>
#include <vector>
#include <string>
#include <numeric>
#include <map>

enum class YatzyCategory {
    CHANCE, YATZY,
    ONES, TWOS, THREES, FOURS, FIVES, SIXES,
    PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND,
    SMALL_STRAIGHT, LARGE_STRAIGHT,
    TWO_PAIRS, FULL_HOUSE
};

std::ostream &operator<<(std::ostream &os, const YatzyCategory &category) {
    std::vector<std::string> categories = {"CHANCE", "YATZY", "ONES", "TWOS", "THREES", "FOURS", "FIVES", "SIXES",
                                           "PAIR", "THREE_OF_A_KIND", "FOUR_OF_A_KIND", "SMALL_STRAIGHT",
                                           "LARGE_STRAIGHT", "TWO_PAIRS", "FULL_HOUSE"};
    os << categories[static_cast<int>(category)];
    return os;
}

class Yatzy2 {
public:
    Yatzy2() {};
    const std::vector<int> DICE_VALUES = {6, 5, 4, 3, 2, 1};

    std::vector<std::string> validCategories() {
        std::vector<std::string> categories = {"CHANCE", "YATZY", "ONES", "TWOS", "THREES", "FOURS", "FIVES", "SIXES",
                                               "PAIR", "THREE_OF_A_KIND", "FOUR_OF_A_KIND", "SMALL_STRAIGHT",
                                               "LARGE_STRAIGHT", "TWO_PAIRS", "FULL_HOUSE"};
        return categories;
    }

    int score(const std::vector<int> &dice, std::string categoryName) {
        // identify category from string input
        YatzyCategory category;
        static std::unordered_map<std::string, YatzyCategory> const table = {
                {"CHANCE",          YatzyCategory::CHANCE},
                {"YATZY",           YatzyCategory::YATZY},
                {"ONES",            YatzyCategory::ONES},
                {"TWOS",            YatzyCategory::TWOS},
                {"THREES",          YatzyCategory::THREES},
                {"FOURS",           YatzyCategory::FOURS},
                {"FIVES",           YatzyCategory::FIVES},
                {"SIXES",           YatzyCategory::SIXES},
                {"PAIR",            YatzyCategory::PAIR},
                {"THREE_OF_A_KIND", YatzyCategory::THREE_OF_A_KIND},
                {"FOUR_OF_A_KIND",  YatzyCategory::FOUR_OF_A_KIND},
                {"SMALL_STRAIGHT",  YatzyCategory::SMALL_STRAIGHT},
                {"LARGE_STRAIGHT",  YatzyCategory::LARGE_STRAIGHT},
                {"TWO_PAIRS",       YatzyCategory::TWO_PAIRS},
                {"FULL_HOUSE",      YatzyCategory::FULL_HOUSE}
        };
        auto it = table.find(categoryName);
        if (it != table.end()) {
            category = it->second;
        } else { return -1; }

        // Calculate dice frequencies
        std::map<int, int> diceFrequencies;
        for (int i: DICE_VALUES) {
            diceFrequencies[i] = 0;
        }
        for (int die: dice) {
            diceFrequencies[die]++;
        }

        // Calculate the score
        int result = 0;
        switch (category) {
            case YatzyCategory::CHANCE:
                // Chance sums the dice
                result = std::accumulate(dice.begin(), dice.end(), 0);
                break;

            case YatzyCategory::YATZY: {
                // Score for Yatzy if all dice are the same
                int yatzyResult = 0;
                for (std::map<int, int>::iterator iter = diceFrequencies.begin();
                     iter != diceFrequencies.end(); ++iter) {
                    if (iter->second >= 5) {
                        yatzyResult = 50;
                    }
                }
                result = yatzyResult;
            }
                break;

            case YatzyCategory::ONES:
                // sum all the ones
                result = diceFrequencies[1];
                break;
            case YatzyCategory::TWOS:
                // sum all the twos
                result = diceFrequencies[2] * 2;
                break;
            case YatzyCategory::THREES:
                // sum all the threes
                result = diceFrequencies[3] * 3;
                break;
            case YatzyCategory::FOURS:
                // sum all the fours
                result = diceFrequencies[4] * 4;
                break;
            case YatzyCategory::FIVES:
                // sum all the fives
                result = diceFrequencies[5] * 5;
                break;
            case YatzyCategory::SIXES:
                // sum all the sixes
                result = diceFrequencies[6] * 6;
                break;
            case YatzyCategory::PAIR:
            {
                // score pair if two dice are the same
                int pairResult = 0;
                // score highest pair if there is more than one
                for (const int i : DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 2)
                    {
                        pairResult = i * 2;
                        break;
                    }
                }

                result = pairResult;
            }
                break;
            case YatzyCategory::THREE_OF_A_KIND:
            {
                // score if three dice are the same
                int threeKindResult = 0;
                for (const int i : DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 3)
                    {
                        threeKindResult = i * 3;
                        break;
                    }
                }

                result = threeKindResult;
            }
                break;
            case YatzyCategory::FOUR_OF_A_KIND:
            {
                // score if four dice are the same
                int fourKindResult = 0;
                for (const int i : DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 4)
                    {
                        fourKindResult = i * 4;
                        break;
                    }
                }

                result = fourKindResult;
            }
                break;
            case YatzyCategory::SMALL_STRAIGHT:
            {
                // score if dice contains 1,2,3,4,5
                int smallStraightResult = 0;
                long count = 0L;
                for (std::map<int, int>::iterator iter = diceFrequencies.begin();
                     iter != diceFrequencies.end(); ++iter) {
                    if (iter->second == 1) {
                        count++;
                    }
                }

                if (count == 5 && diceFrequencies[6] == 0)
                {
                    for (const int die : dice)
                    {
                        smallStraightResult += die;
                    }
                }

                result = smallStraightResult;
            }
                break;
            case YatzyCategory::LARGE_STRAIGHT:
            {
                // score if dice contains 2,3,4,5,6
                int smallStraightResult = 0;
                long count = 0L;
                for (std::map<int, int>::iterator iter = diceFrequencies.begin();
                     iter != diceFrequencies.end(); ++iter) {
                    if (iter->second == 1) {
                        count++;
                    }
                }

                if (count == 5 && diceFrequencies[1] == 0)
                {
                    for (const int die : dice)
                    {
                        smallStraightResult += die;
                    }
                }

                result = smallStraightResult;
            }
                break;
            case YatzyCategory::TWO_PAIRS:
            {
                // score if there are two pairs
                int twoPairResult = 0;
                long pairCount = 0L;
                for (std::map<int, int>::iterator iter = diceFrequencies.begin();
                     iter != diceFrequencies.end(); ++iter) {
                    if (iter->second >= 2) {
                        pairCount++;
                    }
                }

                if (pairCount == 2)
                {
                    for (const int i : DICE_VALUES)
                    {
                        if (diceFrequencies[i] >= 2)
                        {
                            twoPairResult += i * 2;
                        }
                    }
                }

                result = twoPairResult;
            }
                break;
            case YatzyCategory::FULL_HOUSE:
            {
                // score if there is a pair as well as three of a kind
                int fullHouseResult = 0;
                int pairCount = 0;
                int threeCount = 0;
                for (std::map<int, int>::iterator iter = diceFrequencies.begin();
                     iter != diceFrequencies.end(); ++iter) {
                    if (iter->second == 2) {
                        pairCount++;
                    }
                    if (iter->second == 3) {
                        threeCount++;
                    }
                }

                if (pairCount == 1 && threeCount == 1)
                {
                    for (const int die : dice)
                    {
                        fullHouseResult += die;
                    }
                }

                result = fullHouseResult;
            }
                break;
        }

        return result;
    }
};

#endif //YATZY_YATZY2_H
