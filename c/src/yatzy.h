#ifndef SAMPLE_H
#define SAMPLE_H

int Chance(int d1, int d2, int d3, int d4, int d5);
int yatzy(int dice[]);
int Ones(int d1, int d2, int d3, int d4, int d5);
int Twos(int d1, int d2, int d3, int d4, int d5);
int Threes(int d1, int d2, int d3, int d4, int d5);

struct Yatzy {
   int* dice;
};

typedef struct Yatzy Yatzy;

Yatzy* yatzy_factory(int d1, int d2, int d3, int d4, int _5);
void yazty_destructor(Yatzy* yatzy);

int Fours(Yatzy* yatzy);
int Fives(Yatzy* yatzy);
int sixes(Yatzy* yatzy);
int ScorePair(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);
int TwoPair(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);
int FourOfAKind(Yatzy* yatzy, int _1, int _2, int d3, int d4, int d5);
int ThreeOfAKind(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);
int SmallStraight(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);
int LargeStraight(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);
int FullHouse(Yatzy* yatzy, int d1, int d2, int d3, int d4, int d5);

#endif //SAMPLE_H
