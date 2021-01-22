package hackerrank.jan21

object P01 extends App {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    val cache = pieces.map(e => e.head -> e).toMap

    def pred(source: Array[Int], dest:Array[Int]) = {
      (source zip dest).map(a => a._1==a._2).reduce(_ && _)
    }
    def go(input: Array[Int], finalR: Boolean): Boolean = {
      input.headOption match {
        case Some(_) => {
          val cachedResult = cache.get(input.head)
          cachedResult match {
            case Some(c) => {
              val diff = pred(c, input.take(c.size))
              if(diff) {
                go(input.drop(c.size), true)
              } else {
                false
              }
            }
            case None => false
          }
        }
        case None => finalR
      }
    }
    go(arr, true)
  }

 println(canFormArray(Array(85,1,2), Array(Array(85))))

}
