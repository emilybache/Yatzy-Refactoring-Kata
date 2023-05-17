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

int Yatzy::Ones()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 1) 
        {
            sum += 1;
        }
    }
    return sum;
}

int Yatzy::Twos()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 2) 
        {
            sum += 2;
        }
    }
    return sum;
}


int Yatzy::Threes()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 3) 
        {
            sum += 3;
        }
    }
    return sum;
}



int Yatzy::Fours()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 4) 
        {
            sum += 4;
        }
    }
    return sum;
}


int Yatzy::Fives()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 5) 
        {
            sum += 5;
        }
    }
    return sum;
}

int Yatzy::Sixes()
{
    int sum = 0;    
    for (int i = 0; i <= 5; i++) 
    {
        if (dice[i] == 6) 
        {
            sum += 6;
        }
    }
    return sum;
}

int Yatzy::yatzy()
{
    int count = 0;
    for (int i = 0; i <= 5; i++)
    {
        if(dice[0] == dice[i])
        {
            dice++;
        }
    }
    return (count == 5) ? 50 : 0;
}

int Yatzy::ScorePair(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = {0,0,0,0,0,0};
    counts[d1-1]++;
    counts[d2-1]++;
    counts[d3-1]++;
    counts[d4-1]++;
    counts[d5-1]++;
    int at;
    for (at = 0; at != 6; at++)
        if (counts[6-at-1] == 2)
            return (6-at)*2;
    return 0;
}

int Yatzy::TwoPair(int d1, int d2, int d3, int d4, int d5)
{
    int counts[6] = {0};
    counts[d1-1]++;
    counts[d2-1]++;
    counts[d3-1]++;
    counts[d4-1]++;
    counts[d5-1]++;
    int n = 0;
    int score = 0;
    for (int i = 0; i < 6; i += 1)
        if (counts[6-i-1] >= 2) {
            n++;
            score += (6-i);
        }        
    if (n == 2)
        return score * 2;
    else
        return 0;
}

int Yatzy::FourOfAKind()
{
    int * tallies;
    tallies = new int[6];
    tallies[0] = tallies[1] = tallies[2] = 0;
    tallies[3] = tallies[4] = tallies[5] = 0;
    tallies[_1-1]++;
    tallies[_2-1]++;
    tallies[d3-1]++;
    tallies[d4-1]++;
    tallies[d5-1]++;
    for (int i = 0; i < 6; i++)
        if (tallies[i] >= 4)
            return (i+1) * 4;
    return 0;
}

int Yatzy::ThreeOfAKind(int d1, int d2, int d3, int d4, int d5)
{
    int * t;
    t = new int[6];
    t[0] = t[1] = t[2] = 0;
    t[3] = t[4] = t[5] = 0;
    t[d1-1]++;
    t[d2-1]++;
    t[d3-1]++;
    t[d4-1]++;
    t[d5-1]++;
    for (int i = 0; i < 6; i++)
        if (t[i] >= 3)
            return (i+1) * 3;
    return 0;
}


int Yatzy::SmallStraight(int d1, int d2, int d3, int d4, int d5)
{
    int* tallies =new int[6];
    memset(tallies, 0, sizeof(int)*6);
    tallies[d1-1] += 1;
    tallies[d2-1] += 1;
    tallies[d3-1] += 1;
    tallies[d4-1] += 1;
    tallies[d5-1] += 1;
    if (tallies[0] == 1 &&
        tallies[1] == 1 &&
        tallies[2] == 1 &&
        tallies[3] == 1 &&
        tallies[4] == 1)
        return 15;
    return 0;
}

int Yatzy::LargeStraight(int d1, int d2, int d3, int d4, int d5)
{
    int* tallies = new int[6];
    memset(tallies, 0, sizeof(*tallies)*6);
    tallies[d1-1] += 1;
    tallies[d2-1] += 1;
    tallies[d3-1] += 1;
    tallies[d4-1] += 1;
    tallies[d5-1] += 1;
    if (tallies[1] == 1 &&
        tallies[2] == 1 &&
        tallies[3] == 1 &&
        tallies[4] == 1
        && tallies[5] == 1)
        return 20;
    return 0;
}


int Yatzy::FullHouse(int d1, int d2, int d3, int d4, int d5)
{
    int* tallies;
    bool _2 = false;
    int i;
    int _2_at = 0;
    bool _3 = false;
    int _3_at = 0;




    tallies = new int[6];
    memset(tallies, 0, sizeof(int)*6);
    tallies[d1-1] += 1;
    tallies[d2-1] += 1;
    tallies[d3-1] += 1;
    tallies[d4-1] += 1;
    tallies[d5-1] += 1;

    for (i = 0; i != 6; i += 1)
        if (tallies[i] == 2) {
            _2 = true;
            _2_at = i+1;
        }

    for (i = 0; i != 6; i += 1)
        if (tallies[i] == 3) {
            _3 = true;
            _3_at = i+1;
        }

    if (_2 && _3)
        return _2_at * 2 + _3_at * 3;
    else
        return 0;
}

int Yatzy::Chance(int d1, int d2, int d3, int d4, int d5)
{
    int total = 0;
    total += d1;
    total += d2;
    total += d3;
    total += d4;
    total += d5;
    return total;
}


