module Yatzy.Yatzy1

let private dice d1 d2 d3 d4 d5 = 
    [| d1; d2; d3; d4; d5 |]

let chance(d1, d2, d3, d4, d5) =
    let mutable total = 0
    total <- total + d1
    total <- total + d2
    total <- total + d3
    total <- total + d4
    total <- total + d5
    total

let yatzy([<System.ParamArray>] dice: int[]) =
    let counts = Array.zeroCreate<int> 6
    for die in dice do
        counts.[die - 1] <- counts.[die - 1] + 1
    
    let mutable result = 0
    for i = 0 to 5 do
        if counts.[i] = 5 then
            result <- 50
    result

let ones(d1, d2, d3, d4, d5) =
    let mutable sum = 0
    if d1 = 1 then sum <- sum + 1
    if d2 = 1 then sum <- sum + 1
    if d3 = 1 then sum <- sum + 1
    if d4 = 1 then sum <- sum + 1
    if d5 = 1 then sum <- sum + 1
    sum

let twos(d1, d2, d3, d4, d5) =
    let mutable sum = 0
    if d1 = 2 then sum <- sum + 2
    if d2 = 2 then sum <- sum + 2
    if d3 = 2 then sum <- sum + 2
    if d4 = 2 then sum <- sum + 2
    if d5 = 2 then sum <- sum + 2
    sum

let threes(d1, d2, d3, d4, d5) =
    let mutable s = 0
    if d1 = 3 then s <- s + 3
    if d2 = 3 then s <- s + 3
    if d3 = 3 then s <- s + 3
    if d4 = 3 then s <- s + 3
    if d5 = 3 then s <- s + 3
    s

let fours d1 d2 d3 d4 d5 =
    let dice = dice d1 d2 d3 d4 d5
    let mutable sum = 0
    for at = 0 to 4 do
        if dice.[at] = 4 then
            sum <- sum + 4
    sum

let fives d1 d2 d3 d4 d5 =
    let dice = dice d1 d2 d3 d4 d5
    let mutable s = 0
    for i = 0 to dice.Length - 1 do
        if dice.[i] = 5 then
            s <- s + 5
    s

let sixes d1 d2 d3 d4 d5 =
    let dice = dice d1 d2 d3 d4 d5
    let mutable sum = 0
    for at = 0 to dice.Length - 1 do
        if dice.[at] = 6 then
            sum <- sum + 6
    sum

let scorePair(d1, d2, d3, d4, d5) =
    let counts = Array.zeroCreate<int> 6
    counts.[d1 - 1] <- counts.[d1 - 1] + 1
    counts.[d2 - 1] <- counts.[d2 - 1] + 1
    counts.[d3 - 1] <- counts.[d3 - 1] + 1
    counts.[d4 - 1] <- counts.[d4 - 1] + 1
    counts.[d5 - 1] <- counts.[d5 - 1] + 1
    
    let mutable result = 0
    for at = 0 to 5 do
        if counts.[6 - at - 1] >= 2 && result = 0 then
            result <- (6 - at) * 2
    result

let twoPair(d1, d2, d3, d4, d5) =
    let counts = Array.zeroCreate<int> 6
    counts.[d1 - 1] <- counts.[d1 - 1] + 1
    counts.[d2 - 1] <- counts.[d2 - 1] + 1
    counts.[d3 - 1] <- counts.[d3 - 1] + 1
    counts.[d4 - 1] <- counts.[d4 - 1] + 1
    counts.[d5 - 1] <- counts.[d5 - 1] + 1
    
    let mutable n = 0
    let mutable score = 0
    for i = 0 to 5 do
        if counts.[6 - i - 1] >= 2 then
            n <- n + 1
            score <- score + (6 - i)
    
    if n = 2 then score * 2 else 0

let fourOfAKind(_1, _2, d3, d4, d5) =
    let tallies = Array.zeroCreate<int> 6
    tallies.[_1 - 1] <- tallies.[_1 - 1] + 1
    tallies.[_2 - 1] <- tallies.[_2 - 1] + 1
    tallies.[d3 - 1] <- tallies.[d3 - 1] + 1
    tallies.[d4 - 1] <- tallies.[d4 - 1] + 1
    tallies.[d5 - 1] <- tallies.[d5 - 1] + 1
    
    let mutable result = 0
    for i = 0 to 5 do
        if tallies.[i] >= 4 then
            result <- (i + 1) * 4
    result

let threeOfAKind(d1, d2, d3, d4, d5) =
    let t = Array.zeroCreate<int> 6
    t.[d1 - 1] <- t.[d1 - 1] + 1
    t.[d2 - 1] <- t.[d2 - 1] + 1
    t.[d3 - 1] <- t.[d3 - 1] + 1
    t.[d4 - 1] <- t.[d4 - 1] + 1
    t.[d5 - 1] <- t.[d5 - 1] + 1
    
    let mutable result = 0
    for i = 0 to 5 do
        if t.[i] >= 3 then
            result <- (i + 1) * 3
    result

let smallStraight(d1, d2, d3, d4, d5) =
    let tallies = Array.zeroCreate<int> 6
    tallies.[d1 - 1] <- tallies.[d1 - 1] + 1
    tallies.[d2 - 1] <- tallies.[d2 - 1] + 1
    tallies.[d3 - 1] <- tallies.[d3 - 1] + 1
    tallies.[d4 - 1] <- tallies.[d4 - 1] + 1
    tallies.[d5 - 1] <- tallies.[d5 - 1] + 1
    
    if tallies.[0] = 1 &&
       tallies.[1] = 1 &&
       tallies.[2] = 1 &&
       tallies.[3] = 1 &&
       tallies.[4] = 1 then
        15
    else
        0

let largeStraight(d1, d2, d3, d4, d5) =
    let tallies = Array.zeroCreate<int> 6
    tallies.[d1 - 1] <- tallies.[d1 - 1] + 1
    tallies.[d2 - 1] <- tallies.[d2 - 1] + 1
    tallies.[d3 - 1] <- tallies.[d3 - 1] + 1
    tallies.[d4 - 1] <- tallies.[d4 - 1] + 1
    tallies.[d5 - 1] <- tallies.[d5 - 1] + 1
    
    if tallies.[1] = 1 &&
       tallies.[2] = 1 &&
       tallies.[3] = 1 &&
       tallies.[4] = 1 &&
       tallies.[5] = 1 then
        20
    else
        0

let fullHouse(d1, d2, d3, d4, d5) =
    let tallies = Array.zeroCreate<int> 6
    tallies.[d1 - 1] <- tallies.[d1 - 1] + 1
    tallies.[d2 - 1] <- tallies.[d2 - 1] + 1
    tallies.[d3 - 1] <- tallies.[d3 - 1] + 1
    tallies.[d4 - 1] <- tallies.[d4 - 1] + 1
    tallies.[d5 - 1] <- tallies.[d5 - 1] + 1
    
    let mutable _2 = false
    let mutable _2_at = 0
    let mutable _3 = false
    let mutable _3_at = 0
    
    for i = 0 to 5 do
        if tallies.[i] = 2 then
            _2 <- true
            _2_at <- i + 1
    
    for i = 0 to 5 do
        if tallies.[i] = 3 then
            _3 <- true
            _3_at <- i + 1
    
    if _2 && _3 then
        _2_at * 2 + _3_at * 3
    else
        0

