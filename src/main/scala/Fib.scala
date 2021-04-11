object Fib {
  def fibo(n: Int): Int = {
    def fiboAcc(k: Int, first: Int, last: Int): Int = k match {
      case 0 => last
      case _ => fiboAcc(k - 1, last, first + last)
    }

    n match {
      case 0 => 0
      case 1 => 1
      case 2 => 1
      case _ => fiboAcc(n - 1, 0, 1)
    }
  }

  case class RabbitPair(age: Int) extends AnyVal
  case class State(age0: BigInt, age1: BigInt, ageAdults: BigInt)

  // http://rosalind.info/problems/fib/
  // returns
  def reproduce(state: State)(k: Int): State = state match {
    case State(age0, age1, adultsNumber) =>
      State(adultsNumber * k + age0, age1, adultsNumber)
  }

  // adds one month time
  def timeMachine(state: State): State = state match {
    case State(age0, age1, ageAdults) =>
      State(0, age0, ageAdults + age1)
  }

  def rabbitIterate(state: State, n: Int)(k: Int): State = n match {
    case month if month > 0 =>
      val generation = reproduce(state)(k)
      val aged = timeMachine(generation)
      rabbitIterate(aged, n - 1)(k)
    case _ => state
  }

  def rabbitCount(state: State) : BigInt =
    state.age0 + state.age1 + state.ageAdults
}
