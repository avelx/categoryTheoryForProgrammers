object Runner extends App {
  import kleisli._

  val toUpper: String => Writer[String] =
      s => (s.toUpperCase, "upCase")

  val toWords: String => Writer[List[String]] =
      s => (s.split(' ').toList, "toWords")

  val process : String => Writer[List[String]] = {
    toUpper >=> toWords
  }

  val data = List("Words data string", "Count something")
  val res = data
    .map(row => process(row) )

  println(res.map(_._2))
}
