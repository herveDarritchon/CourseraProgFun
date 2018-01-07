package week4.decomposition_type_tests

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
trait Expr {
}

object Number {
  def apply(n: Int) = new Number(n)
}

class Number(n: Int) extends Expr {

  def numValue: Int = n

}

object Var {
  def apply(x: String, v: Int) = new Var(x, v)
}

class Var(x: String, v: Int) extends Expr {

  def value: Int = v

}

object Sum {
  def apply(l: Expr, r: Expr) = new Sum(l, r)
}

object Prod {
  def apply(l: Expr, r: Expr) = new Prod(l, r)
}

abstract class Operation(l: Expr, r: Expr) extends Expr {

  def leftOp: Expr = l

  def rightOp: Expr = r
}

class Sum(l: Expr, r: Expr) extends Operation(l, r) {
}

class Prod(l: Expr, r: Expr) extends Operation(l, r) {
}

object Test {

  def eval(e: Expr): Int = {
    if (e.isInstanceOf[Number]) e.asInstanceOf[Number].numValue
    else if (e.isInstanceOf[Sum]) eval(e.asInstanceOf[Operation].leftOp) + eval(e.asInstanceOf[Operation].rightOp)
    else if (e.isInstanceOf[Prod]) eval(e.asInstanceOf[Operation].leftOp) * eval(e.asInstanceOf[Operation].rightOp)
    else if (e.isInstanceOf[Var]) e.asInstanceOf[Var].value
    else throw new Error("Unknown expression")
  }

  def main(args: Array[String]): Unit = {
    println(eval(Sum(Number(1), Number(2))))
    println(eval(Prod(Number(3), Number(2))))
    println(eval(Prod(Var("x", 5), Number(2))))
  }
}