package MaximumDisplacementApp

import scala.io.StdIn

object MaximumDisplacementChecker {
  def main(args: Array[String]) {
    val numberOfTestCases = StdIn.readLine.trim.toInt
    for (i <- 0 to numberOfTestCases)
    {
      val length = StdIn.readLine.trim.toInt
      val commandString = StdIn.readLine.toList
      if(length != commandString.length) throw new Exception("Input longer than size enetered.")

      val commands = commandString.map(Command(_))
      val sum = Math.abs(Command.checkAbsoluteDisplacement(commands)) + Math.abs(Command.checkDisplacement(commands))
      println(sum)
    }
  }
}

trait Weight {
  def w: Int
}
case class Plus(w: Int) extends Weight
case class Minus(w: Int) extends Weight
case class Absolute(w: Int) extends Weight

case class Displacement(weight: List[Weight])

trait Command {
  val weight: Weight
}
trait KnownCommands extends Command
case class Left() extends KnownCommands {
  val weight = Minus(1)
}
case class Right() extends KnownCommands {
  val weight = Plus(1)
}
case class Unknown() extends Command {
  val weight = Absolute(1)
}

object Command {
  def checkDisplacement(commands: scala.collection.immutable.Seq[Command]) = {
    commands.filter(e => e.isInstanceOf[Left] || e.isInstanceOf[Right]).foldLeft(0)((acc, c) => {
      c.weight match {
        case Plus(w) => acc + w
        case Minus(w) => acc - w
      }
    })
  }
  def checkAbsoluteDisplacement(commands: scala.collection.immutable.Seq[Command]) = {
    commands.filter(_.isInstanceOf[Unknown]).foldLeft(0)((acc, c) => {
      c.weight match {
        case Absolute(w) => acc + w
      }
    })
  }

  def apply(char: Char) = char match {
    case 'L' => Left()
    case 'R' => Right()
    case '?' => Unknown()
  }
}