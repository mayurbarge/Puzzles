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

object Result2  extends  App {

  /*
   * Complete the 'countDuplicate' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY numbers as parameter.
   */
/*
problem: Given an array count numbers that occur more than once
 */

  def countDuplicate(numbers: Array[Int]): Int = {

 //   println(" Numbers " +numbers.toList)
    def same(areSame: Array[Int]): (Boolean, Option[Int]) = {
   //   println("AreSame " + areSame.toList)
      if(areSame(0) == areSame(1))
        (true, Some(areSame(0)))
      else (false, None)
    }
     val list = numbers.combinations(2).map(same).toList.filter(_._1 == true)
    //val (sameList, sameNumbers) = list.unzip
    //println(" -------- " + sameList + " " + sameNumbers)

   /* if(list.fi)
      countDuplicate(sameNumbers.flatten.toArray)
      else sameNumbers.size*/

    list.distinct.size
  }

/*  val numbers = scala.collection.immutable.List(1,3,3,4,4,4)
  println(numbers.sliding(2).toList)
println(countDuplicate(numbers.toArray))*/


}

object Solution2 extends App{

  val numbers = scala.collection.immutable.List(1,3,3,4,4,4)
  println(numbers.combinations(2).toList)

  println(Result2.countDuplicate(numbers.toArray))

}