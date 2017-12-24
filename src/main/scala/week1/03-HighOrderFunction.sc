import scala.annotation.tailrec

def sumInts(a: Int, b: Int): Int = sum(x => x)(a, b)

def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x)(a, b)

sumCubes(2, 3)

def factorial(n: Int): Int = {

  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)


  loop(1, n)
}

def sumFactorials(a: Int, b: Int): Int = sum(factorial)(a, b)

sumFactorials(2, 3)

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sumF(a + 1, b)
  }

  sumF
}

