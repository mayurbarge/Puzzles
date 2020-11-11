package dp.knapsack

import dp.knapsack.TailRecursive.profitMade

/*
w is the capacity of the knapsack, wt is weight of item, value is price of item
Steal as many items that knapsack can hold maximizing your profit
 */
object TailRecursive extends App {
  val wt = Array[Int](1,3,4,5)
  val values = Array[Int](1,3,5,7)
  val w = 7

  def go(capacityRemaining: Int, weightsAndValues: Array[(Int, Int)], profit: Int): Int = {
    weightsAndValues.toList match {
      case Nil => profit
      case head :: tail => {
        val (weight, value) = head
        if(capacityRemaining >= weight)
          Math.max(
            go(capacityRemaining-weight, tail.toArray, profit + value),
            go(capacityRemaining, tail.toArray, profit))
        else go(capacityRemaining, tail.toArray, profit)
      }
    }

  }
  val profitMade = go(w, wt zip values, 0)

  println(profitMade)
}

object Recursive extends App {
  val wt = Array[Int](1,3,4,5)
  val values = Array[Int](1,3,5,7)
  val w = 7

  def go(weight: Array[Int], values: Array[Int], capacity: Int, n: Int): Int = {
    if(w == 0 || n == 0)
      return 0

    if(weight(n-1) <= capacity)
      Math.max(
        values(n-1) + go(weight, values, capacity - weight(n-1), n-1),
        go(weight, values, capacity, n-1))
    else go(weight, values, capacity, n-1)
  }
  val profitMade = go(wt, values, w, wt.size)
  println(profitMade)
}
