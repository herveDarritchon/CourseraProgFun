package week4.idealized.scala

/**
  * Created by Hervé Darritchon on 31/12/2017.
  *
  */
abstract class Boolean {

  def ifThenElse[T](t: T, e: T): T

  def &&(x: Boolean): Boolean = ifThenElse(x, False)

  def ||(x: Boolean): Boolean = ifThenElse(True, x)

  def unary_! : Boolean = ifThenElse(False, True)

  def ==(x: Boolean): Boolean = ifThenElse(x, !x)

  def !=(x: Boolean): Boolean = ifThenElse(!x, x)

  override def toString: String
}

object True extends Boolean {
  override def ifThenElse[T](t: T, e: T): T = t

  override def toString: String = "true"

}

object False extends Boolean {
  override def ifThenElse[T](t: T, e: T): T = e

  override def toString: String = "false"

}