package recursion

import scala.annotation.tailrec
import scala.collection.mutable

object PowerSetOfString extends App {

  /*
  This article is about generating Power set in lexicographical order.

Examples :

Input : abc
Output : a ab abc ac b bc c

   */
  def powerSet(string: String): Array[String] = {
    val N = string.length
    var powerSet = Array[String]()
    def go(input: String, output: String): Array[String] = {
      //println("String - " + input + " Output : " + output + " Pow" + powerSet.toList)
      if(input.isEmpty && output.isEmpty)
        return powerSet
      if(input.isEmpty) {
        powerSet = powerSet :+ output
        return powerSet
      }
      val fixed = input.charAt(0).toString
      go(input.drop(1), output + fixed)
      go(input.drop(1), output)
    }
    go(string, "")
  }


  def lexicographicallyOrderedPowerSet1(string: String): mutable.Stack[String] = {
    val N = string.length
    var lexOrderPoerSet = scala.collection.mutable.Stack[String]()

    def go(input: String, output: String): mutable.Stack[String] = {
      println("String - " + input + " Output : " + output + " LexSet" + lexOrderPoerSet.toList)
      //if(input.isEmpty && output.isEmpty) return lexOrderPoerSet
      if(input.isEmpty) {
        if(!lexOrderPoerSet.contains(output))
          lexOrderPoerSet.push(output)
        return lexOrderPoerSet
      }
      if(output.nonEmpty && !lexOrderPoerSet.contains(output)) {
        lexOrderPoerSet.push(output)
      }

      val fixed = input.charAt(0).toString
      go(input.drop(1), output + fixed)
      go(input.drop(1), output)
    }
    go(string, "")
  }



  /*
      sentinel
  abcd "" [a - sen]
  bcd a [a, head + b]
  cd  a [ a, head + b, head + c]
  d   a [a, ab, abc, abcd] []

  bcd "" []
  cd  b []
  d  ""
  "" d
   */

  def lexicographicallyOrderedPowerSet2(string: String): List[String] = {
    val N = string.length
    //var lexOrderPoerSet = scala.collection.mutable.Stack[String]()

    @tailrec
    def go(original:String, input: String, sentinel: String, stack: List[String]): List[String] = {
      println("input " + input + " " + stack + " -- " + sentinel)
      if(original.isEmpty) return stack

      if(input.isEmpty) {
        go(original.drop(1), original.drop(1), "",stack)
      } else {
        if (sentinel.isEmpty)
          go(original, input.drop(1), input.charAt(0).toString, stack :+ input.charAt(0).toString)
        else
          go(original, input.drop(1), sentinel, stack :+ (stack.last + input.charAt(0).toString))
      }
    }
    go(string, string, "", List.empty[String])
  }

  //println(powerSet("abc").toList)
  println(lexicographicallyOrderedPowerSet2("abcd"))

}
