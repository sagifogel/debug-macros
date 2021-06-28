package macros
import print._

class GenTest {
  def apply(param: Any): Unit = macro genLens2_impl
}

object GenTest {
  def apply: GenTest = new GenTest
}
