import scala.collection.mutable.ListBuffer

object Rosalind {
  def countNucleotides(in: String)
                      (alphabet: Seq[Char]): Map[String, Int] = {
    val counter: Map[String, Int] = alphabet
      .toList
      .map(c => (c.toString, 0))
      .toMap[String, Int]
    in.foldLeft(counter) { (acc, c) =>
      if (acc.contains(c.toString)) {
        acc + (c.toString -> (acc(c.toString) + 1))
      } else {
        acc + (c.toString -> 1)
      }
    }
  }

  def transcribingToRna(dna: String): String =
    dna.foldLeft(List[Char]()) { (acc, c) =>
      if (c == 'T') {
        acc :+ 'U'
      } else {
        acc :+ c
      }
    }.mkString("")

  def reverseComplement(dna: String): String = {
    val mapping: Map[Char, Char] = Map(
      'T' -> 'A',
      'A' -> 'T',
      'C' -> 'G',
      'G' -> 'C'
    )
    dna
      .reverse
      .foldLeft(List[Char]()) { (acc, c) =>
        if (mapping.contains(c)) {
          acc :+ mapping(c)
        } else {
          acc :+ c
        }
      }.mkString("")
  }

  // Problem: http://rosalind.info/problems/hamm/
  def hammingDistance(a: String, b: String): Int = {
    var count = 0
    for {
      i <- 0 to a.length - 1
      if a(i) != b(i)
    } yield count += 1
    count
  }


}
