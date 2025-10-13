package yatzy

trait YatzyCalculator {
  def validCategories: List[String]

  def score(dice: List[Int], category: String): Int
}
