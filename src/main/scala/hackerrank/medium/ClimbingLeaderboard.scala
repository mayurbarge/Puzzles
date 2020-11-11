package hackerrank.medium

import java.io._
import java.math._
import java.security._
import java.text._
import java.util
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.collection.mutable
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._
import collection.JavaConverters._
import collection.mutable._


object ClimbingLeaderboard {

  def findIndex(playerScore: Int, ranks: Array[Int], scores: Array[Int]): Int = {
    lazy val getPosition = {
      val position = java.util.Collections.binarySearch(scores.toList.asJava, playerScore, Collections.reverseOrder[Int]())
      if (position < 0)
        Math.abs(position)
      else position + 1
    }

    println(scores.toList + " " + playerScore + " " + getPosition + " " + ranks.toList)

    if(playerScore > scores(0))
    return 1
    if(playerScore < scores(scores.length-1))
    return ranks(ranks.length-1) + 1
    ranks(getPosition-1)
  }
  def climbingLeaderboard(ranked: Array[Int], player: Array[Int]): Array[Int] = {
    var uniqueRanks: _root_.scala.Array[Int] = getRanks(ranked)
    player.map(findIndex(_,uniqueRanks, ranked))
  }

  private def getRanks(ranked: Array[Int]) = {
    var uniqueRanks = Array.ofDim[Int](ranked.length)
    uniqueRanks(0) = 1

    for (i <- 1 until ranked.length) {
      if (ranked(i - 1) == ranked(i)) {
        uniqueRanks(i) = uniqueRanks(i - 1)
      } else {
        uniqueRanks(i) = uniqueRanks(i - 1) + 1 // prev rank + 1
      }
    }
    uniqueRanks
  }
}

object Solution {
  def main(args: Array[String]) {
   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val rankedCount = StdIn.readLine.trim.toInt

    val ranked = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val playerCount = StdIn.readLine.trim.toInt

    val player = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = ClimbingLeaderboard.climbingLeaderboard(ranked, player)

    println(result.mkString("\n"))

    //printWriter.close()

    /*
    7
    100 100 50 40 40 20 10
    4
    6
    6
    4
    2
    1

    6
    100 90 90 80 75 60
    5
    50 65 77 90 102
    op--- 6 5 4 2 1

     */
  }
}
