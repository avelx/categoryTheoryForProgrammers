object Funcs {
  type A = Int
  type B = String
  type C = Double
  type D = (Double, String)

  val f : A => B = { x : Int =>
    x.toString
  }

  val g : B => C = { x : String =>
    x.toDouble
  }

  val h: C => D = { x : Double =>
    (x, x.toString)
  }

  val z : A => C = g compose f

  // testing associative properties
  val hgf1 = h compose ( g compose f )
  val hgf2 = (h compose g) compose f
  val hgf3 = h compose g compose f

  def identity[A](x: A): A = x
}
