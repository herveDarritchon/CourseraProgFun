package week4.idealized.scala

/**
  * Created by Hervé Darritchon on 31/12/2017.
  *
  */
object MainNat {

  def main(args: Array[String]): Unit = {
    val zero: Nat = Zero
    val un: Nat = new Succ(Zero)

    println("zero : " + zero)
    println("un : " + un)

    val deux: Nat = new Succ(un)
    println("deux : " +deux)

    println("un : " + (deux - un))

    println("trois : " + (un + deux))

    /* throw an error because of negative :)
    println("moins un : " + (un - deux))*/

  }
}
