import "qa"

yatzy = function(a,b,c,d,e)
	this = {}
	this.dice = [a,b,c,d,e]
	
	this.fours = function
		sum = 0
		for a in range(0,4)
			if this.dice[a] == 4 then sum = sum + 4 
		end for
		return sum
	end function
	
	this.fives = function
		sum = 0
		for a in range(0,4,1)
			if this.dice[a] == 5 then sum = sum + 5 
		end for
		return sum
	end function
	
	this.sixes = function
		sum = 0
		for a in range(4)
			if this.dice[a] == 6 then sum = sum + 6 
		end for
		return sum
	end function
	
	this.scorePair = function   
		counts = [0, 0, 0, 0, 0, 0, 0, 0, 0];
		counts[a-1]+=1;
		counts[b-1]+=1;
		counts[c-1]+=1;
		counts[d-1]+=1;
		counts[e-1]+=1;
		for at in range(0,5)
			if (counts[6-at-1] >= 2) then
				return (6-at)*2
			end if
		end for
		return 0
	end function
	
	this.yatzy = function
		counts = [0, 0, 0, 0, 0, 0, 0, 0];
		for i in range(0,4)
			die = this.dice[i]
			counts[die-1]+=1
		end for
		for i in range(0,5)
			if (counts[i] == 5) then return 50
		end for
		return 0
	end function
	
	this.smallStraight = function
		tallies = [0, 0, 0, 0, 0, 0, 0]
		tallies[a-1] += 1;
		tallies[b-1] += 1;
		tallies[c-1] += 1;
		tallies[d-1] += 1;
		tallies[e-1] += 1;
		if (tallies[0] == 1 and
		    tallies[1] == 1 and
		    tallies[2] == 1 and
		    tallies[3] == 1 and
		    tallies[4] == 1) then
			return 15;
		end if
		return 0;
	end function
	
	this.largeStraight = function(d1, d2, d3, d4, d5)
		tallies = [0, 0, 0, 0,0,0,0,0];
		tallies[d1-1] += 1;
		tallies[b-1] += 1;
		tallies[d3-1] += 1;
		tallies[d4-1] += 1;
		tallies[e-1] += 1;
		if (tallies[1] == 1 and
		    tallies[2] == 1 and
		    tallies[3] == 1 and
		    tallies[4] == 1 and
		    tallies[5] == 1) then
			return 20
		end if
		return 0;
	end function
	
	return this
end function

chance = function(d1, d2, d3, d4, d5)
	total = 0;
	total += d1;
	total += d2;
	total += d3;
	total += d4;
	total += d5;
	return total;
end function

ones = function(a,b,c,d,e)
	sum = 0;
	if a == 1 then sum+=1
	if b == 1 then sum+=1
	if c == 1 then sum+=1
	if d == 1 then sum+=1
	if e == 1 then
		sum+=1
	end if
	return sum;
end function

twos = function(a,b,c,d,e)
	sum = 0;
	if a == 2 then sum+=2
	if b == 2 then sum+=2
	if c == 2 then sum+=2
	if d == 2 then sum+=2
	if e == 2 then
		sum+=2
	end if
	return sum;
end function

threes = function(dice0, dice1, dice3, dice4, dice5)
	sum = 0
	if dice5 == 3 then sum = 3
	if dice0 == 3 then sum += 3
	if dice1 == 3 then sum = sum + 3
	if dice3 == 3 then sum += 3
	if 3 == dice4 then sum += 3
	return sum
end function

two_pair = function(d1, d2, d3, d4, d5)
	counts = [0, 0, 0, 0, 0, 0, 0, 0, 0]
	counts[d1-1] += 1
	counts[d2-1] += 1
	counts[d3-1] += 1
	counts[d4-1] += 1
	counts[d5-1] += 1
	n = 0
	score = 0
	for i in range(0, 5, 1)
		if (counts[6-i-1] >= 2) then
			n += 1;
			score += (6-i)
		end if
	end for
	if (n == 2) then
		return score * 2
	else
		return 0
	end if
end function

four_of_a_kind = function(_1, _2, d3, d4, d5)
	tallies = [0, 0, 0, 0, 0, 0, 0, 0]
	tallies[_1-1] += 1
	tallies[_2-1] += 1
	tallies[d3-1] += 1
	tallies[d4-1] += 1
	tallies[d5-1] += 1
	for i in range(5)
		if (tallies[i] >= 4) then
			return (i+1) * 4
		end if
	end for
	return 0
end function

three_of_a_kind = function(d1, d2, d3, d4, d5)
	t = [0, 0, 0, 0, 0, 0, 0, 0, 0]
	t[d1-1] += 1;
	t[d2-1] += 1;
	t[d3-1] += 1;
	t[d4-1] += 1;
	t[d5-1] += 1;
	for i in range(5)
		if (t[i] >= 3) then
			return (i+1) * 3
		end if
	end for
	return 0
