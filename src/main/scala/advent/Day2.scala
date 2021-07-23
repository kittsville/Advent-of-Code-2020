package advent

import scala.util.matching.Regex


object Day2 extends App with CodeGolf {
  val total =
    getInput("inputs/day2")
      .map(Password.apply)
      .count(_.isValid)

  println(total)
}

case class Password(letter: Char, min: Int, max: Int, password: String) {
  def isValid: Boolean = {
    val letterCount = password.toCharArray.count(_ == letter)

    min <= letterCount && letterCount <= max
  }
}

object Password {
  val PasswordMatcher: Regex = """^(\d+)-(\d+) (\w): (\w+)$""".r

  def apply(input: String): Password = {
    input match {
      case PasswordMatcher(min, max, letter, password) => Password(letter.charAt(0), min.toInt, max.toInt, password)
      case _ => throw new IllegalArgumentException(s"""Invalid formatting of password line: "$input"""")
    }
  }
}
