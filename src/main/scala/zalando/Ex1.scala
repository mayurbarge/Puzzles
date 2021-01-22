package zalando

object Ex1 extends App {
  def solution(s: String): Int = {
    // write your code in Scala 2.12
    // c 3, a 2, f2 d 2 e 3
    //

    val N = s.length

    var indexCounts = scala.collection.mutable.Map[Char, Int]()


    for(i <- 0 to N-1) {
      indexCounts.get(s.charAt(i)) match {
        case Some(count) => {
          if(indexCounts.values.toList.size == 1) {
            indexCounts += (s.charAt(i) -> (count+1))
          }
          if(indexCounts.values.toList.size > 1 &&
            !indexCounts.values.toList.contains(count+1)) {
            indexCounts += (s.charAt(i) -> (count+1))
          }
        }
        case None => {
          indexCounts += (s.charAt(i) -> 1)
        }
      }
    }
    N - indexCounts.values.toList.distinct.sum
  }
  println(solution("ccaaffddecee"))
  //6


}

