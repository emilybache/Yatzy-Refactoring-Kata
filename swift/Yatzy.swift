import Foundation

public class Yatzy {
    public static func chance(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var total = 0
        total += d1
        total += d2
        total += d3
        total += d4
        total += d5
        return total
    }
    
    public static func yatzy(dice: Int...) -> Int {
        var counts = [Int](repeating: 0, count:6)
        for die in dice {
            counts[die-1] += 1
            var i = 0;
            while i != 6 {
                if counts[i] == 5 {
                    return 50
                }
                i += 1
            }
        }
        return 0
    }
    
    public static func ones(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var sum = 0
        if d1 == 1 {
            sum += 1
        }
        if d2 == 1 {
            sum += 1
        }
        if d3 == 1 {
            sum += 1
        }
        if d4 == 1 {
            sum += 1
        }
        if d5 == 1 {
            sum += 1
        }
        return sum
    }
    
    public static func twos(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var sum = 0
        if d1 == 2 {
            sum += 2
        }
        if d2 == 2 {
            sum += 2
        }
        if d3 == 2 {
            sum += 2
        }
        if d4 == 2 {
            sum += 2
        }
        if d5 == 2 {
            sum += 2
        }
        return sum
    }
    
    public static func threes(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var s: Int
        s = 0
        if d1 == 3 {
            s += 3
        }
        if d2 == 3 {
            s += 3
        }
        if d3 == 3 {
            s += 3
        }
        if d4 == 3 {
            s += 3
        }
        if d5 == 3 {
            s += 3
        }
        return s
    }
    
    private var dice: [Int]
    
    public init(d1: Int, d2: Int, d3: Int, d4: Int, _5: Int) {
        dice = [Int](repeating:0, count:5)
        dice[0] = d1
        dice[1] = d2
        dice[2] = d3
        dice[3] = d4
        dice[4] = _5
    }

    public func fours() -> Int {
        var sum: Int
        sum = 0
        var at = 0
        while at != 5 {
            if dice[at] == 4 {
                sum += 4
            }
            at += 1
        }
        return sum
    }

    public func fives() -> Int {
        var s = 0
        var i = 0
        while i < dice.count {
            if dice[i] == 5 {
                s = s + 5
            }
            i += 1
        }
        return s
    }
    
    public func sixes() -> Int {
        var sum = 0
        var at = 0
        while at < dice.count {
            if dice[at] == 6 {
                sum = sum + 6
            }
            at += 1
        }
        return sum
    }

    public static func scorePair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var counts = [Int](repeating: 0, count: 6)
        counts[d1-1] += 1;
        counts[d2-1] += 1;
        counts[d3-1] += 1;
        counts[d4-1] += 1;
        counts[d5-1] += 1;
        var at = 0
        while at != 6 {
            if counts[6-at-1] >= 2 {
                return (6-at) * 2
            }
            at += 1
        }
        return 0
    }

    public static func twoPairs(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var counts = [Int](repeating: 0, count: 6)
        counts[d1-1] += 1;
        counts[d2-1] += 1;
        counts[d3-1] += 1;
        counts[d4-1] += 1;
        counts[d5-1] += 1;
        var n = 0
        var score = 0
        for i in 0..<6 {
            if counts[6-i-1] >= 2 {
                n += 1
                score += (6-i)
            }
        }
        if n == 2 {
            return score * 2
        } else {
            return 0
        }
    }

    public static func fourOfAKind(_1: Int, _2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var tallies: [Int]
        tallies = [Int](repeating: 0, count: 6)
        tallies[_1-1] += 1;
        tallies[_2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        var i = 0
        while i < 6 {
            if tallies[i] >= 4 {
                return (i + 1) * 4
            }
            i += 1
        }
        return 0
    }

    
    public static func threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var t: [Int]
        t = [Int](repeating: 0, count: 6)
        t[d1-1] += 1;
        t[d2-1] += 1;
        t[d3-1] += 1;
        t[d4-1] += 1;
        t[d5-1] += 1;
        var i = 0
        while i < 6 {
            if t[i] >= 3 {
                return (i+1) * 3
            }
            i += 1
        }
        return 0
    }

    public static func smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var tallies: [Int]
        tallies = [Int](repeating: 0, count: 6)
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1 {
                return 15
        }
        return 0
    }
    
    public static func largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var tallies: [Int]
        tallies = [Int](repeating: 0, count: 6)
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1 &&
            tallies[5] == 1 {
            return 20
        }
        return 0

    }

    public static func fullHouse(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int) -> Int {
        var tallies: [Int]
        var _2 = false
        var i: Int
        var _2_at = 0
        var _3 = false
        var _3_at = 0
        
        tallies = [Int](repeating: 0, count: 6)
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        
        i = 0
        while i != 6 {
            if tallies[i] == 2 {
                _2 = true
                _2_at = i+1
            }
            i += 1
        }
        
        i = 0
        while i != 6 {
            if tallies[i] == 3 {
                _3 = true
                _3_at = i + 1
            }
            i += 1
        }
        if _2 && _3 {
            return _2_at * 2 + _3_at * 3
        } else {
            return 0
        }
    }
    
}
