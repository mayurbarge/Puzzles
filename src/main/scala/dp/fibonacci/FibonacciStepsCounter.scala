package dp.fibonacci

object FibonacciStepsCounter extends App {

  //Fibonnaci 1
  def stepCounter1(totalSteps: Int):Int = {
    totalSteps match {
      case 0 | 1 => 1
      case _=> stepCounter1(totalSteps-1) + stepCounter1(totalSteps-2)
    }
  }

  //Fibonnaci 2
  val fib: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).map(p => p._1 + p._2)

  //def fib4(n: Int) = fib(n)


  //Fibonnaci 3
  def memoize[A, B](f: A => B): A => B =
    new collection.mutable.WeakHashMap[A, B] {
      override def apply(a: A) = getOrElseUpdate(a, f(a))
    }

  val memofib = memoize(fib)
  memofib(8)
  //Fibonacci 4: As i decrease we calculate 0 1 1+0 1+1 and return fib(n) when i is zero
  def stepCounter(totalSteps: Int): Int = {
    def go(i:Int, prev: Int, current: Int): Int = {
      println("current index: %d".format(i))
      println("current value: %d".format(current))
      println("prev value: %d".format(prev))
      i match {
        case 0 => prev
        case _=> go(i-1, prev = current, current = prev + current)
      }
    }
    go(totalSteps, prev = 0, current = 1)
  }


  println(stepCounter1(8))
  println(stepCounter(8))

  //https://blog.genuine.com/2019/05/fibonacci-in-scala-tailrec-memoized/
  // this is memoized implementation
  println("@@@@@@@@@@@@@@@")
  val myFib: LazyList[BigInt] = BigInt(0) #:: BigInt(1) #:: myFib.zip(myFib.tail).map(e => e._1 + e._2)
  println(myFib(6))

}
