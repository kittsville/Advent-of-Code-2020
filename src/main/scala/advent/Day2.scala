package advent

import scala.util.matching.Regex


object Day2 extends App with CodeGolf {
  val input =
    getInput("inputs/day2")

  val part1 = input.map(SledRentalPassword.apply)
    .count(_.isValid)
  val part2 = input.map(TobogganCorpPassword.apply)
    .count(_.isValid)

  println(s"Part 1 answer: $part1")
  println(s"Part 2 answer: $part2")
}

case class SledRentalPassword(letter: Char, min: Int, max: Int, password: String) {
  def isValid: Boolean = {
    val letterCount = password.toCharArray.count(_ == letter)

    min <= letterCount && letterCount <= max
  }
}

object SledRentalPassword {
  def apply(input: String): SledRentalPassword = {
    input match {
      case Password.Matcher(min, max, letter, password) => SledRentalPassword(letter.charAt(0), min.toInt, max.toInt, password)
      case _ => throw new IllegalArgumentException(s"""Invalid formatting of password line: "$input"""")
    }
  }
}

case class TobogganCorpPassword(letter: Char, pos1: Int, pos2: Int, password: Array[Char]) {
  def isValid: Boolean = {
    val existsAtPos1 = password(pos1 - 1) == letter
    val existsAtPos2 = password(pos2 - 1) == letter

    existsAtPos1 != existsAtPos2
  }
}

object TobogganCorpPassword {
  def apply(input: String): TobogganCorpPassword = {
    input match {
      case Password.Matcher(min, max, letter, password) => TobogganCorpPassword(letter.charAt(0), min.toInt, max.toInt, password.toCharArray)
      case _ => throw new IllegalArgumentException(s"""Invalid formatting of password line: "$input"""")
    }
  }
}

object Password {
  val Matcher: Regex = """^(\d+)-(\d+) (\w): (\w+)$""".r
}
