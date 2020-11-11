import java.util
import java.util.Comparator

def parkingSpaces(parkingStartEndTimes: Array[Int][Int]) = {
  val sorted = util.Arrays.sort(parkingStartEndTimes, new Comparator[List[Int]] {
    override def compare(o1: List[Int], o2: List[Int]) = o1(0)-o2(0)
  })
  println(sorted)
}
