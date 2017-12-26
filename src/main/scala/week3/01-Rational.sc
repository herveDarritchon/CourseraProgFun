val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denom

x + y

val neg = -x
neg.numer
neg.denom

x - y
x subElegant y

x - y - z

y + y

x < y

x max y

new Rational(3)

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero")

  val g = gcd(x, y)
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
