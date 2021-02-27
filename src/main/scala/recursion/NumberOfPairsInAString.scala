package recursion

object NumberOfPairsInAString extends App {
  /**
   * A pair is formed when same character is found at both ends in a triplet
   * ie.
   * aba --> 1 a is found at first and third position
   * .a. ---> 1
   * aaa --> 1
   * abab ---> 2
   */
    def findPairs(str: String): Int = {
      def go(list: List[Char] , count:Int): Int = {
        //println(list + " " + count)
        if(list.size <= 2 ) {
          return count
        }
        list match {
          case a :: _ :: b :: _ => {
          //  println(a + " " + b)
            if(a == b) {
              go(list.tail, count+1)
            } else go(list.tail, count)
          }
          case _=> go(list.tail, count)
        }
      }
      go(str.toCharArray.toList, 0)
    }
  println(findPairs("aba"))
  println(findPairs("abab"))
  println(findPairs("aaa"))
  println(findPairs(".a."))


}
