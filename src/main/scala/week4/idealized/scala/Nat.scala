package week4.idealized.scala

/**
  * Created by Hervé Darritchon on 31/12/2017.
  *
  */
abstract class Nat {

  def isZero: scala.Boolean

  def predecessor: Nat

  def successor: Nat

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: scala.Boolean = true

  override def predecessor: Nat = throw new NoSuchElementException("Natural are only positive")

  override def successor: Nat = new Succ(Zero)

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat =
    if (that.isZero) this
    else throw new NoSuchElementException("Natural are only positive")

  override def toString: String = "zero"
}

class Succ(n: Nat) extends Nat {
  override def isZero: scala.Boolean = false

  override def predecessor: Nat = n

  override def successor: Nat = new Succ(this)

  override def +(that: Nat): Nat = new Succ(n + that)

  override def -(that: Nat): Nat =
    if (that.isZero) this
    else n - that.predecessor

  override def toString: String = "nat," + predecessor.toString
}