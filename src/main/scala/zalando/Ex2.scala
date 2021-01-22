package zalando

object Ex2 extends App{
  def solution(a: Array[Int]): Int = {
    // 5 2 4 6 3 7
    // 5  P < Q Q-P >1     Q <N-1 7




    def go(p: Int, q: Int, array:Array[Int], min: Int): Int = {
      println(list + " min " + min)

      if(list.isEmpty)
        return min

      if(array(p) + array(q) <= min)
        Math.min(go(p,q, list.tail, p1+q1)
      else
        go(p,q,)

    }
    go(1,3, Array(5, 2, 4, 6, 3,7).toList, Int.MaxValue)
  }
  println(solution(Array(5, 2, 4, 6, 3, 7)))
  //0 exp 5
}



