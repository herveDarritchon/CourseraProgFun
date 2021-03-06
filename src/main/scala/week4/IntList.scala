package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
trait IntList {
  def isEmpty: Boolean
  def head: Int
  def tail: IntList
}

object IntNil extends IntList {
  def isEmpty: Boolean = false

  def head : Nothing = throw new NoSuchElementException ("No Head for an Empty List")

  def tail: Nothing = throw new NoSuchElementException ("No Tail for an Empty List")

  override def toString : String = "Nil"
}

class IntCons(val head: Int, val tail: IntList) extends IntList {
  def isEmpty: Boolean = true

  override def toString : String = "{" + head + "," + tail.toString + "}"
}