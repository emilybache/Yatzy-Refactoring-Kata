namespace Yatzy2;

public class Yatzy2
{
    /* Notes 
     * Removed unwated code
     * Early exits if not get categoryName or empty dice 
     * DICE_VALUES converted into IReadOnlyList - need to access the elements   
     * Static methods for each calculation to improve performance
     * ALl methods are private - no need to expose them
     * Creates InitializeDiceFrequencies method to initialize the dictionary - one method to create the dictionary     * 
     * reduce duplication of code
     * removed unnecessary foreach loop and replaed with Lamda expression      * 
     */

    private static readonly IReadOnlyList<int> DICE_VALUES = new List<int> { 6, 5, 4, 3, 2, 1 };

    private static Dictionary<int, int> InitializeDiceFrequencies(IEnumerable<int> dice)
    {
        var diceFrequencies = DICE_VALUES.ToDictionary(i => i, i => 0);

        var updateDict = dice
            .GroupBy(die => die)
            .ToDictionary(group => group.Key, group => group.Count());

        updateDict.Keys
            .ToList()
            .ForEach(key => diceFrequencies[key] = updateDict[key]);

        return diceFrequencies;
    }

    private static int MultiplyDiceFrequencies(Dictionary<int, int> frequenciesDice, int value) =>
        frequenciesDice.TryGetValue(value, out int count) ? count * value : 0;

    private static int MultiplySameDiceFrequencies(Dictionary<int, int> frequenciesDice, int sameDiceNumber) =>
        DICE_VALUES
        .Where(i => frequenciesDice[i] >= sameDiceNumber)
        .Select(i => i * sameDiceNumber)
        .FirstOrDefault();
    private static int CountDiceFrequencies(Dictionary<int, int> diceFrequencies,
        Func<int, bool> predicate) =>
        diceFrequencies.Values.Count(predicate);

    private static bool CompareCountDiceFrequencies(int compareCountNo,
        Dictionary<int, int> diceFrequencies,
        Func<int, bool> predicate) =>
        CountDiceFrequencies(diceFrequencies, predicate) == compareCountNo;

    private static int CalculateStraightValue(int compareCountNo,
        int diceFrequenciesNo,
        IEnumerable<int> dice,
        Dictionary<int, int> diceFrequencies,
        Func<int, bool> predicate) =>
        (CompareCountDiceFrequencies(compareCountNo, diceFrequencies, predicate) && diceFrequencies[diceFrequenciesNo] == 0)
        ? dice.Sum()
        : 0;

    private static int CalculateTwoPairsValue(int compareCountNo,
        Dictionary<int, int> diceFrequencies,
        Func<int, bool> predicate) =>
        CompareCountDiceFrequencies(compareCountNo, diceFrequencies, predicate)
        ? DICE_VALUES.Where(i => diceFrequencies[i] >= 2).Sum(i => i * 2)
        : 0;

    private static int GetFullHouseValue(Dictionary<int, int> diceFrequencies, IEnumerable<int> dice) =>
        (diceFrequencies.ContainsValue(2) && diceFrequencies.ContainsValue(3)) ? dice.Sum() : 0;

    private static int GetScoreByCategory(YatzyCategory category, Dictionary<int, int> diceFrequencies, IEnumerable<int> dice) =>
        category switch
        {
            YatzyCategory.CHANCE => dice.Sum(),
            YatzyCategory.YATZY => diceFrequencies.ContainsValue(5) ? 50 : 0,
            YatzyCategory.ONES => MultiplyDiceFrequencies(diceFrequencies, 1),
            YatzyCategory.TWOS => MultiplyDiceFrequencies(diceFrequencies, 2),
            YatzyCategory.THREES => MultiplyDiceFrequencies(diceFrequencies, 3),
            YatzyCategory.FOURS => MultiplyDiceFrequencies(diceFrequencies, 4),
            YatzyCategory.FIVES => MultiplyDiceFrequencies(diceFrequencies, 5),
            YatzyCategory.SIXES => MultiplyDiceFrequencies(diceFrequencies, 6),
            YatzyCategory.PAIR => MultiplySameDiceFrequencies(diceFrequencies, 2),
            YatzyCategory.THREE_OF_A_KIND => MultiplySameDiceFrequencies(diceFrequencies, 3),
            YatzyCategory.FOUR_OF_A_KIND => MultiplySameDiceFrequencies(diceFrequencies, 4),
            YatzyCategory.SMALL_STRAIGHT => CalculateStraightValue(5, 6, dice, diceFrequencies, frequency => frequency == 1),
            YatzyCategory.LARGE_STRAIGHT => CalculateStraightValue(5, 1, dice, diceFrequencies, frequency => frequency == 1),
            YatzyCategory.TWO_PAIRS => CalculateTwoPairsValue(2, diceFrequencies, frequency => frequency >= 2),
            YatzyCategory.FULL_HOUSE => GetFullHouseValue(diceFrequencies, dice),
            _ => 0  // Default case if none of the above matches
        };


    /* early exits if not get categoryName */
    private static bool ScoreInputDiceValidation(IEnumerable<int> dice) =>
       dice == null || !dice.Any()
       ? throw new ArgumentException("Dice cannot be null or empty", nameof(dice))
       : true;

    /* early exits if not get categoryName */
    private static YatzyCategory ScoreInputCategoryValidation(string categoryName, IEnumerable<int> dice) =>
        ScoreInputDiceValidation(dice) && Enum.TryParse(categoryName, out YatzyCategory category)
        ? category
        : throw new ArgumentException("Invalid category name", nameof(categoryName));


    /// <summary>
    /// Calculates the score for a given set of dice and category.
    /// </summary>
    /// <param name="dice">The values of the dice.</param>
    /// <param name="categoryName">The category for scoring.</param>
    /// <returns>The score for the given dice and category.</returns>
    public int Score(IEnumerable<int> dice, string categoryName) => GetScoreByCategory(ScoreInputCategoryValidation(categoryName, dice), InitializeDiceFrequencies(dice), dice);
}