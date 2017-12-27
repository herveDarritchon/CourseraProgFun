val fooBar = new Sub()

fooBar.foo
fooBar.bar

val barFoo = new OtherSub()

barFoo.foo
barFoo.bar

val foofoo: Base = new Sub()

foofoo.foo
foofoo.bar
foofoo.newFunc

abstract class Base {
  def foo = 1

  def bar: Int

  def newFunc : Int = 5
}

class Sub extends Base {
  override def foo = 2

  def bar: Int = 3
}

class OtherSub extends Base {
  override def foo = 4

  def bar: Int = 3
}
