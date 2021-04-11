import scala.collection.mutable.ListBuffer

/* Task: http://rosalind.info/problems/gc/  */
object GcContent {
  def countGC(dna: String) : Double = {
    dna.foldLeft(0) { (acc, c) =>
      c match {
        case 'G' => acc + 1
        case 'C' => acc + 1
        case _ => acc
      }
    }.toDouble * 100 / dna.length.toDouble
  }

  def countGCinDataset(fileName: String): (String, Double) = {
    val it = scala.io.Source.fromFile(fileName).getLines()
    var header = ""
    val current = ListBuffer[String]()
    val pairs = ListBuffer[(String, Double)]()
    while(it.hasNext){
      val line = it.next()
      if (line.contains("Rosalind") && current.length > 0){
        val p = (header,
          countGC(current.mkString("")
            .replace("\n", ""))
        )
        current.clear()
        pairs.append(p)
        header = line
      } else if (line.contains("Rosalind")) {
        header = line
      } else {
        current.append(line)
      }
    }
    val p = (header, countGC(current.mkString("")))
    pairs.append(p)
    pairs.maxBy(_._2)
  }

}
