object Funcs {
  type A = Int
  type B = String
  type C = Double

  val f : A => B = { x : Int =>
    x.toString
  }

  val g : B => C = { x : String =>
    x.toDouble
  }

  val z : A => C = g compose f
}
