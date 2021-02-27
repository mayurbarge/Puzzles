package maxspan

/**
 * Given an array with repeated elements, the task is to find the maximum distance two occurrences of an element.
 * Examples: Input : arr [] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2} Output: 10
 * // maximum distance for 2 is 11-1 = 10 // maximum distance for 1 is 4-2 = 2 // maximum distance for 4 is 10-5 = 5.
 */
object FindMaximumSpan extends App {
  def maxSpan(array: Array[Int]):Int = {
    val frequencies = scala.collection.mutable.Map[Int,Int]()
    var maxSpan = 0
    for(i <- 0 until array.length) {
      if(frequencies.contains(array(i))) {
        maxSpan = Math.max((i+1) - frequencies.getOrElse(array(i) , 0), maxSpan) //+1 as array indices are zero based
      } else {
        frequencies += (array(i) -> i)
      }
    }
    maxSpan
  }

  def recursiveMaxSpan(array: Array[Int]):Int = {
    val frequencies = scala.collection.mutable.Map[Int,Int]()

    def go(subarray: List[Int], max: Int, counter: Int): Int = {
      subarray match {
        case h :: t => {
          if(frequencies.contains(h)) {
            go(t, Math.max(max, counter - frequencies.getOrElse(h,0) + 1), counter+1)
          } else {
            frequencies += (h -> counter)
            go(t, max, counter+1)
          }
        }
        case Nil => max
      }
    }
    go(array.toList, 0, 0)
  }

  println(maxSpan(Array(1,2,2,2,2,1)))
  println(recursiveMaxSpan(Array(1,2,2,2,2,1)))
}
