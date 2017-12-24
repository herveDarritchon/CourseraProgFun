def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {

  def tolerance: Double = 0.0001

  def abs(x: Double): Double =
    if (x < 0) -x else x

  def isGoodEnough(x: Double, y: Double): Boolean = {
    abs((x - y) / x) / x < tolerance
  }

  def iterate(guess: Double): Double = {
    val next = f(guess)
    if (isGoodEnough(guess, next)) {
      guess
    } else {
      iterate(f(guess))
    }
  }

  iterate(firstGuess)

}

fixedPoint(x => 1 + x / 2)(54)