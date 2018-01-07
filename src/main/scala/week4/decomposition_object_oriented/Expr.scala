package week4.decomposition_object_oriented

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
trait Expr {

  def eval: Int
}

object Number {
  def apply(n: Int) = new Number(n)
}

class Number(n: Int) extends Expr {

  def numValue: Int = n

  def eval: Int = n

}

object Var {
  def apply(x: String, v: Int) = new Var(x, v)
}

class Var(x: String, v: Int) extends Expr {

  def value: Int = v

  def eval: Int = v

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

  def eval: Int = l.eval + r.eval

}

class Prod(l: Expr, r: Expr) extends Operation(l, r) {

  def eval: Int = l.eval * r.eval

}

object TestObjectOriented {

  def main(args: Array[String]): Unit = {
    println(Sum(Number(1), Number(2)).eval)
    println(Prod(Number(3), Number(2)).eval)
    println(Prod(Var("x", 5), Number(2)).eval)
  }
}