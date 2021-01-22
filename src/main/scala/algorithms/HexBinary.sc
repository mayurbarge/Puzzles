import scala.collection.mutable
import scala.util.Success

val arr = Array(-91, -111, -90, -44, 11)
//arr.map(_.toBinaryString)

val arr = List("abc","cba","bac")

val token = "abc"
val map = "abc".foldLeft(0)((acc,e) => {
  println(e.toByte)
  println( (1 << e.toByte-97))
 // acc | (1 << e.toByte)
  acc
})
//println(map.toBinaryString)


val l = List(1,2,3)
l :+ 4
0 :: l

l.++:(List(0))
l ++ (List(0))

l ::: List(-1, -2,-3)


val s = mutable.Stack[Int]()
s.head


val initalValue: Either[List[String], String] = Left(List.empty[String])

List(1,2,3,4).foldLeft( initalValue )((acc,e)=>{
  if( e%2 == 0 ) {
      acc match {
        case Left(value) =>   Left(e.toString :: value)
        case Right(value) => acc
      }
  } else {
    acc
  }
})

List(1,2,3,4)

def tailRecFactorial(number:Int): Int = {
  def go(current: Int, acc: Int):Int = {
    if(current == number)
      acc
    else go(current+1, acc * )
  }
  go(1, number)
}
tailRecFactorial(5)
