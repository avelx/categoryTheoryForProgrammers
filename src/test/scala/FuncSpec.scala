import org.scalacheck.{Properties}
import org.scalacheck.Prop.forAll

object FuncSpec extends Properties("Funcs") {

  import Funcs._

  property("function f(x)") = forAll { x: Int =>
    f(x) == x.toString
  }

}
