val x = new Rational(1, 2)
val y = new Rational(2, 3)

x.numer
x.denom

val r: Rational = addRational(x, y)

makeString(r)

class Rational(x: Int, y: Int) {
  def numer: Int = x

  def denom: Int = y
}


// External function

def addRational(rat1: Rational, rat2: Rational): Rational =
  new Rational(
    rat1.numer * rat2.denom + rat1.denom * rat2.numer,
    rat1.denom * rat2.denom)

def makeString(rat: Rational): String =
  rat.numer + "/" + rat.denom