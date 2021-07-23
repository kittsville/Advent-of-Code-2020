package advent

import scala.annotation.tailrec

object Day3 extends App with CodeGolf {
  val input =
    Route(getInput("inputs/day3").map(Row))

  val part1 = input.calculateTreesHit

  println(part1)
}

case class Route(slope: List[Row]) {
  def calculateTreesHit: Int = {
    slope.zipWithIndex.map {
      case (row, index) if row.isTree(index * 3) => 1
      case _                                     => 0
    }.sum
  }
}

case class Row(value: String) {
  private val trees = value.toCharArray.map(_ == '#')

  def isTree(position: Int): Boolean =
    trees(position % trees.length)
}
