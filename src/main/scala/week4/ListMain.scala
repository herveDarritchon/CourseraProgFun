package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
object ListMain {

  def main(args: Array[String]): Unit = {
    val l : IntList = new Cons (2, new Cons (4, Nil))
    println("Int List : " + l)


  }
}
