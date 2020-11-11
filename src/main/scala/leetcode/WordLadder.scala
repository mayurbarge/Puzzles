package leetcode

object WordLadder extends App {

  trait SingleWordTransformationSeq
  case object NotFound extends SingleWordTransformationSeq
  case class Found(combination: List[String]) extends SingleWordTransformationSeq


  def findLadders(beginWord: String, endWord: String, wordList: List[String]) = {

    val stack = scala.collection.mutable.ListBuffer[String]()
    val r = scala.collection.mutable.ListBuffer[List[String]]()

    def check(begin: String, end: String, xs: List[String], acc: List[String]): List[String] = {
      println("________ " + begin + " " + end + " " + xs + " " + acc)
      println("________* " + stack.toList + " " + r.toList)

      if(stack.isEmpty)
        acc
      else if(xs.isEmpty) {
        r += (acc :+ end)
        check(begin, end, stack.diff(begin).toList, List.empty)

      } else {
        val m = xs.filter(diff(_, begin) == 1)
        m match {
          case head:: tail => {
            stack ++ tail
            check(head,end,xs.diff(m),  acc :+ head )
          }

          case Nil => acc
        }

      }
    }

    stack += beginWord
    check(beginWord,endWord,wordList, List(beginWord))

println(r)
  }

  def diff(str1: String, str2: String) = {
    val zipped: Array[(Char, Char)] = (str1.toCharArray zip str2.toCharArray)
    zipped.foldLeft(0)((acc, e) => {
      val (a,b) = e
      if(a != b) acc + 1
      else acc
    })
  }



  println(findLadders("hit","cog", List("hot","dot","dog","lot","log","cog")))

}
