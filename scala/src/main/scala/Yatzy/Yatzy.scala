package Yatzy

class Yatzy(
    private val d1: Int,
    private val d2: Int,
    private val d3: Int,
    private val d4: Int,
    private val d5: Int
) {
  private val dice: List[Int] = List(d1, d2, d3, d4, d5)

  def fives(): Int = {
    var s = 0
    for (i <- 0 until dice.length) {
      if (dice(i) == 5)
        s = s + 5
    }
    s
  }
}

object Yatzy {
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
}
