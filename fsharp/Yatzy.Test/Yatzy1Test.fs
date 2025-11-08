module Yatzy.Test.Yatzy1Test

open Xunit
open Yatzy

[<Fact>]
let ``Chance scores sum of all dice``() =
    let expected = 15
    let actual = Yatzy1.chance(2, 3, 4, 5, 1)
    Assert.Equal(expected, actual)
    Assert.Equal(16, Yatzy1.chance(3, 3, 4, 5, 1))

[<Fact>]
let ``Fact 1s``() =
    Assert.True(Yatzy1.ones(1, 2, 3, 4, 5) = 1)
    Assert.Equal(2, Yatzy1.ones(1, 2, 1, 4, 5))
    Assert.Equal(0, Yatzy1.ones(6, 2, 2, 4, 5))
    Assert.Equal(4, Yatzy1.ones(1, 2, 1, 1, 1))

[<Fact>]
let ``Fact 2s``() =
    Assert.Equal(4, Yatzy1.twos(1, 2, 3, 2, 6))
    Assert.Equal(10, Yatzy1.twos(2, 2, 2, 2, 2))

[<Fact>]
let ``Fact threes``() =
    Assert.Equal(6, Yatzy1.threes(1, 2, 3, 2, 3))
    Assert.Equal(12, Yatzy1.threes(2, 3, 3, 3, 3))

[<Fact>]
let fives() =
    Assert.Equal(10, Yatzy1.fives 4 4 4 5 5)
    Assert.Equal(15, Yatzy1.fives 4 4 5 5 5)
    Assert.Equal(20, Yatzy1.fives 4 5 5 5 5)

[<Fact>]
let ``four of a kind``() =
    Assert.Equal(12, Yatzy1.fourOfAKind(3, 3, 3, 3, 5))
    Assert.Equal(20, Yatzy1.fourOfAKind(5, 5, 5, 4, 5))
    Assert.Equal(12, Yatzy1.fourOfAKind(3, 3, 3, 3, 3))

[<Fact>]
let ``fours Fact``() =
    Assert.Equal(12, Yatzy1.fours 4 4 4 5 5)
    Assert.Equal(8, Yatzy1.fours 4 4 5 5 5)
    Assert.Equal(4, Yatzy1.fours 4 5 5 5 5)

[<Fact>]
let fullHouse() =
    Assert.Equal(18, Yatzy1.fullHouse(6, 2, 2, 2, 6))
    Assert.Equal(0, Yatzy1.fullHouse(2, 3, 4, 5, 6))

[<Fact>]
let largeStraight() =
    Assert.Equal(20, Yatzy1.largeStraight(6, 2, 3, 4, 5))
    Assert.Equal(20, Yatzy1.largeStraight(2, 3, 4, 5, 6))
    Assert.Equal(0, Yatzy1.largeStraight(1, 2, 2, 4, 5))

[<Fact>]
let ``one pair``() =
    Assert.Equal(6, Yatzy1.scorePair(3, 4, 3, 5, 6))
    Assert.Equal(10, Yatzy1.scorePair(5, 3, 3, 3, 5))
    Assert.Equal(12, Yatzy1.scorePair(5, 3, 6, 6, 5))

[<Fact>]
let ``sixes Fact``() =
    Assert.Equal(0, Yatzy1.sixes 4 4 4 5 5)
    Assert.Equal(6, Yatzy1.sixes 4 4 6 5 5)
    Assert.Equal(18, Yatzy1.sixes 6 5 6 6 5)

[<Fact>]
let smallStraight() =
    Assert.Equal(15, Yatzy1.smallStraight(1, 2, 3, 4, 5))
    Assert.Equal(15, Yatzy1.smallStraight(2, 3, 4, 5, 1))
    Assert.Equal(0, Yatzy1.smallStraight(1, 2, 2, 4, 5))

[<Fact>]
let ``three of a kind``() =
    Assert.Equal(9, Yatzy1.threeOfAKind(3, 3, 3, 4, 5))
    Assert.Equal(15, Yatzy1.threeOfAKind(5, 3, 5, 4, 5))
    Assert.Equal(9, Yatzy1.threeOfAKind(3, 3, 3, 3, 5))

[<Fact>]
let ``two Pair``() =
    Assert.Equal(16, Yatzy1.twoPair(3, 3, 5, 4, 5))
    Assert.Equal(16, Yatzy1.twoPair(3, 3, 5, 5, 5))

[<Fact>]
let ``Yatzy scores 50``() =
    let expected = 50
    let actual = Yatzy1.yatzy [|4; 4; 4; 4; 4|]
    Assert.Equal(expected, actual)
    Assert.Equal(50, Yatzy1.yatzy [|6; 6; 6; 6; 6|])
    Assert.Equal(0, Yatzy1.yatzy [|6; 6; 6; 6; 3|])

