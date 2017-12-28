package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
object ListMain {

  def main(args: Array[String]): Unit = {
    val l : IntList = new IntCons (2, new IntCons (4, IntNil))
    println("Int List : " + l)

    val ls : List[String] = new Cons("Bonjour", new Cons("Ca va ?", new Cons("Au revoir", Nil)))
    println("Generic List of String : " + ls)

  }
}
