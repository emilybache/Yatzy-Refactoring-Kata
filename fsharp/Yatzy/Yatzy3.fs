module Yatzy.Yatzy3
    
type YatzyCategory =
    | CHANCE
    | YATZY
    | ONES
    | TWOS
    | THREES
    | FOURS
    | FIVES
    | SIXES
    | PAIR
    | THREE_OF_A_KIND
    | FOUR_OF_A_KIND
    | SMALL_STRAIGHT
    | LARGE_STRAIGHT
    | TWO_PAIRS
    | FULL_HOUSE

type CategoryScorer =
    abstract member CalculateScore: int list -> int

let frequencies (dice: int list) =
    [6..-1..1]
    |> List.map (fun i -> i, dice |> List.filter ((=) i) |> List.length)
    |> Map.ofList

let sum (dice: int list) = List.sum dice

type ChanceScorer() =
    interface CategoryScorer with
        member _.CalculateScore(dice) = sum dice

type FullHouseScorer() =
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            let counts = freqs |> Map.toList |> List.map snd
            if List.contains 2 counts && List.contains 3 counts then
                sum dice
            else
                0

type NumberScorer(number: int) =
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            freqs[number] * number

type RepeatedCountScorer(count: int) =
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            [6..-1..1]
            |> List.tryFind (fun i -> freqs[i] >= count)
            |> Option.map (fun i -> i * count)
            |> Option.defaultValue 0

type StraightScorer(straightIncludes: int) =
    let isStraight dice =
        let freqs = frequencies dice
        freqs 
        |> Map.toList 
        |> List.filter (fun (_, count) -> count = 1) 
        |> List.length = 5
    
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            if isStraight dice && freqs[straightIncludes] <> 0 then
                sum dice
            else
                0

type TwoPairsScorer() =
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            let pairsCount = 
                freqs 
                |> Map.toList 
                |> List.filter (fun (_, count) -> count >= 2) 
                |> List.length
            
            if pairsCount = 2 then
                [6..-1..1]
                |> List.filter (fun i -> freqs[i] >= 2)
                |> List.sumBy (fun i -> i * 2)
            else
                0

type YatzyPointsScorer() =
    interface CategoryScorer with
        member _.CalculateScore(dice) =
            let freqs = frequencies dice
            let hasFiveOfKind = 
                freqs 
                |> Map.toList 
                |> List.exists (fun (_, count) -> count = 5)
            
            if hasFiveOfKind then 50 else 0

let createScorer category =
    match category with
    | CHANCE -> ChanceScorer() :> CategoryScorer
    | YATZY -> YatzyPointsScorer()
    | ONES -> NumberScorer(1)
    | TWOS -> NumberScorer(2)
    | THREES -> NumberScorer(3)
    | FOURS -> NumberScorer(4)
    | FIVES -> NumberScorer(5)
    | SIXES -> NumberScorer(6)
    | PAIR -> RepeatedCountScorer(2)
    | THREE_OF_A_KIND -> RepeatedCountScorer(3)
    | FOUR_OF_A_KIND -> RepeatedCountScorer(4)
    | SMALL_STRAIGHT -> StraightScorer(1)
    | LARGE_STRAIGHT -> StraightScorer(6)
    | TWO_PAIRS -> TwoPairsScorer()
    | FULL_HOUSE -> FullHouseScorer()

open Microsoft.FSharp.Reflection

let parseCategoryFromString (categoryName: string) : YatzyCategory option =
    match FSharpType.GetUnionCases typeof<YatzyCategory> |> Array.tryFind _.Name.Equals(categoryName.ToUpper(), System.StringComparison.Ordinal) with
    | Some case -> (FSharpValue.MakeUnion(case, [||]) :?> YatzyCategory) |> Some
    | None -> None

type Yatzy() =
    member _.ValidCategories() : string list =
        FSharpType.GetUnionCases typeof<YatzyCategory>
        |> Array.map (fun case -> case.Name)
        |> Array.toList
    
    member _.Score(dice: int list, categoryName: string) : int =
        match parseCategoryFromString categoryName with
        | Some category ->
            let scorer = createScorer category
            scorer.CalculateScore(dice)
        | None ->
            failwithf $"Invalid category: %s{categoryName}"
