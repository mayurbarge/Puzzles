package zalando

import scala.util.Try

object Ex2 extends App{
  def solution(a: Array[Int]): Int = {
    // 5 2 4 6 3 7
    // 5  P < Q Q-P >1     Q <N-1 7
    val MAX = a.sum
    def go(i: Int, array:Array[Int], min: Int): Int = {
     // println(i + " " + min)
      if (i <= 0 )
        return min
      val p = Try {array(i)}.toOption.getOrElse(MAX)
      val q = Try {array(i - 2)}.toOption.getOrElse(MAX)
      var s = p + q

     // println("p- " + p + " q- " + q + " sum " + s)
      if (i==array.length-1) s = MAX
      Math.min(s, go(i - 1, array, s))
    }
    // traverse in reverse direction
    // base value to return in case p,q = 0 or N : sum of all chains
    //  Tn  = Math.min(sum p + q, T(n-1))
    go(a.length-1,a, MAX)
  }


  println(solution(Array(5, 2, 4, 6, 3, 7)))
  //0 exp 5
}



