import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result1 {
  /*
  Given an integer, if number is prime return 1. Otherwise return its smallest divisor greater than 1.
  e.g. 2 is a  prime => 1
  4 => 2
   */

  def isPrime(n: Long): Int = {
    def recurse(number: Long, next: Long,factors: scala.collection.immutable.List[Long]): Int = {
  //    println("Number : " + number + " next " + next + " factors " + factors)
      if(next == 1)
        return if(factors.isEmpty) 1 else factors.head.toInt

      val nonPrime1: Boolean = (n % next) == 0
      if(nonPrime1) {
        recurse(number, next/2, factors.::(next))
      }
      else recurse(number, next/2, factors)
    }
    recurse(n, n/2, scala.collection.immutable.List.empty[Long])
  }
}

object Solution1 {
  def main(args: Array[String]) {

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toLong

    val result = Result1.isPrime(n)

    printWriter.println(result)

    printWriter.close()
  }
}
