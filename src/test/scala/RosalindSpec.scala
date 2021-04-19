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
    actual shouldBe expected
  }

  test("Reverse complement") {
    val in = "AAAACCCGGT"
    val actual = reverseComplement(in)
    val expected = "ACCGGGTTTT"
    actual shouldBe expected
  }

  test("hammingDistance") {
    val a = "GAGCCTACTAACGGGAT"
    val b = "CATCGTAATGACGGCCT"
    hammingDistance(a, b) shouldBe 7
  }

  test("mendelFirstLaw") {
    assert( mendelFirstLaw(2, 2, 2) == 0.783333333333333 )
  }

  test("transalte RNA") {
    val in = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA"
    val res = translateRna( in )
      .filter(_ != "Stop")
      .mkString("")
    assert(res == "MAMAPRTEINSTRING")
  }

  test("string occurances") {
    val a = "GATATATGCATATACTT"
    val b = "ATAT"
    assert( occurancesIndex(a, b) == List(2, 4, 10) )
  }
}
