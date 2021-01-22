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

object Result1 extends App{
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

  def isPrime2(n:Int): Int = {
    if(n ==1 || n==2) return 1
    def go(start:Int, end : Int, result:Int): Int = {
      if(result==0) return result
      if(n/2 == end) result
      else go(start-1, end+1, n%start)
    }
    go(n/2, 1, 1)
  }

  println(isPrime2(1))
  println(isPrime2(2))
  println(isPrime2(3))
  println(isPrime2(4))
  println(isPrime2(5))
  println(isPrime2(6))
  println(isPrime2(21))
  println(isPrime2(531))
  println(isPrime2(37))

}
