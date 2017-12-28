package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
object ListMain {

  def singleton[T](elem: T) = new Cons[T](elem, Nil)

  def nth[T](idx: Int, xs: List[T]): T =
    if (xs.isEmpty || idx < 0) throw new IndexOutOfBoundsException
    else if (idx == 0) xs.head
    else nth(idx - 1, xs.tail)

  def main(args: Array[String]): Unit = {
    val l: IntList = new IntCons(2, new IntCons(4, IntNil))
    println("Int List : " + l)

    val ls: List[String] = new Cons[String]("Bonjour", new Cons[String]("Ca va ?", new Cons[String]("Au revoir", Nil)))
    println("Generic List of String : " + ls)

    println(nth(2, ls))
    println(nth(-1, ls))

    println(ls.nth(2))
    println(ls.nth(-1))

    val lb: List[Boolean] = singleton(true)
    println("Generic List of Boolean : " + lb)

  }
}
