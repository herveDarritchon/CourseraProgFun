import scala.annotation.tailrec

def factorial(n: Int): Int = {

  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)

  loop(1, n)
}

factorial(3)
factorial(31)

