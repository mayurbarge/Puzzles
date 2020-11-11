package dp.knapsack

object RecursiveMemoized extends App {
  val wt = Array[Int](1,3,4,5)
  val values = Array[Int](1,3,5,7)
  val W = 7

  var dp: Array[Array[Int]] = Array.ofDim[Int](wt.size + 1, W+1)

  /*
    N,W -> As N increases Size-N decreases, as W increases capacity reduces
    When N,W is max its where 0th index of wt and values is reached and weight is zero,
    hence Max(N,W) gives the desired result,
    At each N th row the values at wth index gives remaining weight at that index
   */
  def printArray(dp : Array[Array[Int]]) = {
    println("------------------------------")
    dp.map(_.mkString(" ")).map(println)
    println("------------------------------")
  }


  def go(weight: Array[Int], values: Array[Int], w: Int, n: Int): Int = {
    if(w == 0 || n == 0)
      return 0

    if(dp(n)(w) != 0)
      return dp(n)(w)

    if(weight(n-1) <= w) {
      dp(n)(w) = Math.max(
        values(n - 1) + go(weight, values, w - weight(n - 1), n - 1),
        go(weight, values, w, n - 1))
      printArray(dp)
      dp(n)(w)
    } else {
      dp(n)(w) = go(weight, values, w, n-1)
      printArray(dp)
      dp(n)(w)
    }
  }
  val profitMade = go(wt, values, W, wt.size)
  println(profitMade)

}
