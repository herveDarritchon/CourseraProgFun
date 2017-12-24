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

def sum(f: Int => Int)(a: Int, b: Int): Int =
  compute(f, (x, y) => x + y, 0)(a, b)

sum(x => x)(2, 3)

def product(f: Int => Int)(a: Int, b: Int): Int =
  compute(f, (x, y) => x * y, 1)(a, b)

product(x => x)(2, 3)
product(x => x * x)(2, 3)

def fact(n: Int): Int = product(x => x)(1, n)

fact(3)

def compute(f: Int => Int, combine: (Int, Int) => Int, initValue: Int)(a: Int, b: Int): Int = {
  if (a > b) initValue
  else combine(f(a), compute(f, combine, initValue)(a + 1, b))
}

compute(x => x * x, (a, b) => a + b, 0)(2, 3)
compute(x => x, (a, b) => a * b, 1)(2, 3)