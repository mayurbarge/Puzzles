package recursion

/**
 * Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level.
Example :

Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28]
         [8, 12, 16]
         [3, 5, 7, 9]
         [1, 2, 3, 4, 5]

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)

 */
object SumTriangleFromArray extends App {
  def sumTriangle(array: Array[Int]): List[List[Int]] = {

    def go(inputArray: List[Int], sumArray: List[Int], result: List[List[Int]]): List[List[Int]] = {
      if(inputArray.isEmpty && sumArray.isEmpty) return result
      if(inputArray.isEmpty && sumArray.length == 1) return sumArray +: result

      if(inputArray.isEmpty) {
        go(sumArray.sliding(2).map(_.sum).toList, List.empty, sumArray +: result)
      } else {
        go(inputArray.drop(1), sumArray :+ inputArray.head, result)
      }
    }
    go(array.toList, List.empty[Int], List.empty[List[Int]])
  }

  println(sumTriangle(Array(1,2,3,4,5)))

}
