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
}
