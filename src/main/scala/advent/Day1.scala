package advent

object Day1 extends App with CodeGolf {

  def multiply2020Entries(expenseReport: Set[Int]): Int = {
    val firstEntry =
      expenseReport.find(entry => expenseReport.contains(2020 - entry)).get
    val secondEntry = 2020 - firstEntry

    firstEntry * secondEntry
  }

  val total = multiply2020Entries(
    getInput("inputs/day1")
      .map(_.toInt)
      .toSet
  )

  println(total)
}
