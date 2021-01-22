package slidingwindow

object MaximumSum extends App {
  /*
  // This is not DP as we only need to find sum in the output
  if we want to find subset of the array having sum 6 then its DP


  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
  Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [0]
Output: 0
Example 4:

Input: nums = [-1]
Output: -1

   */

  def maxSubArray(nums: Array[Int]): Int = {
    val x: (Array[Int], Int) = {
    nums.foldLeft((Array.empty[Int], 0))((acc,e) => {
      println(acc._1.toList + " " + e)
      if(acc._1.nonEmpty) {
        println(" Compare: " + (acc._1.sum + e) + " with " + acc._1.sum)
        if(acc._1.sum + e <= acc._1.sum ) {
          ( acc._1.drop(1) :+ e, acc._2 + 1)
        } else {
          ( acc._1 :+ e, acc._2 + 1)
        }
      } else {
        (e +: acc._1, 1)
      }
    })
    }

    // Kadane's algorithm
    def approach3(nums:  Array[Int]) = {
      var ans = nums(0)
      var subarr_sum = nums(0)

      for (i <- (1 to nums.size-1)) {
        subarr_sum = Math.max(nums(i), nums(i) + subarr_sum)
        ans = Math.max(ans, subarr_sum)
      }
       ans
    }
       println(x._2)
    println(x._1.toList)

    println(approach3(nums))

    0

  }

  println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))

}
