def sqrt(x: Double): Double = {

  def abs(x: Double): Double =
    if (x < 0) -x else x

  def isGoodEnough(guess: Double): Boolean = {
    abs(guess * guess - x) / x < 0.0001
  }

  def improve(guess: Double): Double = {
    (guess + x / guess) / 2
  }

  def sqrtIter(guess: Double): Double = {
    if (isGoodEnough(guess)) {
      guess
    } else {
      sqrtIter(improve(guess))
    }
  }

  sqrtIter(1)

}

sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)

def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)

gcd (14,21)