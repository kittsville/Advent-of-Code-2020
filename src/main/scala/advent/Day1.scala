package advent

object Day1 extends App with CodeGolf {

  private def maybePair(entries: Set[Int], total: Int): Option[(Int, Int)] = {
    val maybeEntry = entries.find(entry => entries.contains(total - entry))

    maybeEntry.map(firstEntry => (firstEntry, total - firstEntry))
  }

  // Can't handle an input of List(1010, 1010)
  // but it's not an edge case worth coding for
  def multiplyTwo2020Entries(expenseReport: Set[Int]): Int = {
    val (firstEntry, secondEntry) = maybePair(expenseReport, 2020).get

    firstEntry * secondEntry
  }

  def multiplyThree2020Entries(expenseReport: Set[Int]): Int = {
    val firstEntry = expenseReport.find(entry => maybePair(expenseReport, 2020 - entry).isDefined).get

    val (secondEntry, thirdEntry) = maybePair(expenseReport, 2020 - firstEntry).get

    firstEntry * secondEntry * thirdEntry
  }

  val total = multiplyThree2020Entries(
    getInput("inputs/day1")
      .map(_.toInt)
      .toSet
  )

  println(total)
}
