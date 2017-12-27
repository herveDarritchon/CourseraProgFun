package week3

/**
  * Created by Hervé Darritchon on 27/12/2017.
  *
  */
class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero")

  val g : Int = gcd(x, y)
  assert(g > 0, "GCD must be positive")

  def numer: Int = x / g

  def denom: Int = y / g

  private def abs(x: Int): Int =
    if (x >= 0) x else -x

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) abs(a) else gcd(b, a % b)

  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom,
      denom * that.denom)

  // A more elegant version of -
  def subElegant(that: Rational): Rational =
    this + -that

  def unary_- : Rational =
    new Rational(-numer, denom)

  def <(that: Rational): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational): Rational =
    if (this.<(that)) that else this

  override def toString: String =
    numer + "/" + denom

}
