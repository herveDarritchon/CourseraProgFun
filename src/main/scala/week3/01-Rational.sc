val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)

x.numer
x.denom

x.add(y)

x.neg

x.sub(y)
x.subElegant(y)

x.sub(y).sub(z)

y.add(y)

class Rational(x: Int, y: Int) {

  val g = gcd(x, y)

  def numer: Int = x / g

  def denom: Int = y / g

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

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

  override def toString: String =
    numer + "/" + denom

}
