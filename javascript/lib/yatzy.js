var Yatzy = function (d1, d2, d3, d4, d5) {

    // PROPERTIES

    this.dices = [d1, d2, d3, d4, d5];

    // PUBLIC METHODE

    /**
     * return the total of all 1
     */
    this.ones = function () {
        return this._sumOfNumber(1);
    }

    /**
     * return the total of all 2
     */
    this.twos = function () {
        return this._sumOfNumber(2);
    }

    /**
     * return the total of all 3
     */
    this.threes = function () {
        return this._sumOfNumber(3);
    }

    /**
     * return the total of all 4
     */
    this.fours = function () {
        return this._sumOfNumber(4);
    }

    /**
     * return the total of all 5
     */
    this.fives = function () {
        return this._sumOfNumber(5);
    }

    /**
     * return the total of all 6
     */
    this.sixes = function () {
        return this._sumOfNumber(6);
    }

    /**
     * return the total of all dices
     */
    this.chance = function () {
        return this.dices.reduce((a, b) => a + b);
    }

    /**
     * return 50 if all dices are same; zero otherwise
     */
    this.yatzy = function () {
        if (this._numberOfKind(5))
            return 50;
        return 0;
    }

    /**
     * return the sum of one pair; zero otherwise
     */
    this.onePair = function () {
        return this._findTheBestPair() * 2;
    }

    /**
     * return the sum of two pairs; zero otherwise
     */
    this.twoPair = function () {
        const bestPair = this._findTheBestPair();
        const worstPair = this._findTheWorstPair();

        if (bestPair != 0 && worstPair != 0 && bestPair != worstPair)
            return bestPair * 2 + worstPair * 2;
        return 0;
    }

    /**
     * return the sum of four same dice; zero otherwise
     */
    this.fourOfKind = function () {
        return this._numberOfKind(4) * 4;
    }

    /**
     * return the sum of three same dice; zero otherwise
     */
    this.threeOfKind = function () {
        return this._numberOfKind(3) * 3;
    }

    /**
     * return 30 if four of the dice have consecutive values; zero otherwise
     */
    this.smallStraight = function () {
        if (this._isSmallStraight())
            return 30;
        return 0;
    }

    /**
     * return 40 if all five dice have consecutive values
     */
    this.largeStraight = function () {
        if (this._isLargeStraight())
            return 40;
        return 0;
    }

    /**
     * return the sum of dices if the combinaison is a three-of-a-kind and a pair
     */
    this.fullHouse = function () {
        var countDices =  this._countDices();
        
        var gotPair = false;
        var gotThreeOfKind = false;

        var result = 0;

        for (var i = 0; i < 6; i++) {
            if (countDices[i] == 2) {
                gotPair = true;
                result += (i + 1) * 2;
            }
            if (countDices[i] == 3) {
                gotThreeOfKind = true;
                result += (i + 1) * 3;
            }
        }           

        if (gotPair && gotThreeOfKind)
            return result;
        return 0;
    }

    // PROTECTED METHOD

    /**
     * return the total of specified number
     */
    this._sumOfNumber = function (number) {
        var sum = 0;
        for (var i = 0; i < this.dices.length; i++)
            if (this.dices[i] == number)
                sum += number;
        return sum;
    }

    /**
     * return an Array with the count of dices values
     */
    this._countDices = function () {
        var countDices = [0, 0, 0, 0, 0, 0]
        countDices[this.dices[0] - 1]++;
        countDices[this.dices[1] - 1]++;
        countDices[this.dices[2] - 1]++;
        countDices[this.dices[3] - 1]++;
        countDices[this.dices[4] - 1]++;
        return countDices;
    }

    /**
     * return the value of 'number' same dice; zero otherwise
     * @param {int} number of dice wanted
     */
    this._numberOfKind = function(number) {
        var countDices =  this._countDices();
        for (i = 0; i < 6; i++)
            if (countDices[i] >= number)
                return i + 1;
        return 0;
    }

    /**
     * return true if the combinason is a small straight
     * 1234 - 2345 - 3456
     */
    this._isSmallStraight = function () {
        var countDices =  this._countDices();
        return countDices[0] >= 1 &&
            countDices[1] >= 1 &&
            countDices[2] >= 1 &&
            countDices[3] >= 1 ||
            countDices[1] >= 1 &&
            countDices[2] >= 1 &&
            countDices[3] >= 1 &&
            countDices[4] >= 1 ||
            countDices[2] >= 1 &&
            countDices[3] >= 1 &&
            countDices[4] >= 1 &&
            countDices[5] >= 1;
    }

    /**
     * return true if the combinason is a large straight
     * 12345 - 23456
     */
    this._isLargeStraight = function () {
        var countDices =  this._countDices();
        return countDices[0] == 1 &&
            countDices[1] == 1 &&
            countDices[2] == 1 &&
            countDices[3] == 1 &&
            countDices[4] == 1 ||
            countDices[1] == 1 &&
            countDices[2] == 1 &&
            countDices[3] == 1 &&
            countDices[4] == 1 &&
            countDices[5] == 1;
    }

    /**
     * find the value of the best pair; zero otherwise
     */
    this._findTheBestPair = function () {
        var countDices =  this._countDices();
        for (var i = 6; i > 0; i--)
            if (countDices[i] >= 2)
                return i + 1;
        return 0;
    }

    /**
     * find the value of the worst pair; zero otherwise
     */
    this._findTheWorstPair = function () {
        var countDices =  this._countDices();
        for (var i = 0; i < 6; i++)
            if (countDices[i] >= 2)
                return i + 1;
        return 0;
    }
    
}


module.exports = Yatzy;


