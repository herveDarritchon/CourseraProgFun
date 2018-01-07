package week4.decomposition_object_oriented

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
trait Expr {

  def eval: Int

  def show: String
}

object Number {
  def apply(n: Int) = new Number(n)
}

class Number(n: Int) extends Expr {

  def numValue: Int = n

  def eval: Int = n

  override def show: String = String.valueOf(n)

}

object Var {
  def apply(x: String, v: Int) = new Var(x, v)
}

class Var(x: String, v: Int) extends Expr {

  def eval: Int = v

  override def show: String = x
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

  override def show: String = l.show + " + " + r.show
}

class Prod(l: Expr, r: Expr) extends Operation(l, r) {

  def eval: Int = l.eval * r.eval

  override def show: String = l.show + " * " + r.show

}

object TestObjectOriented {

  def main(args: Array[String]): Unit = {
    val e1 = Sum(Number(1), Number(2))
    println(e1.show + " = " + e1.eval)
    val e2 = Prod(Number(3), Number(2))
    println(e2.show + " = " + e2.eval)
    val e3 = Prod(Var("x", 5), Number(2))
    println(e3.show + " = " + e3.eval)
  }
}