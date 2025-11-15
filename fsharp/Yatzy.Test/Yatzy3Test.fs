module Yatzy.Test.Yatzy3Test

open Xunit
open ApprovalTests
open ApprovalTests.Reporters
open Yatzy.Yatzy3

type DiceThrow = 
    { Die1: int; Die2: int; Die3: int; Die4: int; Die5: int }
    
    member this.ToList() = 
        [this.Die1; this.Die2; this.Die3; this.Die4; this.Die5]
    
    override this.ToString() =
        $"%d{this.Die1}, %d{this.Die2}, %d{this.Die3}, %d{this.Die4}, %d{this.Die5}"

let generateAllDiceThrows () =
    let dice = [1..6]
    dice
    |> List.allPairs dice
    |> List.allPairs dice
    |> List.allPairs dice
    |> List.allPairs dice
    |> List.map (fun (d1, (d2, (d3, (d4, d5)))) -> 
        { Die1 = d1; Die2 = d2; Die3 = d3; Die4 = d4; Die5 = d5 }
    )

[<UseReporter(typeof<DiffReporter>)>]
type YatzyApprovalTest() =
    let throws = generateAllDiceThrows()
    let calculator = Yatzy()
    
    let verifyAllThrows category =
        let formatter (t: DiceThrow) = 
            let result = calculator.Score(t.ToList(), category)
            $"{t} => %d{result}"
        Approvals.VerifyAll(throws, formatter)
    
    [<Fact>]
    member _.``Approve Chance``() =
        verifyAllThrows "CHANCE"
    
    [<Fact>]
    member _.``Approve Ones``() =
        verifyAllThrows "ONES"
    
    [<Fact>]
    member _.``Approve Twos``() =
        verifyAllThrows "TWOS"
    
    [<Fact>]
    member _.``Approve Threes``() =
        verifyAllThrows "THREES"
    
    [<Fact>]
    member _.``Approve Fours``() =
        verifyAllThrows "FOURS"
    
    [<Fact>]
    member _.``Approve Fives``() =
        verifyAllThrows "FIVES"
    
    [<Fact>]
    member _.``Approve Sixes``() =
        verifyAllThrows "SIXES"
    
    [<Fact>]
    member _.``Approve ScorePair``() =
        verifyAllThrows "PAIR"
    
    [<Fact>]
    member _.``Approve TwoPair``() =
        verifyAllThrows "TWO_PAIRS"
    
    [<Fact>]
    member _.``Approve FourOfAKind``() =
        verifyAllThrows "FOUR_OF_A_KIND"
    
    [<Fact>]
    member _.``Approve ThreeOfAKind``() =
        verifyAllThrows "THREE_OF_A_KIND"
    
    [<Fact>]
    member _.``Approve SmallStraight``() =
        verifyAllThrows "SMALL_STRAIGHT"
    
    [<Fact>]
    member _.``Approve LargeStraight``() =
        verifyAllThrows "LARGE_STRAIGHT"
    
    [<Fact>]
    member _.``Approve FullHouse``() =
        verifyAllThrows "FULL_HOUSE"
    
    [<Fact>]
    member _.``Approve Yatzy``() =
        verifyAllThrows "YATZY"

