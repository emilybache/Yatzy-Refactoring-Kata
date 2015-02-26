using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

[TestClass]
public class YatzyMSTest
{
    [TestMethod]
    public void Chance_scores_sum_of_all_dice()
    {
        int expected = 15;
        int actual = Yatzy.Chance(2,3,4,5,1);
        Assert.AreEqual(expected, actual);
        Assert.AreEqual(16, Yatzy.Chance(3,3,4,5,1));
    }

    [TestMethod]
    public void Yatzy_scores_50()
    {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        Assert.AreEqual(expected, actual);
        Assert.AreEqual(50, Yatzy.yatzy(6,6,6,6,6));
        Assert.AreEqual(0, Yatzy.yatzy(6,6,6,6,3));
    }

    [TestMethod]
    public void Test_1s() {
        Assert.IsTrue(Yatzy.Ones(1,2,3,4,5) == 1);
        Assert.AreEqual(2, Yatzy.Ones(1,2,1,4,5));
        Assert.AreEqual(0, Yatzy.Ones(6,2,2,4,5));
        Assert.AreEqual(4, Yatzy.Ones(1,2,1,1,1));
    }

    [TestMethod]
    public void test_2s()
    {
        Assert.AreEqual(4, Yatzy.Twos(1,2,3,2,6));
        Assert.AreEqual(10, Yatzy.Twos(2,2,2,2,2));
    }

    [TestMethod]
    public void test_threes()
    {
        Assert.AreEqual(6, Yatzy.Threes(1,2,3,2,3));
        Assert.AreEqual(12, Yatzy.Threes(2,3,3,3,3));
    }

    [TestMethod]
    public void fours_test()
    {
        Assert.AreEqual(12, new Yatzy(4,4,4,5,5).Fours());
        Assert.AreEqual(8, new Yatzy(4,4,5,5,5).Fours());
        Assert.AreEqual(4, new Yatzy(4,5,5,5,5).Fours());
    }

    [TestMethod]
    public void fives() {
        Assert.AreEqual(10, new Yatzy(4,4,4,5,5).Fives());
        Assert.AreEqual(15, new Yatzy(4,4,5,5,5).Fives());
        Assert.AreEqual(20, new Yatzy(4,5,5,5,5).Fives());
    }

    [TestMethod]
    public void sixes_test()
    {
        Assert.AreEqual(0, new Yatzy(4,4,4,5,5).sixes());
        Assert.AreEqual(6, new Yatzy(4,4,6,5,5).sixes());
        Assert.AreEqual(18, new Yatzy(6,5,6,6,5).sixes());
    }

    [TestMethod]
    public void one_pair()
    {
        Assert.AreEqual(6, Yatzy.ScorePair(3,4,3,5,6));
        Assert.AreEqual(10, Yatzy.ScorePair(5,3,3,3,5));
        Assert.AreEqual(12, Yatzy.ScorePair(5,3,6,6,5));
    }

    [TestMethod]
    public void two_Pair()
    {
        Assert.AreEqual(16, Yatzy.TwoPair(3,3,5,4,5));
        Assert.AreEqual(16, Yatzy.TwoPair(3,3,5,5,5));
    }

    [TestMethod]
    public void three_of_a_kind()
    {
        Assert.AreEqual(9, Yatzy.ThreeOfAKind(3,3,3,4,5));
        Assert.AreEqual(15, Yatzy.ThreeOfAKind(5,3,5,4,5));
        Assert.AreEqual(9, Yatzy.ThreeOfAKind(3,3,3,3,5));
    }

    [TestMethod]
    public void four_of_a_knd()
    {
        Assert.AreEqual(12, Yatzy.FourOfAKind(3,3,3,3,5));
        Assert.AreEqual(20, Yatzy.FourOfAKind(5,5,5,4,5));
        Assert.AreEqual(12, Yatzy.FourOfAKind(3,3,3,3,3));
    }

    [TestMethod]
    public void smallStraight()
    {
        Assert.AreEqual(15, Yatzy.SmallStraight(1,2,3,4,5));
        Assert.AreEqual(15, Yatzy.SmallStraight(2,3,4,5,1));
        Assert.AreEqual(0, Yatzy.SmallStraight(1,2,2,4,5));
    }

    [TestMethod]
    public void largeStraight()
    {
        Assert.AreEqual(20, Yatzy.LargeStraight(6,2,3,4,5));
        Assert.AreEqual(20, Yatzy.LargeStraight(2,3,4,5,6));
        Assert.AreEqual(0, Yatzy.LargeStraight(1,2,2,4,5));
    }

    [TestMethod]
    public void fullHouse()
    {
        Assert.AreEqual(18, Yatzy.FullHouse(6,2,2,2,6));
        Assert.AreEqual(0, Yatzy.FullHouse(2,3,4,5,6));
    }
}