end function

fullHouse = function(d1, d2, d3, d4, d5)
	_2 = 0;
	_2_at = 0;
	_3 = false;
	_3_at = 0;
	
	
	
	
	tallies = [0, 0, 0, 0, 0, 0, 0, 0];
	tallies[d1-1] += 1;
	tallies[d2-1] += 1;
	tallies[d3-1] += 1;
	tallies[d4-1] += 1;
	tallies[d5-1] += 1;
	
	for i in range(0, 5)
		if (tallies[i] == 2) then
			_2 = true;
			_2_at = i+1;
		end if
	end for
	
	for i in range(0, 5, 1)
		if (tallies[i] == 3) then
			_3 = 1;
			_3_at = i+1;
		end if
	end for
	
	if (_2 and _3) then
		return _2_at * 2 + _3_at * 3;
	else
		return 0;
	end if
end function


testFours = function
	qa.assertEqual(12, yatzy(4,4,4,5,5).fours)
	qa.assertEqual(8, yatzy(4,4,5,5,5).fours)
	qa.assertEqual(4, yatzy(4,5,5,5,5).fours)
end function

testFives = function
	qa.assertEqual(10, yatzy(4,4,4,5,5).fives)
	qa.assertEqual(15, yatzy(4,4,5,5,5).fives)
	qa.assertEqual(20, yatzy(4,5,5,5,5).fives)
end function

testSixes = function
	qa.assertEqual(0, yatzy(4,4,4,5,5).sixes)
	qa.assertEqual(6, yatzy(4,4,6,5,5).sixes)
	qa.assertEqual(18, yatzy(6,5,6,5,6).sixes)
end function

testScorePair = function
	qa.assertEqual(6, yatzy(3,4,3,5,6).scorePair)
	qa.assertEqual(10, yatzy(5,3,3,3,5).scorePair)
	qa.assertEqual(12, yatzy(5,3,6,6,5).scorePair)
end function

testChance = function
	expected = 15
	actual = chance(2, 3, 4, 5, 1)
	qa.assertEqual expected, actual
	qa.assertEqual(16, chance(3, 3, 4, 5, 1))
end function

testYatzy = function
	qa.assertEqual(50, yatzy(4,4,4,4,4).yatzy)
	qa.assertEqual(50, yatzy(6,6,6,6,6).yatzy)
	qa.assertEqual(0, yatzy(6,6,6,6,3).yatzy)
end function

testOnes = function
	qa.assertEqual(1, ones(1,2,3,4,5))
	qa.assertEqual(2, ones(1,2,1,4,5))
	qa.assertEqual(0, ones(6,2,2,4,5))
	qa.assertEqual(4, ones(1,2,1,1,1))
end function

testTwos = function
	qa.assertEqual(4, twos(1,2,3,2,6));
	qa.assertEqual(10, twos(2,2,2,2,2));
end function

testThrees = function
	qa.assertEqual(6, threes(1,2,3,2,3))
	qa.assertEqual(12, threes(2,3,3,3,3))
end function

testTwoPairs = function
	qa.assertEqual(16, two_pair(3,3,5,4,5))
	qa.assertEqual(16, two_pair(3,3,5,5,5))
end function

testFourOfAKind = function
	qa.assertEqual(12, four_of_a_kind(3,3,3,3,5))
	qa.assertEqual(20, four_of_a_kind(5,5,5,4,5))
	qa.assertEqual(9, three_of_a_kind(3,3,3,3,3))	
end function

testThreeOfAKind = function
	qa.assertEqual(9, three_of_a_kind(3,3,3,4,5));
	qa.assertEqual(15, three_of_a_kind(5,3,5,4,5));
	qa.assertEqual(9, three_of_a_kind(3,3,3,3,5));	
end function

testSmallStraight = function
	qa.assertEqual(15, yatzy(1,2,3,4,5).smallStraight())
	qa.assertEqual(15, yatzy(2,3,4,5,1).smallStraight())
	qa.assertEqual(0, yatzy(1,2,2,4,5).smallStraight())	
end function

testLargeStraight = function
	qa.assertEqual(20, yatzy(6,2,3,4,5).largeStraight(6,2,3,4,5));
	qa.assertEqual(20, yatzy(2,3,4,5,6).largeStraight(2,3,4,5,6));
	qa.assertEqual(0, yatzy(1,2,2,4,5).largeStraight(1,2,2,4,5));
end function

testFullHouse = function
	qa.assertEqual(18, fullHouse(6,2,2,2,6));
	qa.assertEqual(0, fullHouse(2,3,4,5,6));
end function

if globals == locals then
	testFours
	testFives
	testSixes
	testScorePair
	testChance
	testYatzy
	testOnes
	testTwos
	testThrees
	testTwoPairs
	testFourOfAKind
	testThreeOfAKind
	testSmallStraight
	testLargeStraight
	testFullHouse
	print "Ran all test."
end if