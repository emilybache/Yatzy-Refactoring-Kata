module Yatzy.Test.Yatzy2Test

open Xunit
open Yatzy2

[<Fact>]
let ``chance scores sum of all dice``() =
    Assert.Equal(15, score([2; 3; 4; 5; 1], CHANCE))
    Assert.Equal(16, score([3; 3; 4; 5; 1], CHANCE))

[<Fact>]
let ``yatzy scores 50``() =
    Assert.Equal(50, score([4; 4; 4; 4; 4], YATZY))
    Assert.Equal(50, score([6; 6; 6; 6; 6], YATZY))
    Assert.Equal(0, score([6; 6; 6; 6; 3], YATZY))

[<Fact>]
let ``test 1s``() =
    Assert.Equal(1, score([1; 2; 3; 4; 5], ONES))
    Assert.Equal(2, score([1; 2; 1; 4; 5], ONES))
    Assert.Equal(0, score([6; 2; 2; 4; 5], ONES))
    Assert.Equal(4, score([1; 2; 1; 1; 1], ONES))

[<Fact>]
let twos() =
    Assert.Equal(4, score([1; 2; 3; 2; 6], TWOS))
    Assert.Equal(10, score([2; 2; 2; 2; 2], TWOS))

[<Fact>]
let threes() =
    Assert.Equal(6, score([1; 2; 3; 2; 3], THREES))
    Assert.Equal(12, score([2; 3; 3; 3; 3], THREES))

[<Fact>]
let fours() =
    Assert.Equal(12, score([4; 4; 4; 5; 5], FOURS))
    Assert.Equal(8, score([4; 4; 5; 5; 5], FOURS))
    Assert.Equal(4, score([4; 5; 5; 5; 5], FOURS))

[<Fact>]
let fives() =
    Assert.Equal(10, score([4; 4; 4; 5; 5], FIVES))
    Assert.Equal(15, score([4; 4; 5; 5; 5], FIVES))
    Assert.Equal(20, score([4; 5; 5; 5; 5], FIVES))

[<Fact>]
let sixes() =
    Assert.Equal(0, score([4; 4; 4; 5; 5], SIXES))
    Assert.Equal(6, score([4; 4; 6; 5; 5], SIXES))
    Assert.Equal(18, score([6; 5; 6; 6; 5], SIXES))

[<Fact>]
let pair() =
    Assert.Equal(6, score([3; 4; 3; 5; 6], PAIR))
    Assert.Equal(10, score([5; 3; 3; 3; 5], PAIR))
    Assert.Equal(12, score([5; 3; 6; 6; 5], PAIR))

[<Fact>]
let ``two pair``() =
    Assert.Equal(16, score([3; 3; 5; 4; 5], TWO_PAIRS))
    Assert.Equal(16, score([3; 3; 5; 5; 5], TWO_PAIRS))

[<Fact>]
let ``three of a kind``() =
    Assert.Equal(9, score([3; 3; 3; 4; 5], THREE_OF_A_KIND))
    Assert.Equal(15, score([5; 3; 5; 4; 5], THREE_OF_A_KIND))
    Assert.Equal(9, score([3; 3; 3; 3; 5], THREE_OF_A_KIND))

[<Fact>]
let ``four of a kind``() =
    Assert.Equal(12, score([3; 3; 3; 3; 5], FOUR_OF_A_KIND))
    Assert.Equal(20, score([5; 5; 5; 4; 5], FOUR_OF_A_KIND))
    Assert.Equal(12, score([3; 3; 3; 3; 3], FOUR_OF_A_KIND))

[<Fact>]
let smallStraight() =
    Assert.Equal(15, score([1; 2; 3; 4; 5], SMALL_STRAIGHT))
    Assert.Equal(15, score([2; 3; 4; 5; 1], SMALL_STRAIGHT))
    Assert.Equal(0, score([1; 2; 2; 4; 5], SMALL_STRAIGHT))

[<Fact>]
let largeStraight() =
    Assert.Equal(20, score([6; 2; 3; 4; 5], LARGE_STRAIGHT))
    Assert.Equal(20, score([2; 3; 4; 5; 6], LARGE_STRAIGHT))
    Assert.Equal(0, score([1; 2; 2; 4; 5], LARGE_STRAIGHT))

[<Fact>]
let fullHouse() =
    Assert.Equal(18, score([6; 2; 2; 2; 6], FULL_HOUSE))
    Assert.Equal(0, score([2; 3; 4; 5; 6], FULL_HOUSE))

