package slidingwindow

object FruitsInBasket extends App {
  /**
   * In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?
   Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
   3332211133
   */

  def totalFruit[T](tree: Array[T], init: T): Int = {
    var max, current_max = 0
    var last_fruit_count = 0
    var last_tree, second_last_tree = init

    for(i <- 0 to tree.size -1) {
      // these three steps r independent
      // update max
      if(tree(i) == last_tree || tree(i) == second_last_tree) {
        current_max += 1
      } else {
        current_max = last_fruit_count + 1
      }

      // update last  tree counts
      if(tree(i)==last_tree) {
        last_fruit_count += 1
      } else {
        //new fruit
        last_fruit_count = 1
      }
      // update trees
      if(tree(i) != last_tree) {
        second_last_tree = last_tree
        last_tree = tree(i)
      }

      max = Math.max(max, current_max)
    }
    max
  }

  println(totalFruit[Int](Array(1,2,1), -1))
  println(totalFruit[Char](Array('A','B','C','B','B','C'), 'L'))

}
