
object Runner extends  App {
  import Fib._
  val in = State(1, 0, 0)
  val res = rabbitIterate(in, 29)( 4)
  //val res = rabbitIterate(in, 5)(3)
  println( rabbitCount(res) )

}
