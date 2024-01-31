pub struct Yatzy {
    dice: [i32; 5]
}

impl Yatzy {
    pub fn chance(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 
    {
        let mut total: i32 = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    pub fn yatzy(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32
    {
        let dice = [d1, d2, d3, d4, d5];
        let mut counts = [0; 6];
        for die in dice 
            {counts[(die - 1) as usize] += 1;}
        let mut i = 0;
        while i != 6 {
            if (counts[i] == 5) 
                {return 50;}
            i += 1;
        }
        return 0;
    }

    pub fn ones(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 {
        let mut sum = 0;
        if (d1 == 1) {sum+=1;}
        if (d2 == 1) {sum+=1;}
        if (d3 == 1) {sum+=1;}
        if (d4 == 1) {sum+=1;}
        if (d5 == 1) 
            {sum+=1;}
    
        return sum;
    }

    pub fn twos(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 {
        let mut sum = 0;
        if (d1 == 2) {sum += 2;}
        if (d2 == 2) {sum += 2;}
        if (d3 == 2) {sum += 2;}
        if (d4 == 2) {sum += 2;}
        if (d5 == 2) {sum += 2;}
        return sum;
    }

    pub fn threes(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 {
        let mut s: i32;    
        s = 0;
        if (d1 == 3) {s += 3;}
        if (d2 == 3) {s += 3;}
        if (d3 == 3) {s += 3;}
        if (d4 == 3) {s += 3;}
        if (d5 == 3) {s += 3;}
        return s;
    }

    pub fn new(d1: i32, d2: i32, d3: i32, d4: i32, _5: i32) -> Self 
    {
        Yatzy {
            dice: [d1,d2,d3,d4,_5]
        }
    }
    
    pub fn fours(&self) -> i32 
    {
        let mut sum;    
        sum = 0;
        let mut at = 0;
        while at != 5 {
            if (self.dice[at] == 4) {
                sum += 4;
            }
            at+=1
        }
        return sum;
    }

    pub fn fives(&self) -> i32 
    {
        let mut s = 0;
        let mut i = 0;
        while i < self.dice.len() {
            if (self.dice[i] == 5)
                {s = s + 5;}
            i+=1;
        }
        return s;
    }

    pub fn sixes(&self) -> i32
    {
        let mut sum = 0;
        let mut at = 0;
        while at < self.dice.len() {
            if (self.dice[at] == 6)
                {sum = sum + 6;}
            at +=1;
        }
        return sum;
    }

    pub fn score_pair(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 
    {
        let mut counts = [0; 6];
        counts[(d1-1) as usize]+=1;
        counts[(d2-1) as usize]+=1;
        counts[(d3-1) as usize]+=1;
        counts[(d4-1) as usize]+=1;
        counts[(d5-1) as usize]+=1;
        let mut at: i32 = 0;
        while at != 6 {
            if (counts[(6-at-1) as usize] >= 2)
                {return (6-at)*2}
            at+=1
        }
        return 0;
    }

    pub fn two_pair(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32
    {
        let mut counts = [0; 6];
        counts[(d1-1) as usize]+=1;
        counts[(d2-1) as usize]+=1;
        counts[(d3-1) as usize]+=1;
        counts[(d4-1) as usize]+=1;
        counts[(d5-1) as usize]+=1;
        let mut n = 0;
        let mut score: i32 = 0;
        let mut i: i32 = 0;
        while i < 6 {
            if (counts[(6-i-1) as usize] >= 2) {
                n+=1;
                score += (6-i);
            }
            i += 1;
        }
        if (n == 2) 
            {return score * 2;}
        else
            {return 0;}
    }

    pub fn four_of_a_kind(_1: i32, _2: i32, d3: i32, d4: i32, d5: i32) -> i32
    {
        let mut tallies;
        tallies = [0; 6];
        tallies[(_1-1) as usize]+=1;
        tallies[(_2-1) as usize]+=1;
        tallies[(d3-1) as usize]+=1;
        tallies[(d4-1) as usize]+=1;
        tallies[(d5-1) as usize]+=1;
        let mut i: i32 = 0;
        while i < 6 {
            if (tallies[i as usize] >= 4)
                {return (i+1) * 4}
            i+=1;
        }
        return 0;
    }
    
    pub fn three_of_a_kind(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 {
        let mut t;
        t = [0; 6];
        t[(d1-1) as usize]+=1;
        t[(d2-1) as usize]+=1;
        t[(d3-1) as usize]+=1;
        t[(d4-1) as usize]+=1;
        t[(d5-1) as usize]+=1;
        let mut i: i32 = 0;
        while i < 6 {
            if (t[i as usize] >= 3)
                {return (i+1) * 3}
            i+=1;
        }
        return 0;
    }

    pub fn smallStraight(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32
    {
        let mut tallies;
        tallies = [0; 6];
        tallies[(d1-1) as usize] += 1;
        tallies[(d2-1) as usize] += 1;
        tallies[(d3-1) as usize] += 1;
        tallies[(d4-1) as usize] += 1;
        tallies[(d5-1) as usize] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            {return 15;}
        return 0;
    }

    pub fn largeStraight(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 
    {
        let mut tallies;
        tallies = [0; 6];
        tallies[(d1-1) as usize] += 1;
        tallies[(d2-1) as usize] += 1;
        tallies[(d3-1) as usize] += 1;
        tallies[(d4-1) as usize] += 1;
        tallies[(d5-1) as usize] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            {return 20;}
        return 0;
    }

    pub fn fullHouse(d1: i32, d2: i32, d3: i32, d4: i32, d5: i32) -> i32 
    {
        let mut tallies;
        let mut _2 = false;
        let mut i;
        let mut _2_at: i32 = 0;
        let mut _3 = false;
        let mut _3_at: i32 = 0;




        tallies = [0; 6];
        tallies[(d1-1) as usize] += 1;
        tallies[(d2-1) as usize] += 1;
        tallies[(d3-1) as usize] += 1;
        tallies[(d4-1) as usize] += 1;
        tallies[(d5-1) as usize] += 1;

        i = 0;
        while i != 6 {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = (i+1) as i32;
            }
            i+=1
        }

        i = 0;
        while i != 6 {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = (i+1) as i32;
            }
            i += 1;
        }


        if (_2 && _3)
            {return _2_at * 2 + _3_at * 3;}
        else
            {return 0;}
    }
}


