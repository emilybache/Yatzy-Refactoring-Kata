import Yatzy.Yatzy
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class YatzyTests extends AnyFunSuite with Matchers {
  test("Chance scores sum of all dice") {
    val expected = 15
    val actual = Yatzy.chance(2, 3, 4, 5, 1)

    assert(expected == actual)
    assert(16 == Yatzy.chance(3, 3, 4, 5, 1))
  }

  test("test_1s") {
    assert(1 == Yatzy.ones(1, 2, 3, 4, 5))
    assert(2 == Yatzy.ones(1, 2, 1, 4, 5))
    assert(0 == Yatzy.ones(6, 2, 2, 4, 5))
    assert(4 == Yatzy.ones(1, 2, 1, 1, 1))
  }
}
