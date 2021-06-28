package macros

import scala.reflect.macros.blackbox

object print {
  def genLens2_impl(c: blackbox.Context)(param: c.Expr[Any]): c.Expr[Unit] = {
    import c.universe._

    val paramRep = show(param.tree) // hello
    val paramRepTree = Literal(Constant(paramRep))
    val paramRepExpr = c.Expr[String](paramRepTree)
    reify(println(paramRepExpr.splice + " = " + param.splice))
  }
}
