module Yatzy.Test.Yatzy1Test

open Xunit
open ApprovalTests
open ApprovalTests.Reporters
open Yatzy

type DiceThrow = 
    { Die1: int; Die2: int; Die3: int; Die4: int; Die5: int }
    
    member this.ToTuple() = 
        (this.Die1, this.Die2, this.Die3, this.Die4, this.Die5)
    
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
    
    let verifyAllThrows (scoringFunc: int * int * int * int * int -> int) =
        let formatter (t: DiceThrow) = 
            let result = t.ToTuple() |> scoringFunc
            $"{t} => %d{result}"
        Approvals.VerifyAll(throws, formatter)
    
    [<Fact>]
    member _.``Approve Chance``() =
        verifyAllThrows Yatzy1.chance
    
    [<Fact>]
    member _.``Approve Ones``() =
        verifyAllThrows Yatzy1.ones
    
    [<Fact>]
    member _.``Approve Twos``() =
        verifyAllThrows Yatzy1.twos
    
    [<Fact>]
    member _.``Approve Threes``() =
        verifyAllThrows Yatzy1.threes
    
    [<Fact>]
    member _.``Approve Fours``() =
        verifyAllThrows (fun (d1, d2, d3, d4, d5) -> Yatzy1.fours d1 d2 d3 d4 d5)
    
    [<Fact>]
    member _.``Approve Fives``() =
        verifyAllThrows (fun (d1, d2, d3, d4, d5) -> Yatzy1.fives d1 d2 d3 d4 d5)
    
    [<Fact>]
    member _.``Approve Sixes``() =
        verifyAllThrows (fun (d1, d2, d3, d4, d5) -> Yatzy1.sixes d1 d2 d3 d4 d5)
    
    [<Fact>]
    member _.``Approve ScorePair``() =
        verifyAllThrows Yatzy1.scorePair
    
    [<Fact>]
    member _.``Approve TwoPair``() =
        verifyAllThrows Yatzy1.twoPair
    
    [<Fact>]
    member _.``Approve FourOfAKind``() =
        verifyAllThrows Yatzy1.fourOfAKind
    
    [<Fact>]
    member _.``Approve ThreeOfAKind``() =
        verifyAllThrows Yatzy1.threeOfAKind
    
    [<Fact>]
    member _.``Approve SmallStraight``() =
        verifyAllThrows Yatzy1.smallStraight
    
    [<Fact>]
    member _.``Approve LargeStraight``() =
        verifyAllThrows Yatzy1.largeStraight
    
    [<Fact>]
    member _.``Approve FullHouse``() =
        verifyAllThrows Yatzy1.fullHouse
    
    [<Fact>]
    member _.``Approve Yatzy``() =
        verifyAllThrows (fun (d1, d2, d3, d4, d5) -> Yatzy1.yatzy [|d1; d2; d3; d4; d5|])