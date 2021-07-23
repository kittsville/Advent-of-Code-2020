package advent

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day2Spec extends AnyFlatSpec with Matchers {
  "Password parser" should "parse a valid password input" in {
    SledRentalPassword("1-3 a: abcde") should be(SledRentalPassword('a', 1, 3, "abcde"))
  }

  it should "fail to parse an invalid input" in {
    assertThrows[IllegalArgumentException]{
      SledRentalPassword("1-3 ad: abcde")
    }
  }

  "SledRentalPassword validator" should "identify valid passwords" in {
    SledRentalPassword('a', 0, 0, "").isValid should be(true)
    SledRentalPassword('a', 1, 1, "a").isValid should be(true)
    SledRentalPassword('a', 2, 3, "aaa").isValid should be(true)
  }

  it should "identify invalid passwords" in {
    SledRentalPassword('a', 1, 1, "").isValid should be(false)
    SledRentalPassword('a', 2, 3, "a").isValid should be(false)
    SledRentalPassword('a', 2, 3, "aaaa").isValid should be(false)
  }

  "TobogganCorpPassword" should "identify valid passwords" in {
    TobogganCorpPassword('a', 1, 2, "ab".toCharArray).isValid should be(true)
    TobogganCorpPassword('a', 1, 3, "bba".toCharArray).isValid should be(true)
    TobogganCorpPassword('a', 2, 3, "bab".toCharArray).isValid should be(true)
  }
}
