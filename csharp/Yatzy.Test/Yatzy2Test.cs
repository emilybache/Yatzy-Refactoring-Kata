using System.Collections.Generic;
using Xunit;

namespace Yatzy.Test;

public class Yatzy2Test
{
    private Yatzy2.Yatzy2 calculator = new Yatzy2.Yatzy2();

    [Fact]
    public void chance_scores_sum_of_all_dice()
    {
        Assert.Equal(15, calculator.Score(new List<int> { 2, 3, 4, 5, 1 }, "CHANCE"));
        Assert.Equal(16, calculator.Score(new List<int> { 3, 3, 4, 5, 1 }, "CHANCE"));
    }

    [Fact]
    public void yatzy_scores_50()
    {
        Assert.Equal(50, calculator.Score(new List<int> { 4, 4, 4, 4, 4 }, "YATZY"));
        Assert.Equal(50, calculator.Score(new List<int> { 6, 6, 6, 6, 6 }, "YATZY"));
        Assert.Equal(0, calculator.Score(new List<int> { 6, 6, 6, 6, 3 }, "YATZY"));
    }

    [Fact]
    public void test_1s()
    {
        Assert.Equal(1, calculator.Score(new List<int> { 1, 2, 3, 4, 5 }, "ONES"));
        Assert.Equal(2, calculator.Score(new List<int> { 1, 2, 1, 4, 5 }, "ONES"));
        Assert.Equal(0, calculator.Score(new List<int> { 6, 2, 2, 4, 5 }, "ONES"));
        Assert.Equal(4, calculator.Score(new List<int> { 1, 2, 1, 1, 1 }, "ONES"));
    }

    [Fact]
    public void twos()
    {
        Assert.Equal(4, calculator.Score(new List<int> { 1, 2, 3, 2, 6 }, "TWOS"));
        Assert.Equal(10, calculator.Score(new List<int> { 2, 2, 2, 2, 2 }, "TWOS"));
    }

    [Fact]
    public void threes()
    {
        Assert.Equal(6, calculator.Score(new List<int> { 1, 2, 3, 2, 3 }, "THREES"));
        Assert.Equal(12, calculator.Score(new List<int> { 2, 3, 3, 3, 3 }, "THREES"));
    }

    [Fact]
    public void fours()
    {
        Assert.Equal(12, calculator.Score(new List<int> { 4, 4, 4, 5, 5 }, "FOURS"));
        Assert.Equal(8, calculator.Score(new List<int> { 4, 4, 5, 5, 5 }, "FOURS"));
        Assert.Equal(4, calculator.Score(new List<int> { 4, 5, 5, 5, 5 }, "FOURS"));
    }

    [Fact]
    public void fives()
    {
        Assert.Equal(10, calculator.Score(new List<int> { 4, 4, 4, 5, 5 }, "FIVES"));
        Assert.Equal(15, calculator.Score(new List<int> { 4, 4, 5, 5, 5 }, "FIVES"));
        Assert.Equal(20, calculator.Score(new List<int> { 4, 5, 5, 5, 5 }, "FIVES"));
    }

    [Fact]
    public void sixes()
    {
        Assert.Equal(0, calculator.Score(new List<int> { 4, 4, 4, 5, 5 }, "SIXES"));
        Assert.Equal(6, calculator.Score(new List<int> { 4, 4, 6, 5, 5 }, "SIXES"));
        Assert.Equal(18, calculator.Score(new List<int> { 6, 5, 6, 6, 5 }, "SIXES"));
    }

    [Fact]
    public void pair()
    {
        Assert.Equal(6, calculator.Score(new List<int> { 3, 4, 3, 5, 6 }, "PAIR"));
        Assert.Equal(10, calculator.Score(new List<int> { 5, 3, 3, 3, 5 }, "PAIR"));
        Assert.Equal(12, calculator.Score(new List<int> { 5, 3, 6, 6, 5 }, "PAIR"));
    }

    [Fact]
    public void two_pair()
    {
        Assert.Equal(16, calculator.Score(new List<int> { 3, 3, 5, 4, 5 }, "TWO_PAIRS"));
        Assert.Equal(16, calculator.Score(new List<int> { 3, 3, 5, 5, 5 }, "TWO_PAIRS"));
    }

    [Fact]
    public void three_of_a_kind()
    {
        Assert.Equal(9, calculator.Score(new List<int> { 3, 3, 3, 4, 5 }, "THREE_OF_A_KIND"));
        Assert.Equal(15, calculator.Score(new List<int> { 5, 3, 5, 4, 5 }, "THREE_OF_A_KIND"));
        Assert.Equal(9, calculator.Score(new List<int> { 3, 3, 3, 3, 5 }, "THREE_OF_A_KIND"));
    }

    [Fact]
    public void four_of_a_knd()
    {
        Assert.Equal(12, calculator.Score(new List<int> { 3, 3, 3, 3, 5 }, "FOUR_OF_A_KIND"));
        Assert.Equal(20, calculator.Score(new List<int> { 5, 5, 5, 4, 5 }, "FOUR_OF_A_KIND"));
        Assert.Equal(12, calculator.Score(new List<int> { 3, 3, 3, 3, 3 }, "FOUR_OF_A_KIND"));
    }

    [Fact]
    public void smallStraight()
    {
        Assert.Equal(15, calculator.Score(new List<int> { 1, 2, 3, 4, 5 }, "SMALL_STRAIGHT"));
        Assert.Equal(15, calculator.Score(new List<int> { 2, 3, 4, 5, 1 }, "SMALL_STRAIGHT"));
        Assert.Equal(0, calculator.Score(new List<int> { 1, 2, 2, 4, 5 }, "SMALL_STRAIGHT"));
    }

    [Fact]
    public void largeStraight()
    {
        Assert.Equal(20, calculator.Score(new List<int> { 6, 2, 3, 4, 5 }, "LARGE_STRAIGHT"));
        Assert.Equal(20, calculator.Score(new List<int> { 2, 3, 4, 5, 6 }, "LARGE_STRAIGHT"));
        Assert.Equal(0, calculator.Score(new List<int> { 1, 2, 2, 4, 5 }, "LARGE_STRAIGHT"));
    }

    [Fact]
    public void fullHouse()
    {
        Assert.Equal(18, calculator.Score(new List<int> { 6, 2, 2, 2, 6 }, "FULL_HOUSE"));
        Assert.Equal(0, calculator.Score(new List<int> { 2, 3, 4, 5, 6 }, "FULL_HOUSE"));
    }
}