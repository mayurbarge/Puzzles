package dp.knapsack

import dp.knapsack.KnapsackTopDown.W

object KnapsackTopDown extends App {
  def printArray(dp : Array[Array[Int]]) = {
    println("------------------------------")
    dp.map(_.mkString(" ")).map(println)
    println("------------------------------")
  }

  val wt = Array[Int](1,3,4,5)
  val values = Array[Int](1,3,5,7)
  var W = 7
  var dp: Array[Array[Int]] = Array.ofDim[Int](wt.size + 1, W+1)
  val N = values.length

  // i = N and j = W
  for(i <-  (1 to N)) {
    for(j <- (1 to W)) {
      if(wt(i-1) <= j) {
        dp(i)(j) = Math.max(
          values(i-1) + dp(i-1)(j - wt(i-1)),
          dp(i-1)(j))
      } else {
        dp(i)(j) = dp(i-1)(j)
      }
    }
    printArray(dp)
  }

}
