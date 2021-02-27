package recursion

/*
iven an input string of numbers, find all combinations of numbers that can be formed using digits in the same order.
Examples:

Input : 123
Output :1 2 3
        1 23
        12 3
        123

Input : 1234
Output : 1 2 3 4
        1 2 34
        1 23 4
        1 234
        12 3 4
        12 34
        123 4
        1234

 */
object CombinationsInStringOfDigits extends App {
  def findCombinations1(string: String): List[List[String]] = {
    def go(current: String, running: List[String], result: List[List[String]]): (List[String], List[List[String]] ) = {
//      println(current + " " + running)
      if(current.length == 1) return (running, result :+ (running :+ current))
      val (_, r1) = go(current.drop(1), running :+ current.charAt(0).toString, result)
      (List.empty[String], result  ++ r1 :+ (running :+ current))
    }
    go(string, List.empty[String], List.empty[List[String]])._2
  }

  /*
  Tail recursion trick:
  Tail recursion does not keep stacks unlike normal recursion, hence DFS type of algorithms which need output of previous calls needs to be
  passed along in the result, we have used two stacks, running stack keeps track of the current element,
  as we proceed along we use running stack and copy current iterations data to build output,
  hence for each i'th call we store running counter till i and build state required for i+1'th call
   */

  def findCombinations2(string: String): List[List[String]] = {
    def go(current: String, running: List[String], stack: List[List[String]]): List[List[String]] = {
      println(running + " " + stack)
      if(current.length == 1) {
        return stack :+ running
      }
      val sentinel = current.charAt(0).toString
      if(stack.isEmpty)
        go(current.drop(1), running :+ sentinel, stack :+ List(current))
      else {
        go(current.drop(1), running :+ sentinel, stack :+ (running :+ current))
      }
    }
    go(string, List.empty[String], List.empty[List[String]]).reverse
  }

 // println(findCombinations1("1234"))
  println(findCombinations2("1234"))



}
