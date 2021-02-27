package dp.knapsack

object RobAnyHouse extends App {

  def knapsack(array:Array[Int]): Int = {
    val N = 5
    val W = 10
    val dp = Array.ofDim[Int](N + 1, W + 1)


    /*
 array: values/treasure
 3 4 1 5 5

  0 1 2 3 4 5 6 7 8 9 10
  1   0          0
*/
    for (i <- 1 to N) {
      for (j <- 1 to W) {
        println("\n-----------------")
        dp.map(r=>{
          println()
          r.map(e=>print(e + " "))
        })
        if (i == 0 || j == 0) return 0

        if (array(i - 1) <= j) { //can be selected
          dp(i)(j) = Math.max(
            array(i - 1) + dp(i - 1)(j - array(i - 1))
            , dp(i - 1)(j)
          )
        } else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    dp(N)(W)
  }

  println(knapsack(Array(3, 4, 1, 5, 5)))
}
