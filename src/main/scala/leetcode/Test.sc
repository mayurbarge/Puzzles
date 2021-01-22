val x = 16
val y = 12
var z = 0

z = x & y
println("Bitwise And of x & y = " + z)

z = x | y
println("Bitwise Or of x | y = " + z)

z = x ^ y
println("Bitwise Xor of x ^ y = " + z)

object Solution {

  def queryString(S: String, N: Int): Boolean = {
    import scala.collection.parallel.CollectionConverters._
    (1 to N).toList.par.map(e => S.contains(e.toBinaryString)).reduce(_ && _)
  }

}
