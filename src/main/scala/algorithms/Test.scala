package algorithms

object Match extends App {

  val inputArray = List[String]("[]")
  def checkValid(input: String) = {


    var stack =  scala.collection.mutable.Stack[Char]()

stack.push('0')
    val remainingStack = input.toCharArray.foldLeft(stack)((acc, element)=>{
        element match {
          case endingToken if (endingToken == ')' && acc.headOption.getOrElse("") == '(') => stack.pop()
          case endingToken if endingToken == ']'  && (acc.headOption.getOrElse("") == '[' )=> stack.pop()
          case endingToken if endingToken == '('  || endingToken == '['  => stack :+ element
        }
        stack
      })
    remainingStack.toList.isEmpty && remainingStack.head != '0'
  }

  println(inputArray.map(checkValid))
}