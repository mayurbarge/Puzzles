object Solution {

  def main(args: Array[String]): Unit = {

    args.toList match {
      case h :: tail => area(h, tail)
      case Nil => ""
    }
  }

  def area(n: String, vertices:  List[String]) = {

    vertices.map(_.toInt)
  }
}
val input = Array[String]("4","0 0", "0 1", "1 1", "1 0")
Solution.main(input)