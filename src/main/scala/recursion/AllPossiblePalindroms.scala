package recursion

object AllPossiblePalindroms extends App {
  def isPalindrome(str: String): Boolean = {
    if (str.length == 1) return true

    if (str.charAt(0) == str.charAt(str.length - 1)) {
      isPalindrome(str.drop(1).dropRight(1))
    } else {
      false
    }
  }

  def getPalindromes(input: String): List[String] = {
    def go(str:String, result: List[String]): List[String] = {
      if (str.length == 1)
        return result :+ str
      if (str.charAt(0) == str.charAt(str.length - 1)) {
        // case 1 : string is palindrome
        go(str.drop(1).dropRight(1), result :+ str :+ str.charAt(0).toString)
      } else {
        // case 2: traverse by removing left subtree
        if(str.drop(1).charAt(0) == str.drop(0).charAt(str.length-2))
          go(str.drop(1), result :+ str.charAt(0).toString)
        else if(str.dropRight(1).charAt(0) == str.dropRight(0).charAt(str.length-2)) {
          // case 3: traverse by removing right subtree
          go(str.dropRight(1), result :+ str.charAt(str.length-1).toString)
        }
        else {
          go(str.drop(0)dropRight(1), result :+ str.charAt(0).toString :+ str.charAt(str.length-1).toString)
        }
      }
    }
    go(input, List.empty[String])
  }




  println(isPalindrome("nitin"))
  println(getPalindromes("nitin"))
  println(isPalindrome("abaab"))
  println(getPalindromes("abaab"))
  println(getPalindromes("xyzbaabs"))
}

  /**
   * Initial Values : i= 0, j= n-1;

CountPS(i,j)
// Every single character of a string is a palindrome
// subsequence
if i == j
   return 1 // palindrome of length 1

// If first and last characters are same, then we
// consider it as palindrome subsequence and check
// for the rest subsequence (i+1, j), (i, j-1)
Else if (str[i] == str[j)]
   return   countPS(i+1, j) + countPS(i, j-1) + 1;

else
   // check for rest sub-sequence and  remove common
   // palindromic subsequences as they are counted
   // twice when we do countPS(i+1, j) + countPS(i,j-1)
   return countPS(i+1, j) + countPS(i, j-1) - countPS(i+1, j-1)

   */