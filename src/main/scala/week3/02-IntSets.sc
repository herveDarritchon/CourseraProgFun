
val t1: IntSet = new NonEmpty(3, new Empty(), new Empty())
val t2: IntSet = t1.incl(4)
t2.incl(6)
val t3 = new NonEmpty(2, new Empty(), new Empty())

val e1 = new Empty()

e1.union(t2)

t2 union t3
/**
  * Created by Hervé Darritchon on 27/12/2017.
  *
  */

abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  def contains(x: Int): Boolean = false

  override def toString: String = ","

  override def union(other: IntSet) = other
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

  override def union(other: IntSet) =
    left union right union other incl elem
}