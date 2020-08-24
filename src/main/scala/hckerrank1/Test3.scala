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

object Result3 extends  App {

  /*
  A string contains a perfect substring if all the elements of substring occur exactly k times. Calculate number of perfect substrings in s.
  e.g. s = 1102021222 k = 2
  perfect substrings
  11, 110202, 102021, 0202, 22, 22
   * Complete the 'perfectSubstring' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  def perfectSubstring(s: String, k: Int): Int = {

    def same(s: Array[Char], k :Int) = s.distinct.size == k

    def go(words:Array[Char], currentK: Int, count: Int): Int = {
      val c = words.sliding(k).filter(same(_,currentK)).size
      println(c)

      if(currentK < s.size) {
        count + c
      } else {
        go(words, currentK+k,count+c)
      }
    }
    go(s.toCharArray, k, 0)
  }

  val str = "1221221121"
  println(perfectSubstring(str, 3))
}
