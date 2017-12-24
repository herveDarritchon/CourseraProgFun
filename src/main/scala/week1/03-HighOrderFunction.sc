import scala.annotation.tailrec

def sumInts(a: Int, b: Int): Int = {
  if (a > b) 0 else a + sumInts(a + 1, b)
}

sumInts(2, 3)

def cube(x: Int): Int = x * x * x

cube(3)

def sumCubes(a: Int, b: Int): Int = {
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
}

sumCubes(2, 3)

def factorial(n: Int): Int = {

  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)

  loop(1, n)
}

def sumFactorials(a: Int, b: Int): Int = {
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
}
sumFactorials(2, 3)