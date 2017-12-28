package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = false

  def head = throw new Error ("No Head for an Empty List")

  def tail: List[Nothing] = throw new Error ("No Tail for an Empty List")

  override def toString : String = "Nil"
}

class Cons[T]( val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = true

  override def toString : String = "{" + head + "," + tail.toString + "}"
}