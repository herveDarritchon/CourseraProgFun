import scala.annotation.tailrec

def id(x: Int): Int = x

def sumInts(a: Int, b: Int): Int = sum(id, a, b)

def cube(x: Int): Int = x * x * x

cube(3)

def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)

sumCubes(2, 3)

def factorial(n: Int): Int = {

  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)


  loop(1, n)
}

def sumFactorials(a: Int, b: Int): Int = sum(factorial, a, b)

sumFactorials(2, 3)

def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b)

