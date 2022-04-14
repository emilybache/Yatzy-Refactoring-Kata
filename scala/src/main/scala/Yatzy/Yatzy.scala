package Yatzy

class Yatzy(
    private val d1: Int,
    private val d2: Int,
    val d3: Int,
    private val d4: Int,
    val d5: Int
) {
  val dice: List[Int] = List(d1, d2, d3, d4, d5)

  def fives(): Int = {
    var s = 0
    for (i <- 0 until dice.length) {
      if (dice(i) == 5)
        s = s + 5
    }
    s
  }

  def fours(): Int = {
    var sum = 0
    sum = 0
    for (at <- 0 until 5) {
      if (dice(at) == 4) sum += 4
    }
    return sum
  }

  def Sixes(): Int = {
    var sum = 0
    sum = 0
    for (at <- 0 until 5) {
      if (dice(at) == 6)
        sum += 6
    }
    sum
  }
}

object Yatzy {
  def Yatzy(dice: Int*): Int = {
    val counts = new Array[Int](6)
    for (die <- dice) {
      counts(die - 1) += 1
    }
    for (i <- 0 until 6) {
      if (counts(i) == 5)
        return 50
    }
    0
  }

  def chance(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var total: Int = 0
    total += d1
    total += d2
    total += d3
    total += d4
    total += d5
    total
  }

  def ones(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var sum = 0
    if (d1 == 1) sum += 1
    if (d2 == 1) sum += 1
    if (d3 == 1) sum += 1
    if (d4 == 1) sum += 1
    if (d5 == 1) sum += 1
    sum
  }

  def twos(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var sum = 0
    if (d1 == 2) sum += 2
    if (d2 == 2) sum += 2
    if (d3 == 2) sum += 2
    if (d4 == 2) sum += 2
    if (d5 == 2) sum += 2
    sum
  }

  def threes(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var sum = 0
    if (d1 == 3) sum += 3
    if (d2 == 3) sum += 3
    if (d3 == 3) sum += 3
    if (d4 == 3) sum += 3
    if (d5 == 3) sum += 3
    sum
  }

  def scorePair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    val counts = new Array[Int](6)
    counts(d1 - 1) += 1
    counts(d2 - 1) += 1
    counts(d3 - 1) += 1
    counts(d4 - 1) += 1
    counts(d5 - 1) += 1

    var at = 0
    while (at != 6) {
      if (counts(6 - at - 1) >= 2)
        return (6 - at) * 2
      at += 1
    }
    0
  }

  def twoPair(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    val counts = new Array[Int](6)
    counts(d1 - 1) += 1
    counts(d2 - 1) += 1
    counts(d3 - 1) += 1
    counts(d4 - 1) += 1
    counts(d5 - 1) += 1
    var n = 0
    var score = 0
    for (i <- 0 until 6) {
      if (counts(6 - i - 1) >= 2) {
        n += 1
        score += 6 - i
      }
    }

    if (n == 2)
      return score * 2
    0
  }

  def threeOfAKind(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    val t = new Array[Int](6)
    t(d1 - 1) += 1
    t(d2 - 1) += 1
    t(d3 - 1) += 1
    t(d4 - 1) += 1
    t(d5 - 1) += 1
    for (i <- 0 until 6) {
      if (t(i) >= 3) return (i + 1) * 3
    }
    0
  }

  def fourOfAKind(_1: Int, _2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var tallies = new Array[Int](6)
    tallies(_1 - 1) += 1
    tallies(_2 - 1) += 1
    tallies(d3 - 1) += 1
    tallies(d4 - 1) += 1
    tallies(d5 - 1) += 1

    for (i <- 0 until 6) {
      if (tallies(i) >= 4)
        return (i + 1) * 4
    }
    0
  }

  def smallStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var tallies = new Array[Int](6)
    tallies(d1 - 1) += 1
    tallies(d2 - 1) += 1
    tallies(d3 - 1) += 1
    tallies(d4 - 1) += 1
    tallies(d5 - 1) += 1
    if (
      tallies(0) == 1 &&
      tallies(1) == 1 &&
      tallies(2) == 1 &&
      tallies(3) == 1 &&
      tallies(4) == 1
    ) 15
    else 0
  }

  def largeStraight(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var tallies = new Array[Int](6)
    tallies(d1 - 1) += 1
    tallies(d2 - 1) += 1
    tallies(d3 - 1) += 1
    tallies(d4 - 1) += 1
    tallies(d5 - 1) += 1
    if (
      tallies(1) == 1 &&
      tallies(2) == 1 &&
      tallies(3) == 1 &&
      tallies(4) == 1 &&
      tallies(5) == 1
    ) return 20
    0
  }

  def fullHouse(d1: Int, d2: Int, d3: Int, d4: Int, d5: Int): Int = {
    var tallies = new Array[Int](6)
    var _2 = false
    var i = 0
    var _2_at = 0
    var _3 = false
    var _3_at = 0

    tallies(d1 - 1) += 1
    tallies(d2 - 1) += 1
    tallies(d3 - 1) += 1
    tallies(d4 - 1) += 1
    tallies(d5 - 1) += 1

    i = 0
    while (i != 6) {
      if (tallies(i) == 2) {
        _2 = true
        _2_at = i + 1
      }
      i += 1
    }

    i = 0
    while (i != 6) {
      if (tallies(i) == 3) {
        _3 = true
        _3_at = i + 1
      }
      i += 1
    }

    if (_2 && _3)
      _2_at * 2 + _3_at * 3
    else 0
  }
}
