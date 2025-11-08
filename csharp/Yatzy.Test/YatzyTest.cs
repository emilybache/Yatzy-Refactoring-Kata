using System;
using System.Collections.Generic;
using System.Linq;
using ApprovalTests;
using ApprovalTests.Reporters;
using Xunit;

namespace Yatzy.Test
{
    [UseReporter(typeof(DiffReporter))]
    public class YatzyTest
    {
        [Fact]
        public void Chance_scores_sum_of_all_dice()
        {
            CheckAll(dice => Yatzy.Chance(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void Fact_1s()
        {
            CheckAll(dice => Yatzy.Ones(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void Fact_2s()
        {
            CheckAll(dice => Yatzy.Twos(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void Fact_threes()
        {
            CheckAll(dice => Yatzy.Threes(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void fives()
        {
            CheckAll(dice => new Yatzy(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5).Fives());
        }

        [Fact]
        public void four_of_a_knd()
        {
            CheckAll(dice => Yatzy.FourOfAKind(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void fours_Fact()
        {
            CheckAll(dice => new Yatzy(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5).Fours());
        }

        [Fact]
        public void fullHouse()
        {
            CheckAll(dice => Yatzy.FullHouse(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void largeStraight()
        {
            CheckAll(dice => Yatzy.LargeStraight(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void one_pair()
        {
            CheckAll(dice => Yatzy.ScorePair(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void sixes_Fact()
        {
            CheckAll(dice => new Yatzy(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5).sixes());
        }

        [Fact]
        public void smallStraight()
        {
            CheckAll(dice => Yatzy.SmallStraight(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void three_of_a_kind()
        {
            CheckAll(dice => Yatzy.ThreeOfAKind(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void two_Pair()
        {
            CheckAll(dice => Yatzy.TwoPair(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        [Fact]
        public void Yatzy_scores_50()
        {
            CheckAll(dice => Yatzy.yatzy(dice.Die1, dice.Die2, dice.Die3, dice.Die4, dice.Die5));
        }

        private static void CheckAll(Func<Throw, int> check)
        {
            Approvals.VerifyAll(GenerateAllThrows(), t => $"{t} => {check(t)}");
        }

        private static IEnumerable<Throw> GenerateAllThrows()
        {
            return Enumerable.Range(1, 6).SelectMany(d1 =>
                Enumerable.Range(1, 6).SelectMany(d2 =>
                    Enumerable.Range(1, 6).SelectMany(d3 =>
                        Enumerable.Range(1, 6).SelectMany(d4 =>
                            Enumerable.Range(1, 6).Select(d5 => new Throw(d1, d2, d3, d4, d5))
                        )
                    )
                )
            );
        }

        public readonly struct Throw(int die1, int die2, int die3, int die4, int die5)
        {
            public int Die1 => die1;
            public int Die2 => die2;
            public int Die3 => die3;
            public int Die4 => die4;
            public int Die5 => die5;

            public override string ToString() => $"{Die1}, {Die2}, {Die3}, {Die4}, {Die5}";
        }
    }
}