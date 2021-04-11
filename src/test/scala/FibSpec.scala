import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class FibSpec extends AnyFunSuite {
  import Fib._

  test("Fibo(5)") {
    fibo(5) shouldBe 5
  }

  test("Rabbit generations count(29)(4)") {
    val in = State(1, 0, 0)
    val res = rabbitIterate(in, 29)( 4)
    rabbitCount(res) shouldBe BigInt("170361678269")
  }

}
