package slidingwindow

object MaxSubarrayOfSizeK extends App {
  /*
  Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
   */
  def maxSubarray(array: Array[Int], k: Int) = {
    var maxSum = 0
    var runningSum = 0
    var windowStart = 0
    for(windowEnd <- 0 until array.length) {
      runningSum += array(windowEnd)
      if(windowEnd >= (k-1)) {
        maxSum = Math.max(runningSum, maxSum)
        runningSum -= array(windowStart)
        windowStart += 1
      }
    }
    maxSum
  }

  println(maxSubarray(Array(2,1,5,1,3,2), 3))

}
