package week4

import week3.{Empty, IntSet, NonEmpty}

/**
  * Created by Hervé Darritchon on 28/12/2017.
  *
  */
trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def nth(idx: Int): T

  def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
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

object List {

  def apply[T]: List[T] = Nil

  def apply[T](elem: T): List[T] = new Cons[T](elem, Nil)

  def apply[T](elem1: T, elem2: T): List[T] = new Cons[T](elem2, new Cons(elem1, Nil))

}

object test {

  def f(xs: List[NonEmpty], x: Empty): List[IntSet] = xs prepend x

  def main(args: Array[String]): Unit = {
    val l: List[NonEmpty] = List(new NonEmpty(1, new Empty(), new Empty()))
    println(f(l, new Empty()))

  }
}