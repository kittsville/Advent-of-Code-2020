package advent

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Day3Spec extends AnyFlatSpec with Matchers {
  "Row" should "identify trees on piste" in {
    Row("#").isTree(0) should be(true)
    Row(".").isTree(0) should be(false)

    Row(".#").isTree(3) should be(true)
    Row(".#").isTree(4) should be(false)
  }

  "Route" should "identify how many trees will be hit during the descent" in {
    Route(List()).calculateTreesHit should be(0)

    Route(
      List(
        Row("#")
      )
    ).calculateTreesHit should be(1)

    Route(
      List(
        Row("..##......."),
        Row("#...#...#.."),
        Row(".#....#..#."),
        Row("..#.#...#.#"),
        Row(".#...##..#."),
        Row("..#.##....."),
        Row(".#.#.#....#"),
        Row(".#........#"),
        Row("#.##...#..."),
        Row("#...##....#"),
        Row(".#..#...#.#")
      )
    ).calculateTreesHit should be(7)
  }

}
