package advent

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day2Spec extends AnyFlatSpec with Matchers {
  "Password parser" should "parse a valid password input" in {
    Password("1-3 a: abcde") should be(Password('a', 1, 3, "abcde"))
  }

  it should "fail to parse an invalid input" in {
    assertThrows[IllegalArgumentException]{
      Password("1-3 ad: abcde")
    }
  }

  "Password validator" should "identify valid passwords" in {
    Password('a', 0, 0, "").isValid should be(true)
    Password('a', 1, 1, "a").isValid should be(true)
    Password('a', 2, 3, "aaa").isValid should be(true)
  }

  it should "identify invalid passwords" in {
    Password('a', 1, 1, "").isValid should be(false)
    Password('a', 2, 3, "a").isValid should be(false)
    Password('a', 2, 3, "aaaa").isValid should be(false)
  }
}
