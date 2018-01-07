package week3
/**
  * Created by Hervé Darritchon on 27/12/2017.
  *
  */

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union[S <: IntSet](other: S): IntSet

  /**
    * Assert that all elements of the inset are positives
    *
    * @return
    */
  def assertAllPost(): IntSet
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet =
    if (x > elem) new NonEmpty(elem, left, right.incl(x))
    else if (x < elem) new NonEmpty(elem, left.incl(x), right)
    else this

  def contains(x: Int): Boolean =
    if (x > elem) right.contains(x)
    else if (x < elem) left.contains(x)
    else true

  override def toString: String = "{" + left + elem + right + "}"

  override def union[S <: IntSet](other: S) =
    left union right union other incl elem

  /**
    * Assert that all elements of the inset are positives
    *
    * @return
    */
  override def assertAllPost() =
    if (elem >= 0) new NonEmpty(elem, left.assertAllPost(), right.assertAllPost())
    else throw new Error("All elements are not positives !")
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty(), new Empty())

  def contains(x: Int): Boolean = false

  override def toString: String = ","

  override def union[S <: IntSet](other: S) = other

  /**
    * Assert that all elements of the inset are positives
    *
    * @return
    */
  override def assertAllPost() = this
}

object test {

  def main(args: Array[String]): Unit = {
    val t1: IntSet = new NonEmpty(3, new Empty(), new Empty())
    val t2: IntSet = t1.incl(4)
    t2.incl(6)
    val t3 = new NonEmpty(2, new Empty(), new Empty())

    val e1 = new Empty()

    e1.union(t2)

    val t4 = t2 union t3

    t4.assertAllPost()

    t2.incl(-2).union(t3).assertAllPost()
  }

  // Array non convariance in Scala
  /*val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
  val b: Array[IntSet] = a
  b(0) = Empty
  val s: NonEmpty = a(0)*/

}