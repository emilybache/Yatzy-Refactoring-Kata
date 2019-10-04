using Xunit;

namespace Yatzy.Test
{
    public class YatzyTest
    {
        [Fact]
        public void Chance_scores_sum_of_all_dice()
        {
            var expected = 15;
            var actual = Yatzy.Chance(2, 3, 4, 5, 1);
            Assert.Equal(expected, actual);
            Assert.Equal(16, Yatzy.Chance(3, 3, 4, 5, 1));
        }

        [Fact]
        public void Fact_1s()
        {
            Assert.True(Yatzy.Ones(1, 2, 3, 4, 5) == 1);
            Assert.Equal(2, Yatzy.Ones(1, 2, 1, 4, 5));
            Assert.Equal(0, Yatzy.Ones(6, 2, 2, 4, 5));
            Assert.Equal(4, Yatzy.Ones(1, 2, 1, 1, 1));
        }

        [Fact]
        public void Fact_2s()
        {
            Assert.Equal(4, Yatzy.Twos(1, 2, 3, 2, 6));
            Assert.Equal(10, Yatzy.Twos(2, 2, 2, 2, 2));
        }

        [Fact]
        public void Fact_threes()
        {
            Assert.Equal(6, Yatzy.Threes(1, 2, 3, 2, 3));
            Assert.Equal(12, Yatzy.Threes(2, 3, 3, 3, 3));
        }

        [Fact]
        public void fives()
        {
            Assert.Equal(10, new Yatzy(4, 4, 4, 5, 5).Fives());
            Assert.Equal(15, new Yatzy(4, 4, 5, 5, 5).Fives());
            Assert.Equal(20, new Yatzy(4, 5, 5, 5, 5).Fives());
        }

        [Fact]
        public void four_of_a_knd()
        {
            Assert.Equal(12, Yatzy.FourOfAKind(3, 3, 3, 3, 5));
            Assert.Equal(20, Yatzy.FourOfAKind(5, 5, 5, 4, 5));
            Assert.Equal(12, Yatzy.FourOfAKind(3, 3, 3, 3, 3));
        }

        [Fact]
        public void fours_Fact()
        {
            Assert.Equal(12, new Yatzy(4, 4, 4, 5, 5).Fours());
            Assert.Equal(8, new Yatzy(4, 4, 5, 5, 5).Fours());
            Assert.Equal(4, new Yatzy(4, 5, 5, 5, 5).Fours());
        }

        [Fact]
        public void fullHouse()
        {
            Assert.Equal(18, Yatzy.FullHouse(6, 2, 2, 2, 6));
            Assert.Equal(0, Yatzy.FullHouse(2, 3, 4, 5, 6));
        }

        [Fact]
        public void largeStraight()
        {
            Assert.Equal(20, Yatzy.LargeStraight(6, 2, 3, 4, 5));
            Assert.Equal(20, Yatzy.LargeStraight(2, 3, 4, 5, 6));
            Assert.Equal(0, Yatzy.LargeStraight(1, 2, 2, 4, 5));
        }

        [Fact]
        public void one_pair()
        {
            Assert.Equal(6, Yatzy.ScorePair(3, 4, 3, 5, 6));
            Assert.Equal(10, Yatzy.ScorePair(5, 3, 3, 3, 5));
            Assert.Equal(12, Yatzy.ScorePair(5, 3, 6, 6, 5));
        }

        [Fact]
        public void sixes_Fact()
        {
            Assert.Equal(0, new Yatzy(4, 4, 4, 5, 5).sixes());
            Assert.Equal(6, new Yatzy(4, 4, 6, 5, 5).sixes());
            Assert.Equal(18, new Yatzy(6, 5, 6, 6, 5).sixes());
        }

        [Fact]
        public void smallStraight()
        {
            Assert.Equal(15, Yatzy.SmallStraight(1, 2, 3, 4, 5));
            Assert.Equal(15, Yatzy.SmallStraight(2, 3, 4, 5, 1));
            Assert.Equal(0, Yatzy.SmallStraight(1, 2, 2, 4, 5));
        }

        [Fact]
        public void three_of_a_kind()
        {
            Assert.Equal(9, Yatzy.ThreeOfAKind(3, 3, 3, 4, 5));
            Assert.Equal(15, Yatzy.ThreeOfAKind(5, 3, 5, 4, 5));
            Assert.Equal(9, Yatzy.ThreeOfAKind(3, 3, 3, 3, 5));
        }

        [Fact]
        public void two_Pair()
        {
            Assert.Equal(16, Yatzy.TwoPair(3, 3, 5, 4, 5));
            Assert.Equal(16, Yatzy.TwoPair(3, 3, 5, 5, 5));
        }

        [Fact]
        public void Yatzy_scores_50()
        {
            var expected = 50;
            var actual = Yatzy.yatzy(4, 4, 4, 4, 4);
            Assert.Equal(expected, actual);
            Assert.Equal(50, Yatzy.yatzy(6, 6, 6, 6, 6));
            Assert.Equal(0, Yatzy.yatzy(6, 6, 6, 6, 3));
        }
    }
}