package recursion

object ReverseAList extends App {
  /**
   * Given a stack, reverse the items without creating any additional data structures.
   * eg.reverse(1->2->3) = 3->2->1
   */
  def reverseStack(stack: List[Int]): List[Int] = {
    def go(s: List[Int]):List[Int] = {
      s match {
        case h :: t => (go(t)) ::: h :: Nil
        case Nil => s
      }
    }
    go(stack)
  }
  val reverse = List(1,2,4).foldLeft(Nil.asInstanceOf[List[Int]])((acc,e) => {e +: acc})
  println(reverse)
  println(reverseStack(List(1,2,3)))

}
