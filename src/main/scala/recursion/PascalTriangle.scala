package recursion

object PascalTriangle extends App {
  def pascalTriangleN(n: Int) = {

    /*
      a[i][j] = a[i-1][j] + a[i-1][j-1]
       C---------
      r1 1 0 0 0
      r2 1 1 0 0
      r3 1 2 1 0
     */
    def pascalTriangle(row: Int, column: Int): Int = {
      if (row < 0 || column < 0)
        return 0
      if (row == 0 || column == 0)
        return 1
      else pascalTriangle(row - 1, column - 1) + pascalTriangle(row - 1, column)
    }

    for (row <- 0 to n) {
      for (col <- 0 to row)
        print(pascalTriangle(col, row) + " ")
      println()
    }
  }

  def triangle(row: Int) = {
    def doT(row: Int, prev: List[Int], list: List[List[Int]]): List[List[Int]] = {
      if (row == 0)
        return list :+ prev

      val next = prev.sliding(2, 1).map(pair => pair.sum).toList

      //println (next mkString " ")
      val newRow = ((0 :: next) :+ 0)
      doT(row - 1, newRow, list :+ newRow)

    }

    doT(row, List(1), List(List(1)))
  }

  println(pascalTriangleN(5))
  println(triangle(5))

}
