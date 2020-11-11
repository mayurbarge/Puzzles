package interviewQuestions

import java.io.PrintWriter

import scala.io.StdIn

object Lionteq1 {
  case class Cell(i: Int,j: Int)
     def main(args: Array[String]) {
       val nk = StdIn.readLine().split(" ")
       val (n, k) = (nk.head.toInt, nk.last.toInt)
       val cells = (1 to n).flatMap(i=>(1 to n).map(j =>{Cell(i,j)}))
       println(cells)
       (1 to k).foldLeft(scala.collection.mutable.ListBuffer.empty[Cell])((acc,e) =>{
         val in = StdIn.readLine().split(" ")
         val(pi, pj) = (in.head, in.last)
         val r = acc += (Cell(pi.toInt,pj.toInt))
         println(cells.diff(r))
         r
       })
    }
}

object Lionteq2 {
  def main(args: Array[String]) {
    //val nk = StdIn.readLine().split(" ")
    val  input = "4 7 18 16 14".split(" ").map(_.toLong)
    println(Math.pow(2,32).toLong)
  println(input.sorted.reverse.toList)
    def go(input:List[Long]): Unit ={
      val base = Math.pow(2,32).toLong
      val r = input.reduce((a1,a2)=>a1^a2)
      println(base ^ r)

      input match {
        case h :: tail => {
          go(tail)
        }
        case Nil =>
      }
    }
    go(input.sorted.reverse.toList)

  }
}

