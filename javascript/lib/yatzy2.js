const YatzyCategory = Object.freeze({
    CHANCE: 'CHANCE',
    YATZY: 'YATZY',
    ONES: 'ONES',
    TWOS: 'TWOS',
    THREES: 'THREES',
    FOURS: 'FOURS',
    FIVES: 'FIVES',
    SIXES: 'SIXES',
    PAIR: 'PAIR',
    THREE_OF_A_KIND: 'THREE_OF_A_KIND',
    FOUR_OF_A_KIND: 'FOUR_OF_A_KIND',
    SMALL_STRAIGHT: 'SMALL_STRAIGHT',
    LARGE_STRAIGHT: 'LARGE_STRAIGHT',
    TWO_PAIRS: 'TWO_PAIRS',
    FULL_HOUSE: 'FULL_HOUSE'
});


var Yatzy = function () {
    this.score = function (dice, categoryName) {
        const category = YatzyCategory[categoryName];

        // Calculate dice frequencies
        const DICE_VALUES = [6, 5, 4, 3, 2, 1];
        const diceFrequencies = {};
        for (const i of DICE_VALUES) {
            diceFrequencies[i] = 0;
        }
        for (const die of dice) {
            diceFrequencies[die] = (diceFrequencies[die] || 0) + 1;
        }

        // Calculate the score
        let result;
        switch (category) {
            case YatzyCategory.CHANCE:
                // Chance sums the dice
                result = dice.reduce((acc, die) => acc + die, 0);
                break;

            case YatzyCategory.YATZY:
                // Score for Yatzy if all dice are the same
                let yatzyResult = 0;
                if (Object.values(diceFrequencies).includes(5)) {
                    yatzyResult = 50;
                }
                result = yatzyResult;
                break;

            case YatzyCategory.ONES:
                // sum all the ones
                result = diceFrequencies[1];
                break;

            case YatzyCategory.TWOS:
                // Sum all the twos
                result = diceFrequencies[2] * 2;
                break;

            case YatzyCategory.THREES:
                // Sum all the threes
                result = diceFrequencies[3] * 3;
                break;

            case YatzyCategory.FOURS:
                // Sum all the fours
                result = diceFrequencies[4] * 4;
                break;

            case YatzyCategory.FIVES:
                // Sum all the fives
                result = diceFrequencies[5] * 5;
                break;

            case YatzyCategory.SIXES:
                // Sum all the sixes
                result = diceFrequencies[6] * 6;
                break;

            case YatzyCategory.PAIR:
                // score pair if two dice are the same
                let pairResult = 0;
                // score highest pair if there is more than one
                for (const i of DICE_VALUES) {
                    if (diceFrequencies[i] >= 2) {
                        pairResult = i * 2;
                        break;
                    }
                }
                result = pairResult;
                break;

            case YatzyCategory.THREE_OF_A_KIND:
                // score if three dice are the same
                let threeKindResult = 0;
                for (const i of DICE_VALUES) {
                    if (diceFrequencies[i] >= 3) {
                        threeKindResult = i * 3;
                        break;
                    }
                }
                result = threeKindResult;
                break;
            case YatzyCategory.FOUR_OF_A_KIND:
                // score if four dice are the same
                let fourKindResult = 0;
                for (const i of DICE_VALUES) {
                    if (diceFrequencies[i] >= 4) {
                        fourKindResult = i * 4;
                        break;
                    }
                }

                result = fourKindResult;
                break;

            case YatzyCategory.SMALL_STRAIGHT:
                // score if dice contains 1,2,3,4,5
                let smallStraightResult = 0;
                let count = 0;
                for (const frequency of Object.values(diceFrequencies)) {
                    if (frequency === 1) {
                        count++;
                    }
                }
                if (count === 5 && diceFrequencies[6] === 0) {
                    for (const die of dice) {
                        smallStraightResult += die;
                    }
                }
                result = smallStraightResult;
                break;
            case YatzyCategory.LARGE_STRAIGHT:
                // score if dice contains 2,3,4,5,6
                let largeStraightResult = 0;
                let straightCount = 0;
                for (const frequency of Object.values(diceFrequencies)) {
                    if (frequency === 1) {
                        straightCount++;
                    }
                }
                if (straightCount === 5 && diceFrequencies[1] === 0) {
                    for (const die of dice) {
                        largeStraightResult += die;
                    }
                }
                result = largeStraightResult;
                break;

            case YatzyCategory.TWO_PAIRS:
                // score if there are two pairs
                let twoPairResult = 0;
                let pairCount = 0;
                for (const frequency of Object.values(diceFrequencies)) {
                    if (frequency >= 2) {
                        pairCount++;
                    }
                }

                if (pairCount === 2) {
                    for (const i of DICE_VALUES) {
                        if (diceFrequencies[i] >= 2) {
                            twoPairResult += i * 2;
                        }
                    }
                }

                result = twoPairResult;
                break;

            case YatzyCategory.FULL_HOUSE:
                // score if there is a pair as well as three of a kind
                let fullHouseResult = 0;
                if (Object.values(diceFrequencies).includes(2) &&
                    Object.values(diceFrequencies).includes(3)) {
                    for (const die of dice) {
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

module.exports = Yatzy;
