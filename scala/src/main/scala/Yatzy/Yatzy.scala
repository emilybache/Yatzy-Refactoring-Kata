package Yatzy

class Yatzy {}

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
}
