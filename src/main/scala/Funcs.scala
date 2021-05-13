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

  val fact = (n: Int) => (1 to n).product

  //def absurd[A] : Nothing => A

  def unit[A]: A => Unit = _ => ()

  sealed trait Bool
  case object True extends Bool
  case object False extends Bool

  trait Monoid[M] {
    def combine(m1: M, m2: M): M
    def empty: M
  }

  object Monoid {
    implicit val stringMonoid : Monoid[String] = new Monoid[String] {
      override def combine(m1: String, m2: String): String = m1 + m2
      override def empty: String = ""
    }
  }
}
