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

def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

def sqrt(x: Double): Double = {
  fixedPoint(averageDamp(y => x / y))(1)
}


fixedPoint(x => 1 + x / 2)(54)

sqrt(2)
sqrt(4)