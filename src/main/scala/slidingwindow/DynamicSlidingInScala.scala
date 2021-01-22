package slidingwindow

object SlidingInScala extends App {
/*
    extract neighbours in a List who differ by 1.
  val input = List(1,2,3,7,8,10,13,14)
  //By extracting I want to get:
  List(
    List(1,2,3),
    List(7,8),
    List(10),
    List(13,14)
  )

 */

  val oldList = List(1, 2, 3, 7, 8, 10, 13, 14)

  val newList = oldList.foldRight[List[List[Int]]](Nil)((a, b) => b match {
    case (bh @ bhh :: _) :: bt if (bhh - a == 1) => {
      println(bh)
      (a :: bh) :: bt
    }
    case _ => (a :: Nil) :: b
  })
  println(newList)
}
