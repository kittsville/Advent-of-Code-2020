package advent

import scala.annotation.tailrec

object Day3 extends App with CodeGolf {
  val input =
    Route(getInput("inputs/day3").map(Row))

  val part1 = input.calculateTreesHit

  println(part1)
}

case class Route(slope: List[Row], xPos: Int = 0, treesPreviouslyHit: Int = 0) {
  @tailrec
  final def calculateTreesHit: Int = {
    slope match {
      case head :: tail =>
        Route(
          tail,
          xPos + 3,
          if (head.isTree(xPos)) treesPreviouslyHit + 1 else treesPreviouslyHit
        ).calculateTreesHit
      case Nil => treesPreviouslyHit
    }
  }
}

case class Row(value: String) {
  private val trees = value.toCharArray.map(_ == '#')

  def isTree(position: Int): Boolean =
    trees(position % trees.length)
}
