val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denom

x add y

val neg = x.neg
neg.numer
neg.denom

x sub y
x subElegant y

x sub y sub z

y add y

x less y

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

  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def sub(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom,
      denom * that.denom)

  // A more elegant version of sub
  def subElegant(that: Rational): Rational =
    add(that.neg)

  def neg: Rational =
    new Rational(-numer, denom)

  def less(that: Rational): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational): Rational =
    if (this.less(that)) that else this

  override def toString: String =
    numer + "/" + denom

}
