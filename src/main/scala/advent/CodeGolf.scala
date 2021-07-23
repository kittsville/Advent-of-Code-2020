package advent

trait CodeGolf {
  def getInput(path: String): List[String] = {
    val source = scala.io.Source.fromFile(path)
    val input = source.getLines.toList.filter(_.nonEmpty)
    source.close()
    input
  }
}
