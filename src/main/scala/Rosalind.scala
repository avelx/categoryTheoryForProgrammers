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

  // http://rosalind.info/problems/iprb/
  def mendelFirstLaw(k: Int, m: Int, n: Int): Double = {
    val s = k.toDouble + m.toDouble + n.toDouble

    val a : Double = n.toDouble * (n.toDouble -1) /( s *(s -1) )
    val b : Double = 0.5 * m * n/(s * (s -1) )
    val c : Double = 0.25 * m * (m-1)/(s * (s -1) )

    1 - a - 2 * b - c
  }

  //
  def translateRna(rna: String) : List[String] = {
    val fileName = "/Users/pavel/devcore/playground/categoryTheoryForProgrammers/src/main/resources/rnaCodonsToaacids.txt"
    val lines = scala.io.Source.fromFile(fileName).getLines()
    val mapping = lines.toList.map(s => {
      val p = s.trim.split(" ")
      p(0) -> p(1)
    }).toMap

    val res = for {
      triple <- rna.sliding(3, 3)
      x = mapping(triple)
    } yield x
    res.toList
  }

  def occurancesIndex(a: String, b: String): List[Int] = {
    val res = ListBuffer[Int]()
    a.foldLeft( (0, List[Char]() ) ){ (acc, c) =>
      if (acc._2.mkString("") == b){
        res.append(acc._1 + 1)
      }
      if (acc._2.length == b.length){
        (acc._1 + 1, acc._2.tail :+ c)
      } else {
        (acc._1, acc._2 :+ c)
      }
    }
    res.toList
  }

}
