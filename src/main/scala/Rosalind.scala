object Rosalind {
  def countNucleotides(in: String)
                      (alphabet: Seq[Char]): Map[String, Int] = {
    val counter : Map[String, Int] = alphabet
      .toList
      .map(c => (c.toString, 0))
      .toMap[String, Int]
    in.foldLeft(counter){ (acc, c) =>
      if (acc.contains(c.toString)){
        acc + (c.toString -> (acc(c.toString) + 1) )
      } else {
        acc + (c.toString -> 1)
      }
    }
  }

  def transcribingToRna(dna:String): String =
    dna.foldLeft( List[Char]()){ (acc, c) =>
      if (c == 'T'){
        acc :+ 'U'
      } else {
        acc :+ c
      }
    }.mkString("")
}
