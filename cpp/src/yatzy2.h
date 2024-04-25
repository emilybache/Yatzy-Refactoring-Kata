//
// Created by LLEWELLYN FALCO on 4/25/24.
//

#ifndef YATZY_YATZY2_H
#define YATZY_YATZY2_H

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
std::ostream& operator<<(std::ostream& os, const YatzyCategory& category)
{
    std::vector<std::string> categories = {"CHANCE", "YATZY", "ONES", "TWOS", "THREES", "FOURS", "FIVES", "SIXES",
                                           "PAIR", "THREE_OF_A_KIND", "FOUR_OF_A_KIND", "SMALL_STRAIGHT",
                                           "LARGE_STRAIGHT", "TWO_PAIRS", "FULL_HOUSE"};
    os << categories[static_cast<int>(category)];
    return os;
}
class Yatzy2 {
public:
    const std::vector<int> DICE_VALUES = {6, 5, 4, 3, 2, 1};

    std::vector<std::string> validCategories() {
        std::vector<std::string> categories = {"CHANCE", "YATZY", "ONES", "TWOS", "THREES", "FOURS", "FIVES", "SIXES",
                                               "PAIR", "THREE_OF_A_KIND", "FOUR_OF_A_KIND", "SMALL_STRAIGHT",
                                               "LARGE_STRAIGHT", "TWO_PAIRS", "FULL_HOUSE"};
        return categories;
    }

    int score(const std::vector<int> &dice, YatzyCategory category) {
        int result = 0;
        std::map<int, int> freq = frequencies(dice);
        switch (category) {
            case YatzyCategory::CHANCE:
                result = std::accumulate(dice.begin(), dice.end(), 0);
                break;
            case YatzyCategory::YATZY:
                for (const auto &f: freq)
                    if (f.second == 5)
                        return 50;
                break;
            case YatzyCategory::ONES:
            case YatzyCategory::TWOS:
            case YatzyCategory::THREES:
            case YatzyCategory::FOURS:
            case YatzyCategory::FIVES:
            case YatzyCategory::SIXES:
                result = freq[static_cast<int>(category)-1] * (static_cast<int>(category)-1);
                if (result < 0) result = 0;
                break;
            case YatzyCategory::PAIR:
            case YatzyCategory::THREE_OF_A_KIND:
            case YatzyCategory::FOUR_OF_A_KIND:
                for (int value: DICE_VALUES) {
                    if (freq[value] >= static_cast<int>(category) - static_cast<int>(YatzyCategory::PAIR) + 2) {
                        result = value * (static_cast<int>(category) - static_cast<int>(YatzyCategory::PAIR) + 2);
                        break;
                    }
                }
                break;
            case YatzyCategory::SMALL_STRAIGHT:
            case YatzyCategory::LARGE_STRAIGHT:
                if (isStraight(freq, category == YatzyCategory::SMALL_STRAIGHT)) {
                    result = std::accumulate(dice.begin(), dice.end(), 0);
                }
                break;
            case YatzyCategory::TWO_PAIRS:
            case YatzyCategory::FULL_HOUSE:
                result = calculateSpecialScores(freq, category);
                break;
        }
        return result;
    }

private:
    std::map<int, int> frequencies(const std::vector<int> &dice) {
        std::map<int, int> freq;
        for (int die: dice) freq[die]++;
        return freq;
    }

    bool isStraight( std::map<int, int> &freq, bool small) {
        int start = small ? 1 : 2;
        int end = small ? 5 : 6;
        for (int i = start; i <= end; ++i) {
            if (freq[i] != 1) return false;
        }
        return true;
    }

    int calculateSpecialScores( std::map<int, int> &freq, YatzyCategory category) {
        int result = 0;
        switch (category) {
            case YatzyCategory::TWO_PAIRS:
            {
                int pairCount = 0;
                for (int value: DICE_VALUES) {
                    if (freq[value] >= 2) {
                        result += 2 * value;
                        pairCount++;
                        if (pairCount == 2) break;
                    }
                }
                if (pairCount != 2) result = 0;
                break;
            }

            case YatzyCategory::FULL_HOUSE:{
                bool foundThree = false, foundTwo = false;
                for (const auto &f: freq) {
                    if (f.second == 3) foundThree = true;
                    if (f.second == 2) foundTwo = true;
                }
                if (!foundThree || !foundTwo) result = 0;
                break;
            }
            default:
                break;
        }
        return result;

    }
};

#endif //YATZY_YATZY2_H
