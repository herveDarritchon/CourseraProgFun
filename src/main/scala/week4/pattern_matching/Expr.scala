package week4.pattern_matching

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
trait Expr {

  def eval: Int = this match {
    case Number(n) => n
    case Sum(l, r) => l.eval + r.eval
    case Prod(l, r) => l.eval * r.eval
    case Var(x) => x.toInt
  }

  def show: String = this match {
    case Number(n) => String.valueOf(n)
    case Sum(l, r) => l.show + " + " + r.show
    case Prod(l, r) => l.show + " * " +  r.show
    case Var(x) => x
  }

  override def toString: String = this.show + " = " + this.eval

}

case class Number(n: Int) extends Expr

case class Sum(l: Expr, r: Expr) extends Expr

case class Prod(l: Expr, r: Expr) extends Expr

case class Var(x: String) extends Expr

object Test_Pattern_Matching {


  def main(args: Array[String]): Unit = {

    val e1 = Sum(Number(1), Number(2))
    println(e1)
    val e2 = Prod(Number(3), Number(2))
    println(e2)
/*    val e3 = Prod(Var("x"), Number(2))
    println(e3)*/
  }
}