package recursion

object UppercaseLetterInString extends App {
  def findUppercase(input:String) = {
    def go(str: String): Char = {
      if (str.isEmpty) return ' '
      str.charAt(0) match {
        case l if l.isUpper => l
        case _ => go(str.drop(1))
      }
    }
    go(input)
  }

  println(findUppercase("geeksforgeeKs"))
  println(findUppercase("geekS"))
}
