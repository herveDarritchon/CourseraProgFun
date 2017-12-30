package week4.idealized.scala

/**
  * Created by Hervé Darritchon on 31/12/2017.
  *
  */
object MainBoolean {

  def anExpressionTrue: Boolean = True

  def aRandomExpression: Boolean = if (Math.random() < 0.5) True else False

  def anExpressionFalse: Boolean = False

  def main(args: Array[String]): Unit = {
    val b: Boolean = anExpressionTrue
    val b1: Boolean = anExpressionFalse
    val b2: Boolean = aRandomExpression

    println(b == b1)
    println(b != b1)

    println(!b2)
    println(b2)
    println(b2 == b1)

    println(b == b2)
    println(b != b2)

    println(b && b2)
    println(b || b2)


  }
}
