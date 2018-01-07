package week5.lists

/**
  * Created by Hervé Darritchon on 07/01/2018.
  *
  */
object TestList {

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case Nil => x :: Nil
    case (y :: ys) =>
      if (x > y) y :: insert(x, ys)
      else x :: xs
    /* Using Pattern matching instead of the if else
    case (y :: ys) => (x > y) match {
      case true => x :: xs
      case false => y :: insert(x, xs.tail)
    }*/
  }

  def isort(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case (y :: ys) => insert(y, isort(ys))
  }

  def main(args: Array[String]): Unit = {
    val ls = isort(List(2, 7, 3, 9))
    println(ls.toString())
  }
}
