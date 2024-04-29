namespace Yatzy2;

public class Yatzy2
{
    static readonly List<int> DICE_VALUES = new List<int> { 6, 5, 4, 3, 2, 1 };

    public List<string> ValidCategories()
    {
        return Enum.GetNames(typeof(YatzyCategory)).ToList();
    }

    public int Score(List<int> dice, string categoryName)
    {
        YatzyCategory category = (YatzyCategory)Enum.Parse(typeof(YatzyCategory), categoryName);

        // calculate dice frequencies
        Dictionary<int, int> diceFrequencies = new Dictionary<int, int>();
        foreach (int i in DICE_VALUES)
        {
            diceFrequencies[i] = 0;
        }
        foreach (int die in dice)
        {
            diceFrequencies[die]++;
        }
        
        // calculate the score
        int result;
        switch (category)
        {
            case YatzyCategory.CHANCE:

                // chance sums the dice
                result = dice.Sum();
                break;

            case YatzyCategory.YATZY:

                // score for yatzy if all dice are the same
                int yatzyResult = 0;
                if (diceFrequencies.ContainsValue(5))
                {
                    yatzyResult = 50;
                }

                result = yatzyResult;
                break;

            case YatzyCategory.ONES:
                // sum all the ones
                result = diceFrequencies[1];
                break;

            case YatzyCategory.TWOS:
                // sum all the twos
                result = diceFrequencies[2] * 2;
                break;

            case YatzyCategory.THREES:
                // sum all the threes
                result = diceFrequencies[3] * 3;
                break;

            case YatzyCategory.FOURS:
                // sum all the fours
                result = diceFrequencies[4] * 4;
                break;

            case YatzyCategory.FIVES:
                // sum all the fives
                result = diceFrequencies[5] * 5;
                break;

            case YatzyCategory.SIXES:
                // sum all the sixes
                result = diceFrequencies[6] * 6;
                break;

            case YatzyCategory.PAIR:

                // score pair if two dice are the same
                int pairResult = 0;
                // score highest pair if there is more than one
                foreach (int i in DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 2)
                    {
                        pairResult = i * 2;
                        break;
                    }
                }

                result = pairResult;
                break;

            case YatzyCategory.THREE_OF_A_KIND:

                // score if three dice are the same
                int threeKindResult = 0;
                foreach (int i in DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 3)
                    {
                        threeKindResult = i * 3;
                        break;
                    }
                }

                result = threeKindResult;
                break;

            case YatzyCategory.FOUR_OF_A_KIND:

                // score if four dice are the same
                int fourKindResult = 0;
                foreach (int i in DICE_VALUES)
                {
                    if (diceFrequencies[i] >= 4)
                    {
                        fourKindResult = i * 4;
                        break;
                    }
                }

                result = fourKindResult;
                break;

            case YatzyCategory.SMALL_STRAIGHT:

                // score if dice contains 1,2,3,4,5
                int smallStraightResult = 0;
                long count = 0L;
                foreach (int frequency in diceFrequencies.Values)
                {
                    if (frequency == 1)
                    {
                        count++;
                    }
                }

                if (count == 5 && diceFrequencies[6] == 0)
                {
                    foreach (int die in dice)
                    {
                        smallStraightResult += die;
                    }
                }

                result = smallStraightResult;
                break;

            case YatzyCategory.LARGE_STRAIGHT:

                // score if dice contains 2,3,4,5,6
                int largeStraightResult = 0;
                long straightCount = 0L;
                foreach (int frequency in diceFrequencies.Values)
                {
                    if (frequency == 1)
                    {
                        straightCount++;
                    }
                }

                if (straightCount == 5 && diceFrequencies[1] == 0)
                {
                    foreach (int die in dice)
                    {
                        largeStraightResult += die;
                    }
                }

                result = largeStraightResult;
                break;

            case YatzyCategory.TWO_PAIRS:

                // score if there are two pairs
                int twoPairResult = 0;
                long pairCount = 0L;
                foreach (int frequency in diceFrequencies.Values)
                {
                    if (frequency >= 2)
                    {
                        pairCount++;
                    }
                }

                if (pairCount == 2)
                {
                    foreach (int i in DICE_VALUES)
                    {
                        if (diceFrequencies[i] >= 2)
                        {
                            twoPairResult += i * 2;
                        }
                    }
                }

                result = twoPairResult;
                break;

            case YatzyCategory.FULL_HOUSE:

                // score if there is a pair as well as three of a kind
                int fullHouseResult = 0;
                if (diceFrequencies.ContainsValue(2) && diceFrequencies.ContainsValue(3))
                {
                    foreach (int die in dice)
                    {
                        fullHouseResult += die;
                    }
                }

                result = fullHouseResult;
                break;

            default:
                result = 0;
                break;
        }

        return result;
    }
}