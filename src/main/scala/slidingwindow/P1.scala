package slidingwindow

object P1 extends App {
  /*
    given k any window size give the maximum sum of subarry from arr
    [4,2,1,7,8,1,2,8,1,0] o/p 16
   */
  def maxSubArry(arr: Array[Int], k: Int) = {
    var maxValue = Integer.MIN_VALUE
    var currentRunningSum = 0
    for (i <- arr.indices) {
      currentRunningSum += arr(i)
      if (i >= (k - 1)) {
        maxValue = Math.max(currentRunningSum, maxValue)
        currentRunningSum -= arr(i - (k - 1))
      }
    }
    maxValue
  }

  /**
   * find smallest subarry size with given sum
   * [4,2,2,7,8,1,2,8,1,0] o/p smallest subarray >= 8
   */
  def smallestSubArry(arr: Array[Int], targetSum: Int) = {
    var minWindowSize = Integer.MAX_VALUE
    var currentWindowSum = 0
    var windowStart = 0
    for (windowEnd <- arr.indices) {
      currentWindowSum += arr(windowEnd)
      while (currentWindowSum >= targetSum) {
        minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1)
        currentWindowSum -= arr(windowStart)
        windowStart += 1
      }
    }
    minWindowSize
  }

  def longestSubstringWithKDistinctChars() = {

  }

  println(maxSubArry(Array(4, 2, 1, 7, 8, 1, 2, 8, 1, 0), 3))
  println(smallestSubArry(Array(4, 2, 2, 7, 8, 1, 2, 8, 1, 0), 8))
}
