package week5

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
object TestListWeek5 {

  def last[T](xs: List[T]): T = xs match {
    case List() => throw new Error ("No Last from an Empty List")
    case List(x) => x
    case y :: ys => last(ys)
  }

  def main(args: Array[String]): Unit = {
    val ls : List[Int] = List(3,5,2,9,1)
    println(last(ls))
  }
}