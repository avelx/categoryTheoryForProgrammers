import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers._

class RosalindSpec extends AnyFunSuite {
  import Rosalind._
  test("counte nuceotides in a string") {
    val in = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
    val actual = countNucleotides(in)( Seq('A', 'C', 'G', 'T') )
    actual should be eq  ("A" -> 20, "C" -> 12, "G" -> 17, "T" -> 21)
  }

  test("Transcribing DNA into RNA") {
    val in = "GATGGAACTTGACTACGTAAATT"
    val actual = transcribingToRna(in)
    val expected = "GAUGGAACUUGACUACGUAAAUU"
    actual should be eq expected
  }

}
