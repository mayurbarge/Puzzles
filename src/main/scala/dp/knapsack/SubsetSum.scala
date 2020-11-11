package dp.knapsack

import dp.knapsack.KnapsackTopDown.{dp, wt}

object SubsetSum extends App {
  val MAX = 11
  val arr = Array[Int](2,3,7,8,10)
  val N = arr.length
  var dp: Array[Array[Boolean]] = Array.ofDim[Boolean](N+1, MAX+1)


  def printArray(dp : Array[Array[Boolean]]) = {
    println("------------------------------")
    dp.map(_.mkString(" ")).map(println)
    println("------------------------------")
  }

  for(i <- 0 to N) {
    for(j <- 0 to MAX) {
      if(j == 0)
        dp(i)(j) = true
      else
        dp(i)(j) = false
    }
  }

  println("Initialization")
  printArray(dp)

/*
  for(i <- 1 to N) {
    for(j <- 1 to MAX) {
      printArray(dp)
      println("MAX " + MAX + " N " + N +  "      " +i + "  " + j + " " + arr.toList)
      if(arr(i-1) <= j) {
        println("****** (i-1) " + (i-1) + " j : " + j + " arr(j-1): " + arr(j-1) )
        dp(i)(j) = dp(i-1)(j-arr(j-1)) || dp(i-1)(j)
        //dp(i-1)(j - wt(i-1))
      } else {
        dp(i)(j) = dp(i-1)(j)
      }
    }
  }*/

  for(i <-  (1 to N)) {
    for (j <- (1 to MAX)) {
      //dp(i - 1)(j - arr(i - 1)) here j - arr(*** i **  -1) is imp
      if (arr(i - 1) <= j) {
        dp(i)(j) = dp(i - 1)(j - arr(i - 1)) || dp(i - 1)(j)
      } else {
        dp(i)(j) = dp(i - 1)(j)
      }
      printArray(dp)
    }
  }

  println(dp(N)(MAX))
  println(arr.toList)

}
