package week4.decomposition_full_expressive

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
trait Expr {

  def isNumber: Boolean

  def isSum: Boolean

  def isProd: Boolean

  def isVar: Boolean

  def numValue: Int

  def value: Int

  def leftOp: Expr

  def rightOp: Expr

}

object Number {
  def apply(n: Int) = new Number(n)
}

class Number(n: Int) extends Expr {

  def isNumber: Boolean = true

  def isSum: Boolean = false

  def isProd: Boolean = false

  def isVar: Boolean = false

  def numValue: Int = n

  def value: Int = throw new Error("No value for a Number")

  def leftOp: Expr = throw new Error("No leftOp for a Number")

  def rightOp: Expr = throw new Error("No leftOp for a Number")
}

object Var {
  def apply(x: String, v: Int) = new Var(x, v)
}

class Var(x: String, v: Int) extends Expr {

  def isNumber: Boolean = false

  def isSum: Boolean = false

  def isProd: Boolean = false

  def isVar: Boolean = true

  def value: Int = v

  def numValue: Int = throw new Error("No NumValue for a Var")

  def leftOp: Expr = throw new Error("No leftOp for a Var")

  def rightOp: Expr = throw new Error("No leftOp for a Var")
}

object Sum {
  def apply(l: Expr, r: Expr) = new Sum(l, r)
}

object Prod {
  def apply(l: Expr, r: Expr) = new Prod(l, r)
}

abstract class Operation(l: Expr, r: Expr) extends Expr {

  def isNumber: Boolean = false

  def isSum: Boolean = false

  def isProd: Boolean = false

  def numValue: Int = throw new Error("No numValue for an Operation")

  def value: Int = throw new Error("No value for an Operation")

  def isVar: Boolean = false

  def leftOp: Expr = l

  def rightOp: Expr = r
}

class Sum(l: Expr, r: Expr) extends Operation(l, r) {

  override def isSum: Boolean = true

}

class Prod(l: Expr, r: Expr) extends Operation(l, r) {

  override def isProd: Boolean = true

}

object TestFullExpressive {

  def eval(e: Expr): Int = {
    if (e.isNumber) e.numValue
    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
    else if (e.isProd) eval(e.leftOp) * eval(e.rightOp)
    else if (e.isVar) e.value
    else throw new Error("Unknown expression")
  }

  def main(args: Array[String]): Unit = {
    println(eval(Sum(Number(1), Number(2))))
    println(eval(Prod(Number(3), Number(2))))
    println(eval(Prod(Var("x", 5), Number(2))))
  }
}
