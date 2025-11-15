module Yatzy2

open System.Collections.Generic

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

let private DICE_VALUES = [6; 5; 4; 3; 2; 1]
    
let score (dice, category) =
    // calculate dice frequencies
    let diceFrequencies = Dictionary<int, int>()
    for i in DICE_VALUES do
        diceFrequencies[i] <- 0
    for die in dice do
        diceFrequencies[die] <- diceFrequencies[die] + 1
    
    // calculate the score
    match category with
    | YatzyCategory.CHANCE ->
        // chance sums the dice
        dice |> List.sum
    
    | YatzyCategory.YATZY ->
        // score for yatzy if all dice are the same
        let mutable yatzyResult = 0
        if diceFrequencies.Values |> Seq.contains 5 then
            yatzyResult <- 50
        yatzyResult
    
    | YatzyCategory.ONES ->
        // sum all the ones
        diceFrequencies[1]
    
    | YatzyCategory.TWOS ->
        // sum all the twos
        diceFrequencies[2] * 2
    
    | YatzyCategory.THREES ->
        // sum all the threes
        diceFrequencies[3] * 3
    
    | YatzyCategory.FOURS ->
        // sum all the fours
        diceFrequencies[4] * 4
    
    | YatzyCategory.FIVES ->
        // sum all the fives
        diceFrequencies[5] * 5
    
    | YatzyCategory.SIXES ->
        // sum all the sixes
        diceFrequencies[6] * 6
    
    | YatzyCategory.PAIR ->
        // score pair if two dice are the same
        let mutable pairResult = 0
        // score highest pair if there is more than one
        for i in DICE_VALUES do
            if diceFrequencies[i] >= 2 && pairResult = 0 then
                pairResult <- i * 2
                // break out of loop (using mutable flag to simulate break)
                ()
        pairResult
    
    | YatzyCategory.THREE_OF_A_KIND ->
        // score if three dice are the same
        let mutable threeKindResult = 0
        for i in DICE_VALUES do
            if diceFrequencies[i] >= 3 then
                threeKindResult <- i * 3
                ()
        threeKindResult
    
    | YatzyCategory.FOUR_OF_A_KIND ->
        // score if four dice are the same
        let mutable fourKindResult = 0
        for i in DICE_VALUES do
            if diceFrequencies[i] >= 4 then
                fourKindResult <- i * 4
                ()
        fourKindResult
    
    | YatzyCategory.SMALL_STRAIGHT ->
        // score if dice contains 1,2,3,4,5
        let mutable smallStraightResult = 0
        let mutable count = 0L
        for frequency in diceFrequencies.Values do
            if frequency = 1 then
                count <- count + 1L
        
        if count = 5L && diceFrequencies[6] = 0 then
            for die in dice do
                smallStraightResult <- smallStraightResult + die
        
        smallStraightResult
    
    | YatzyCategory.LARGE_STRAIGHT ->
        // score if dice contains 2,3,4,5,6
        let mutable largeStraightResult = 0
        let mutable straightCount = 0L
        for frequency in diceFrequencies.Values do
            if frequency = 1 then
                straightCount <- straightCount + 1L
        
        if straightCount = 5L && diceFrequencies[1] = 0 then
            for die in dice do
                largeStraightResult <- largeStraightResult + die
        
        largeStraightResult
    
    | YatzyCategory.TWO_PAIRS ->
        // score if there are two pairs
        let mutable twoPairResult = 0
        let mutable pairCount = 0L
        for frequency in diceFrequencies.Values do
            if frequency >= 2 then
                pairCount <- pairCount + 1L
        
        if pairCount = 2L then
            for i in DICE_VALUES do
                if diceFrequencies[i] >= 2 then
                    twoPairResult <- twoPairResult + i * 2
        
        twoPairResult
    
    | YatzyCategory.FULL_HOUSE ->
        // score if there is a pair as well as three of a kind
        let mutable fullHouseResult = 0
        if diceFrequencies.Values |> Seq.contains 2 && diceFrequencies.Values |> Seq.contains 3 then
            for die in dice do
                fullHouseResult <- fullHouseResult + die
        
        fullHouseResult
