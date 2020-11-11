package hackerrank

object Triplets extends App {

  // Complete the compareTriplets function below.
  def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
    val r = (a zip b).foldLeft((0,0): Tuple2[Int,Int])((acc, tuple) => {
      tuple match {
        case (a,b) if a ==b => acc
        case (a,b) if a >b => (1 + acc._1, acc._2)
        case (a,b) if a < b => (acc._1, acc._2 + 1)
      }
    })
    Array(r._1, r._2)
  }

  println("################")
  val x = Triplets.compareTriplets(Array(5,6,7),Array(3,6,10))
  println(x.toList)
}


