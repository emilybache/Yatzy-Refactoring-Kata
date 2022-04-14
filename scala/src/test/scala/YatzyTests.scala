import Yatzy.Yatzy
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class YatzyTests extends AnyFunSuite with Matchers {
  test("Chance scores sum of all dice") {
    val expected = 15
    val actual = Yatzy.chance(2, 3, 4, 5, 1)

    assert(actual == expected)
    assert(Yatzy.chance(3, 3, 4, 5, 1) == 16)
  }

  test("test_1s") {
    assert(Yatzy.ones(1, 2, 3, 4, 5) == 1)
    assert(Yatzy.ones(1, 2, 1, 4, 5) == 2)
    assert(Yatzy.ones(6, 2, 2, 4, 5) == 0)
    assert(Yatzy.ones(1, 2, 1, 1, 1) == 4)
  }

  test("test_2s") {
    assert(Yatzy.twos(1, 2, 3, 2, 6) == 4)
    assert(Yatzy.twos(2, 2, 2, 2, 2) == 10)
  }

  test("test_3s") {
    assert(Yatzy.threes(1, 2, 3, 2, 3) == 6)
    assert(Yatzy.threes(2, 3, 3, 3, 3) == 12)
  }
}
