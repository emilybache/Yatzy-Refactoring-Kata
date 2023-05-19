#include "yatzy.hpp"
#include <string.h>

Yatzy::Yatzy()
{
}

Yatzy::Yatzy(int d1, int d2, int d3, int d4, int d5)
{
    dice = new int[5];
    dice[0] = d1;
    dice[1] = d2;
    dice[2] = d3;
    dice[3] = d4;
    dice[4] = d5;
}

int Yanzy::getDiceValueSum(int diceValue)
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == diceValue) 
        {
            sum += diceValue;
        }
    }
    return sum;
}

int* countDiceValues(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = {0,0,0,0,0,0};
    counts[d1-1]++;
    counts[d2-1]++;
    counts[d3-1]++;
    counts[d4-1]++;
    counts[d5-1]++;
    return counts;
}

int Yatzy::OnePair(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);

    for (int i = 0; i < 6; i++)
    {
        if (counts[i] == 2)
        {
            return i * 2;
        }
    }
        
    return 0;
}

int Yatzy::TwoPair(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);
    
    int n = 0;
    int score = 0;
    for (int i = 0; i < 6; i += 1)
    {
        if (counts[i] >= 2) 
        {
            n++;
            score += 2 * (i + 1);
        }
        
        if (n == 2)
        {
            return score;
        }
    }
    return 0;
}

int Yatzy::QuantityOfAKind(int quantity)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);
    
    for (int i = 0; i < 6; i++)
    {
        if (counts[i] == quantity)
        {
            return (i + 1) * quantity;
        }
    }
    return 0;
}

int Yatzy::SmallStraight(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);
    
    return (counts[0] == 1 && counts[1] == 1 
        && counts[2] == 1 && counts[3] == 1 
        && counts[4] == 1) ? 15 : 0;
}

int Yatzy::LargeStraight(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);
    
    return (counts[1] == 1 && counts[2] == 1 
        && counts[3] == 1 && counts[4] == 1 
        && counts[5] == 1) ? 20 : 0;
}


int Yatzy::FullHouse(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = countDiceValues(d1, d2, d3, d4, d5);
    bool isPair, isTriple;
    int pairValue, tripleValue;
    
    for (int i = 0; i < 6; i++)
    {
        if (counts[i] == 2) 
        {
            isPair = true;
            pairValue = i+1;
        }
        else if (counts[i] == 3) 
        {
            isTriple = true;
            tripleValue = i+1;
        }
    }

    return (isPair && isTriple) ? (pairValue * 2 + tripleValue * 3) : 0;
}

int Yatzy::Chance(int d1, int d2, int d3, int d4, int d5)
{
    return d1 + d2 + d3 + d4 + d5;
}


