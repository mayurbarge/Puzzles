package dp.knapsack

object CountOfSubsetsTopDown extends App {
  /*
  input-  array {2,3,5,6,8,10} Sum=10
  Count total number of subsets having sum 10
  O/p 3
   */

  val array = Array[Int](2,3,5,6,8,10)

  val W = 10
  val dp: Array[Array[Int]] = Array.ofDim[Int](array.size+1, W + 1)

  val s = "abbc"
  var map = scala.collection.immutable.Map[Char, Int]()

  map.values.toList
  println(s.toCharArray.groupBy(e => e.charValue()).map(x => (x._1, x._2.length)))


  for(i <- 0 to array.size) {
    for(j <- 0 to W) {
      if(i == 0)
        dp(i)(j) = 0
      if(j == 0)
        dp(i)(j) = 1
    }
  }

  dp.map(r => {
    println()
    r.map(e=> print(e + " "))
  })

  // only thing here array elements are traversed in reverse i.e.
  // W should be 0 1 2 3 4 5 6 7 8 9 10
  // and we check with
  // (10,8,6,5,3,2) is it possible to create W = 10 with first element, if yes then mark
  //        0 1 2 3 4 5 6 7 8 9 10
 //         0 1 0 0 0 0 0 0 0 0 0
  //        Similarly check for 8 6 5 and so on
  //
  //1 to 6
  for(i <- 1 to array.size) {
    for(j <- 1 to W) {
      if(array(i-1) <= j) {
        dp(i)(j) = dp(i-1)(j-array(i-1)) + dp(i-1)(j)
      }
      else dp(i)(j) = dp(i-1)(j)
    }
  }
  println("@@@@@@@@@@")
  dp.map(r => {
    println()
    r.map(e=> print(e + " "))
  })


}
