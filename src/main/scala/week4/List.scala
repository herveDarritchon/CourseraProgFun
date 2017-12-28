package week4

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(idx: Int): T
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = false

  def head: Nothing = throw new NoSuchElementException("No Head for an Empty List")

  def tail: Nothing = throw new NoSuchElementException("No Tail for an Empty List")

  def nth(idx: Int): Nothing = throw new IndexOutOfBoundsException("No element inside a Nil List")

  override def toString: String = "Nil"
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty: Boolean = true

  def nth(idx: Int): T =
    if (idx == 0) head
    else this.tail.nth(idx - 1)

  override def toString: String = "{" + head + "," + tail.toString + "}"
}