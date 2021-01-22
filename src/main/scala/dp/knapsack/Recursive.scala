package dp.knapsack

object RecursiveKnapsack extends App{
  def knapsackNonOptimized(array:Array[Int], i: Int, capacity : Int, remaining: Int): Int = {

    if(i == array.size) return capacity
    if(remaining < array(i) ) {
      knapsackNonOptimized(array, i+1, capacity, remaining )
    }
    else {
      Math.max(	knapsackNonOptimized(array, i+1, capacity, remaining - array(i)),remaining - array(i))
    }
  }

  def knapsack(array: Array[Int], capacity: Int, N: Int):Int = {
    if(capacity == 0 || N == 0)
    return  0
    //println(N + " " +capacity + " "  + array(N-1))
    if(array(N-1) < capacity)
      Math.max(
        array(N-1) + knapsack(array, capacity-array(N-1), N-1), // include N-1 th number
        knapsack(array, capacity, N-1)    // exclude and recurse into left sub-array
      )
      else
      knapsack(array, capacity, N-1) // recurse into left sub-array
  }

  println(knapsackNonOptimized(Array(1,3,4,5), 0, 7, 7))
  println(knapsack(Array(1,3,4,5), 7, 4))
}
