
object Runner extends  App {
  import GcContent._
  val res = countGCinDataset("/Users/pavel/devcore/playground/categoryTheoryForProgrammers/src/test/resources/data/fasta2.txt")
  println(res)
}
