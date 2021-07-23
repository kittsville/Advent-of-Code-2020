package advent

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day1Spec extends AnyFlatSpec with Matchers {
  "Day1 Part 1" should "multiply two numbers that sum to 2020" in {
    Day1.multiplyTwo2020Entries(Set(2019, 1)) should be(2019)

    Day1.multiplyTwo2020Entries(Set(5, 2019, 1)) should be(2019)

    Day1.multiplyTwo2020Entries(Set(1721, 979, 366, 299, 675, 1456)) should be(
      514579
    )
  }

  "Day1 Part 2" should "multiply two numbers that sum to 2020" in {
    Day1.multiplyThree2020Entries(Set(2017, 2, 1)) should be(4034)

    Day1.multiplyThree2020Entries(
      Set(1721, 979, 366, 299, 675, 1456)
    ) should be(241861950)
  }
}
