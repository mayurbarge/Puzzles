package fastslow

object Array01 extends App {
  /*Given an array with n integers, check if it could become non-decreasing by removing at most 1 element.
    Example:
    Input: [3,2,4,3], Output: false Input:[1, 4, 2, 3], Output: true Input:[4, 3, 2], Output: false Input:[1, 2, 3], Output: true
   */
  def nonDecreasingArray(array: Array[Int]): Boolean = {
    (array lazyZip array.drop(1)).filter((a, b) => a > b).size <= 1 //fails for 3,4,2,3
  }

  /*
    Determine whether a circular array with magic indexes contains a full circle. The array is circular in the sense that,
    the entry A[i] points to entry A[A[i]]. Full circle means it covers all the elements of the array. As a follow-up,
     I was asked to solve the problem in O(1) space.
     Example: Input: [2,3,1,4,0], Output: true Input: [2,3,2,4,9], Output: false
   */
  def circularArray(array: Array[Int]): Boolean = {
    // if array is circular, after n steps you will get the same number back

    def check(array: Array[Int], start: Int): Boolean = {
      if (start < 0 || start >= array.length) return false
      var pointer = array(start)
      for (i <- 0 to array.size - 1) {
        if (pointer < 0 || pointer >= array.size) return false
        if (start == pointer && i == array.size - 1) return true
        else pointer = array(pointer)
      }
      false
    }

    array.map(e => {
      val start = e
      println(e + " " + check(array, start))
      check(array, start)
    }).reduce(_ && _)

  }

  //println(nonDecreasingArray(Array(3,4,2,3)))
  println(circularArray(Array(2, 3, 1, 4, 0)))
  println(circularArray(Array(2, 3, 2, 4, 9)))
}
