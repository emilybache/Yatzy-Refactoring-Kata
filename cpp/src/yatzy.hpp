#ifndef YATZY_INCLUDED
#define YATZY_INCLUDED

class Yatzy
{
    protected:
        int * dice;
    public:
        
        Yatzy();
        Yatzy(int d1, int d2, int d3, int d4, int _5);
        
        int getDiceValueSum(int diceValue);
        int ScorePair(int d1, int d2, int d3, int d4, int d5);
        int TwoPair(int d1, int d2, int d3, int d4, int d5);
        int QuantityOfAKind(int quantity);

        int SmallStraight(int d1, int d2, int d3, int d4, int d5);
        int LargeStraight(int d1, int d2, int d3, int d4, int d5);
        int FullHouse(int d1, int d2, int d3, int d4, int d5);
};

#endif
