new week3.Rational(1, 2)

object Fake {

  def error(msg: String): Int =
    throw new Error(msg)
}

def myError(msg: String) =
  throw new Error(msg)

def myException(msg: String) =
  throw new Exception(msg)

def myDifferentError(msg: String) =
  if (msg.isEmpty)
    "Empty !!!"
  else
    throw new Error(msg)

val x = null
val str : String = x
val set : Set[String] = null

Fake.error("what fuked up !!")
