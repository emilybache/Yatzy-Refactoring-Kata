using Xunit;

namespace Yatzy.Test;
/*
 * Example test names for review
 */
public class YatzyTest
{
    [Fact]
    public void Test1()
    {
        Assert.Equal(15, Yatzy1.Yatzy1.Chance(2, 3, 4, 5, 1));
        Assert.Equal(16, Yatzy1.Yatzy1.Chance(3, 3, 4, 5, 1));
    }    
    
    [Fact]
    public void TestChance()
    {
        Assert.Equal(15, Yatzy1.Yatzy1.Chance(2, 3, 4, 5, 1));
        Assert.Equal(16, Yatzy1.Yatzy1.Chance(3, 3, 4, 5, 1));
    }    
    
    [Fact]
    public void ChanceSumsTheDice()
    {
        Assert.Equal(15, Yatzy1.Yatzy1.Chance(2, 3, 4, 5, 1));
        Assert.Equal(16, Yatzy1.Yatzy1.Chance(3, 3, 4, 5, 1));
    }    
    
    [Fact]
    public void Chance_Sums_The_Dice()
    {
        Assert.Equal(15, Yatzy1.Yatzy1.Chance(2, 3, 4, 5, 1));
        Assert.Equal(16, Yatzy1.Yatzy1.Chance(3, 3, 4, 5, 1));
    }   
    
    [Fact]
    public void Given_All_Ones_Score_Chance_Returns_5()
    {
        Assert.Equal(5, Yatzy1.Yatzy1.Chance(1,1,1,1,1));
    }
        
    [Fact]
    public void Any_Dice_Score_Chance_Gives_Sum()
    {
        Assert.Equal(15, Yatzy1.Yatzy1.Chance(2, 3, 4, 5, 1));
        Assert.Equal(16, Yatzy1.Yatzy1.Chance(3, 3, 4, 5, 1));
    } 
}