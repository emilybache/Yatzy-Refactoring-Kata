module Yatzy.Test.Yatzy3Test

open Xunit
open Yatzy.Yatzy3
    
let calculator = Yatzy()

[<Fact>]
let ``Chance scores sum of all dice``() =
    Assert.Equal(15, calculator.Score([2; 3; 4; 5; 1], "CHANCE"))
    Assert.Equal(16, calculator.Score([3; 3; 4; 5; 1], "CHANCE"))

[<Fact>]
let ``Yatzy scores 50``() =
    Assert.Equal(50, calculator.Score([4; 4; 4; 4; 4], "YATZY"))
    Assert.Equal(50, calculator.Score([6; 6; 6; 6; 6], "YATZY"))
    Assert.Equal(0, calculator.Score([6; 6; 6; 6; 3], "YATZY"))

[<Fact>]
let ``Ones``() =
    Assert.Equal(1, calculator.Score([1; 2; 3; 4; 5], "ONES"))
    Assert.Equal(2, calculator.Score([1; 2; 1; 4; 5], "ONES"))
    Assert.Equal(0, calculator.Score([6; 2; 2; 4; 5], "ONES"))
    Assert.Equal(4, calculator.Score([1; 2; 1; 1; 1], "ONES"))

[<Fact>]
let ``Twos``() =
    Assert.Equal(4, calculator.Score([1; 2; 3; 2; 6], "TWOS"))
    Assert.Equal(10, calculator.Score([2; 2; 2; 2; 2], "TWOS"))

[<Fact>]
let ``Threes``() =
    Assert.Equal(6, calculator.Score([1; 2; 3; 2; 3], "THREES"))
    Assert.Equal(12, calculator.Score([2; 3; 3; 3; 3], "THREES"))

[<Fact>]
let ``Fours``() =
    Assert.Equal(12, calculator.Score([4; 4; 4; 5; 5], "FOURS"))
    Assert.Equal(8, calculator.Score([4; 4; 5; 5; 5], "FOURS"))
    Assert.Equal(4, calculator.Score([4; 5; 5; 5; 5], "FOURS"))

[<Fact>]
let ``Fives``() =
    Assert.Equal(10, calculator.Score([4; 4; 4; 5; 5], "FIVES"))
    Assert.Equal(15, calculator.Score([4; 4; 5; 5; 5], "FIVES"))
    Assert.Equal(20, calculator.Score([4; 5; 5; 5; 5], "FIVES"))

[<Fact>]
let ``Sixes``() =
    Assert.Equal(0, calculator.Score([4; 4; 4; 5; 5], "SIXES"))
    Assert.Equal(6, calculator.Score([4; 4; 6; 5; 5], "SIXES"))
    Assert.Equal(18, calculator.Score([6; 5; 6; 6; 5], "SIXES"))

[<Fact>]
let ``Pair``() =
    Assert.Equal(6, calculator.Score([3; 4; 3; 5; 6], "PAIR"))
    Assert.Equal(10, calculator.Score([5; 3; 3; 3; 5], "PAIR"))
    Assert.Equal(12, calculator.Score([5; 3; 6; 6; 5], "PAIR"))

[<Fact>]
let ``Two pairs``() =
    Assert.Equal(16, calculator.Score([3; 3; 5; 4; 5], "TWO_PAIRS"))
    Assert.Equal(16, calculator.Score([3; 3; 5; 5; 5], "TWO_PAIRS"))

[<Fact>]
let ``Three of a kind``() =
    Assert.Equal(9, calculator.Score([3; 3; 3; 4; 5], "THREE_OF_A_KIND"))
    Assert.Equal(15, calculator.Score([5; 3; 5; 4; 5], "THREE_OF_A_KIND"))
    Assert.Equal(9, calculator.Score([3; 3; 3; 3; 5], "THREE_OF_A_KIND"))

[<Fact>]
let ``Four of a kind ``() =
    Assert.Equal(12, calculator.Score([3; 3; 3; 3; 5], "FOUR_OF_A_KIND"))
    Assert.Equal(20, calculator.Score([5; 5; 5; 4; 5], "FOUR_OF_A_KIND"))
    Assert.Equal(12, calculator.Score([3; 3; 3; 3; 3], "FOUR_OF_A_KIND"))

[<Fact>]
let ``Small straight``() =
    Assert.Equal(15, calculator.Score([1; 2; 3; 4; 5], "SMALL_STRAIGHT"))
    Assert.Equal(15, calculator.Score([2; 3; 4; 5; 1], "SMALL_STRAIGHT"))
    Assert.Equal(0, calculator.Score([1; 2; 2; 4; 5], "SMALL_STRAIGHT"))

[<Fact>]
let ``Large straight``() =
    Assert.Equal(20, calculator.Score([6; 2; 3; 4; 5], "LARGE_STRAIGHT"))
    Assert.Equal(20, calculator.Score([2; 3; 4; 5; 6], "LARGE_STRAIGHT"))
    Assert.Equal(0, calculator.Score([1; 2; 2; 4; 5], "LARGE_STRAIGHT"))

[<Fact>]
let ``Full house``() =
    Assert.Equal(18, calculator.Score([6; 2; 2; 2; 6], "FULL_HOUSE"))
    Assert.Equal(0, calculator.Score([2; 3; 4; 5; 6], "FULL_HOUSE"))