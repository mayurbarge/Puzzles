package twopointers

object TwoPointersP01 extends App {
  /*
  Given a sorted array of ints, return two indexes where the of the sum values is equal to n.

input:
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
n = 7

output:
[0,5]
   */

  def twoPointers(array: Array[Int], sum: Int): Array[(Int,Int)] = {
    var p = 0
    var q = array.size-1
    while (array(p) != array(q)) {
      if(array(p)+array(q) > sum) {
        q -= 1
      }
      if(array(p)+array(q) < sum) {
        p +=1
      }
      if(array(p)+array(q) == sum)
        return Array((p,q))
    }
    Array.empty
  }

  def twoPointersWithAllParis(array: Array[Int], sum: Int): Array[(Int,Int)] = {
    var p = 0
    var q = array.size-1
    var result = Array.empty[(Int,Int)]

    while (p < q) {
      if(array(p)+array(q) > sum) {
        q -= 1
      }
      if(array(p)+array(q) < sum) {
        p +=1
      }
      if(array(p)+array(q) == sum)
      {
        result = (p,q) +: result
        q -= 1
        p +=1
      }
    }
    result
  }

  println(twoPointers(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 7).toList)
  println(twoPointersWithAllParis(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 7).toList)
}
