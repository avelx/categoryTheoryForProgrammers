object kleisli {

  type Writer[A] = (A, String)

  implicit class KleisliOps[A, B](m1: A => Writer[B]){
    def >=> [C](m2: B => Writer[C]): A => Writer[C] = {
      x => {
        val (y, s1) = m1(x)
        val (z, s2) = m2(y)
        (z, s1 + s2)
      }
    }
  }
}