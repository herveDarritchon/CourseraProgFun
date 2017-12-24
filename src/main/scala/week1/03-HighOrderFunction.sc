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

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f)(a + 1, b)
}

def product(f: Int => Int)(a: Int, b: Int): Int = {
  if (a > b) 1
  else f(a) * product(f)(a + 1, b)
}

product(x => x)(2, 3)
product(x => x * x)(2, 3)

def fact(n: Int): Int = product(x => x)(1, n)

fact(3)