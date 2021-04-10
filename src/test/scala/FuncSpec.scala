import org.scalacheck.{Properties}
import org.scalacheck.Prop.forAll

object FuncSpec extends Properties("Funcs") {

  import Funcs._

  property("function f(x)") = forAll { x: Int =>
    f(x) == x.toString
  }

  property("function g(s)") = forAll { s: Double =>
    g(s.toString) == s
  }

  property("function z(x)") = forAll { x: Int =>
    z(x) == x.toDouble
  }

}
