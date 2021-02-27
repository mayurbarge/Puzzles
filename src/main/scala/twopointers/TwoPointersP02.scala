package twopointers

object TwoPointersP02 extends App {
  /*
  Move all zeros to one end, maintaining relative order of non-zero elements
  [0,1,0,3,12] ----> [1,3,12,0,0]
   */

  def moveZeros(array:Array[Int]):Array[Int] = {
    var reader, writer = 0
    while(reader < array.length) {
      if(array(reader) != 0) {
        array(writer) = array(reader)
        writer += 1
      }
      reader += 1
    }

    while(writer < array.length) {
      array(writer) = 0
      writer += 1
    }

    array
  }
  println(moveZeros(Array(0,1,0,3,12)).toList)

}
