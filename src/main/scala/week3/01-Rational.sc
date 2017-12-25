val x = new Rational(1, 2)
val y = new Rational(2,3)

x.numer
x.denom

x.add(y)

class Rational(x: Int, y: Int) {
  def numer: Int = x
  def denom: Int = y

  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  override def toString : String =
    numer + "/" + denom

}
